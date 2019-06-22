package rsmouki.example.com.interviewapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ChooseOperator extends AppCompatActivity {

    String mode = "easy";
    Button mult,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_operator);

        mult = findViewById(R.id.chooseMult);
        div = findViewById(R.id.chooseDiv);

        try {
            if(!(getIntent()==null)) {
                mode = getIntent().getStringExtra("mode");
                if(mode.equals("easy")){
                    mult.setVisibility(View.GONE);
                    mult.setClickable(false);
                    div.setVisibility(View.GONE);
                    div.setClickable(false);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(this,HomeActivity.class);
                startActivity(i);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void chooseMIN(View view) {
        Intent i = new Intent(this,GameScreen.class);
        i.putExtra("mode",mode);
        i.putExtra("operator","min");
        startActivity(i);
        finish();
    }

    public void chooseDiv(View view) {
        Intent i = new Intent(this,GameScreen.class);
        i.putExtra("mode",mode);
        i.putExtra("operator","div");
        startActivity(i);
        finish();
    }

    public void chooseAdd(View view) {
        Intent i = new Intent(this,GameScreen.class);
        i.putExtra("mode",mode);
        i.putExtra("operator","plus");
        startActivity(i);
        finish();
    }

    public void chooseMult(View view) {
        Intent i = new Intent(this,GameScreen.class);
        i.putExtra("mode",mode);
        i.putExtra("operator","mult");
        startActivity(i);
        finish();
    }
}
