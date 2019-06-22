package rsmouki.example.com.interviewapplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.github.ybq.android.spinkit.style.ChasingDots;

import java.util.List;
import java.util.Random;

import rsmouki.example.com.Database.MyDatabase;
import rsmouki.example.com.Database.QuestionData;

public class LoadingActivity extends AppCompatActivity {

    private ChasingDots mChasingDotsDrawable;
    private MyDatabase dbInstance;
    private  static final String TAG="LoadingScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        dbInstance = Room.databaseBuilder(this,
                MyDatabase.class, "QuestionData")
                .allowMainThreadQueries()
                .build();

        //ImageView
        ImageView imageView = (ImageView) findViewById(R.id.loadingImage);
        mChasingDotsDrawable = new ChasingDots();
        mChasingDotsDrawable.setColor(Color.WHITE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // Actions to do after 2 seconds
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);

        loadDataFromDatabase();


    }

    void loadDataFromDatabase() {
        addDataToDatabase();
        /*dbInstance = Room.databaseBuilder(this,
                MyDatabase.class, "QuestionData")
                .allowMainThreadQueries()
                .build();
        Log.d(TAG, " fetching data from database :");
        List<QuestionData> qds = dbInstance.QuestionDataDao().getAllQuestionDatas();
        if(qds.size()==0){
            addDataToDatabase();
        }*/
    }

    // insert data into database
    private void addDataToDatabase() {

        QuestionData qd;

        qd = new QuestionData(
                "hard","4.2.2","what is the operand",
                "","+","-","*","/"
        );

        Log.d(TAG, "datatostore ...");
        Log.d(TAG,qd.toString());

        dbInstance.QuestionDataDao().addQuestionData(qd);
///////////////////////////////////////////////////////////////////
        qd = new QuestionData(
                "hard","plus","4+2+2",
                "8","15","8","10","20"
        );

        Log.d(TAG, "datatostore ...");
        Log.d(TAG,qd.toString());

        dbInstance.QuestionDataDao().addQuestionData(qd);
///////////////////////////////////////////////////////////////////
        qd = new QuestionData(
                "hard","div","4/2/2",
                "1","0","4","2","1"
        );

        Log.d(TAG, "datatostore ...");
        Log.d(TAG,qd.toString());

        dbInstance.QuestionDataDao().addQuestionData(qd);
///////////////////////////////////////////////////////////////////
        qd = new QuestionData(
                "hard","min","10-2-2",
                "6","6","7","6","8"
        );

        Log.d(TAG, "datatostore ...");
        Log.d(TAG,qd.toString());

        dbInstance.QuestionDataDao().addQuestionData(qd);

///////////////////////////////////////////////////////////////////
        qd = new QuestionData(
                "easy","plus","4+4","8"
                ,"7","6","10","8"
        );

        Log.d(TAG, "datatostore ...");
        Log.d(TAG,qd.toString());

        dbInstance.QuestionDataDao().addQuestionData(qd);
///////////////////////////////////////////////////////////////////
        qd = new QuestionData(
                "easy","plus","what is the operator","+"
                ,"-","*","/","+"
        );

        Log.d(TAG, "datatostore ...");
        Log.d(TAG,qd.toString());

        dbInstance.QuestionDataDao().addQuestionData(qd);
    }


}
