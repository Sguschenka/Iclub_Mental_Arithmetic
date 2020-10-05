package ru.erp.mental_arithmetic;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Sum extends AppCompatActivity {

    TextView mTextView;
    ImageButton mImageButton;
    TextView mTextView2;
    ImageView mImageViewRezTrue;
    ImageView mImageViewRezCross;

    public int level;
    private SharedPreferences mSettings;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);
        level = getIntent().getIntExtra("level", 0);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        mTextView = (TextView)findViewById(R.id.textViewRez);
        mTextView2 = (TextView)findViewById(R.id.textViewRez2);
        mImageButton = (ImageButton)findViewById(R.id.imageButtonBack);
        mImageViewRezTrue = (ImageView)findViewById(R.id.imageViewTrue);
        mImageViewRezCross = (ImageView)findViewById(R.id.imageViewCross);
        mSettings = getSharedPreferences(MainActivity.APP_PREFERENCES, Context.MODE_PRIVATE);


        int rezult = getIntent().getIntExtra("Rezult", 0);
        if (rezult == 0){
            mTextView.setText("Верно!");
            Arithmetics.cointPoints(level);
            mTextView2.setText("Баллы, которые вы заработали: " + Integer.toString(Arithmetics.coint));
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putInt(MainActivity.APP_PREFERENCES_POINT, Arithmetics.cointSum);
            editor.apply();



        }
        else {
            mTextView.setText("Неправильно!");
            mTextView2.setText("Правильный ответ: " + Arithmetics.numberSum);
            mImageViewRezTrue.setVisibility(View.GONE);
            mImageViewRezCross.setVisibility(View.VISIBLE);

        }

    }


    public void onClick(View view) {
        Intent intent = new Intent(Sum.this, MainActivity.class);
        startActivity(intent);
 //       savePOINTS();
        finish();
    }

    public void onClickRestart(View view) {
        Intent intent = new Intent(Sum.this, Digits.class);
        intent.putExtra("gameLevel", level);
        startActivity(intent);
 //       savePOINTS();
        finish();

    }

    @Override
    public void onBackPressed(){

        Intent intent = new Intent(Sum.this, MainActivity.class);
        startActivity(intent);
        finish();
    }




}
