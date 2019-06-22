package rsmouki.example.com.interviewapplication;

import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import rsmouki.example.com.Database.MyDatabase;
import rsmouki.example.com.Database.QuestionData;

public class GameScreen extends AppCompatActivity {

    private  static final String TAG="GameScreen";
    static Dialog myDialog;


    String[] operators = new String[]  {"plus","min","mult","div"};
    String mode = "easy",operator;
    private MyDatabase dbInstance;
    Button ans1,ans2,ans3,ans4;
    TextView question;
    TextView mTextField;
    QuestionData questionData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        myDialog = new Dialog(this);

        ans1 = findViewById(R.id.answer1);
        ans2 = findViewById(R.id.answer2);
        ans3 = findViewById(R.id.answer3);
        ans4 = findViewById(R.id.answer4);
        mTextField = findViewById(R.id.countdown);

        question = findViewById(R.id.question);

        try {
            if(!(getIntent()==null)) {
                mode = getIntent().getStringExtra("mode");
                operator = getIntent().getStringExtra("operator");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        dbInstance = Room.databaseBuilder(this,
                MyDatabase.class, "QuestionData")
                .allowMainThreadQueries()
                .build();
        questionData = loadDataFromDatabase();
        if(questionData==null){
            Toast.makeText(this,"no data found",Toast.LENGTH_LONG).show();
        }else {
            question.setText(questionData.qd + "  ?");
            ans1.setText(questionData.response1);
            ans2.setText(questionData.response2);
            ans3.setText(questionData.response3);
            ans4.setText(questionData.response4);
        }
        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                mTextField.setText("Time out, You lose ...");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // Actions to do after 10 seconds
                        Intent i = new Intent(getApplicationContext(),ChooseOperator.class);
                        i.putExtra("mode", mode);
                        startActivity(i);
                        finish();
                    }
                }, 2000);
            }

        }.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(this,ChooseOperator.class);
                i.putExtra("mode", mode);
                startActivity(i);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void answer1(View view) {
        if(checkAnswer(1,view)){

        }else{
            Toast.makeText(this,"Please try again",Toast.LENGTH_LONG).show();
        }
    }

    public void answer2(View view) {
        if(checkAnswer(2,view)){

        }else{
            Toast.makeText(this,"Please try again",Toast.LENGTH_LONG).show();
        }
    }

    public void answer3(View view) {
        if(checkAnswer(3,view)){

        }else{
            Toast.makeText(this,"Please try again",Toast.LENGTH_LONG).show();
        }
    }

    public void answer4(View view) {
        if(checkAnswer(4,view)){

        }else{
            Toast.makeText(this,"Please try again",Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkAnswer(int Resnumber,View v) {
        if(Resnumber == 1){
        if(questionData.RealAnswer.equals(questionData.response1)){
            ShowPopup(v);
            return true;
        }else
        {
            return false;
        }
        }
        else  if(Resnumber == 2){
                if(questionData.RealAnswer.equals(questionData.response2)){
                    ShowPopup(v);
                    return true;
                }else {
                    return false;
                }
            }
            else if(Resnumber == 3){
                if(questionData.RealAnswer.equals(questionData.response3)){
                    ShowPopup(v);
                    return true;
                }else {
                    return false;
                }
            }
        else if(Resnumber == 4){
                if(questionData.RealAnswer.equals(questionData.response4)){
                    ShowPopup(v);
                    return true;
                }else {
                    return false;
                }
            }
        else
        {
            return false;
        }

    }

    QuestionData loadDataFromDatabase() {
        dbInstance = Room.databaseBuilder(this,
                MyDatabase.class, "QuestionData")
                .allowMainThreadQueries()
                .build();
        /* To query all records */
        Log.d(TAG, " fetching data from database :");
        List<QuestionData> qds = dbInstance.QuestionDataDao().getQuestionDatas(mode,operator);
        if(qds.size()>0){
            QuestionData qd = qds.get(new Random().nextInt(qds.size()));
            return qd;
        }
        return null;
    }

    public static void ShowPopup(View v) {
        TextView txtclose;
        Button btnNext;
        myDialog.setContentView(R.layout.pop_up);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        btnNext = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setText("X");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void tryAgain(View view) {
        Intent i = new Intent(this,ChooseOperator.class);
        i.putExtra("mode", mode);
        startActivity(i);
        finish();
    }
}
