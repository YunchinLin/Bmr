package bess.com.bmr;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bHelp = (Button) findViewById(R.id.b_help);
        bHelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("資訊")
                        .setMessage("基礎代謝率(BMR)是指我們在安靜狀態下(通常為靜臥狀態)消耗的最低熱量，人的其他活動都建立在這個基礎上。")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }

    public void bmr(View view){
        EditText edGender = (EditText) findViewById(R.id.ed_gender);
        EditText edWeight = (EditText) findViewById(R.id.ed_weight);
        EditText edHeight = (EditText) findViewById(R.id.ed_height);
        EditText edAge = (EditText) findViewById(R.id.ed_age);
        int gender = Integer.parseInt(edGender.getText().toString());
        float weight= Float.parseFloat(edWeight.getText().toString());
        float height= Float.parseFloat(edHeight.getText().toString());
        int age = Integer.parseInt(edAge.getText().toString());
        if (gender == 1){
            float bmr = (float)((13.7 * weight) + (5.0 * height) - (6.8 * age) + 66);
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmr_is)+bmr)
                    .setTitle(R.string.bmr_title)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }else if(gender == 0){
            float bmr = (float)((9.6 * weight) + (1.8 * height) - (4.7 * age) + 655);
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_bmr_is)+bmr)
                    .setTitle(R.string.bmr_title)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        }else{
            Toast.makeText(this, "請依照指示輸入資料", Toast.LENGTH_LONG).show();
        }
    }
}