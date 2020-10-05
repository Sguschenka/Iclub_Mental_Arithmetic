package ru.erp.mental_arithmetic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class Rezult extends AppCompatActivity {

    private Button mButton;
    private String mStr;
    private EditText mEditText;
    public int level;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezult);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
 

        mButton = (Button)findViewById(R.id.buttonCheck);
        mEditText = (EditText)findViewById(R.id.editTextCheck);
        level = getIntent().getIntExtra("level", 0);


    }

    public void onClick(View view) {


        if (mEditText.getText().equals("")){

        } else {

            Intent intent = new Intent(Rezult.this, Sum.class);
            if(Integer.toString(Arithmetics.numberSum).equals(mEditText.getText().toString())){
                intent.putExtra("Rezult", 0);

            }
            else{
                intent.putExtra("Rezult", 1);
            }
            intent.putExtra("level", level);
            startActivity(intent);
            this.finish();
        }


    }

    @Override
    public void onBackPressed(){

        Intent intent = new Intent(Rezult.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
