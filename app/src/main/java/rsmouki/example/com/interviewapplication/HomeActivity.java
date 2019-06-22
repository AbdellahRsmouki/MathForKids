package rsmouki.example.com.interviewapplication;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    Button chooseEasy, chooseHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_home);

        chooseEasy = findViewById(R.id.chooseEasy);
        chooseHard = findViewById(R.id.chooseHard);



    }

    private void setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    public void chooseEasy(View view) {
        Intent i = new Intent(this,ChooseOperator.class);
        i.putExtra("mode", "easy");
        startActivity(i);
        finish();
    }

    public void chooseHard(View view) {
        Intent i = new Intent(this,ChooseOperator.class);
        i.putExtra("mode", "hard");
        startActivity(i);
        finish();
    }
}
