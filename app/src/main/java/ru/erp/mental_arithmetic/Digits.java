package ru.erp.mental_arithmetic;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Digits extends AppCompatActivity {

    public TextView TextLevel;
    private int DigitNumber = 0;
    ProgressBar mPrograssBar;
    public int ProgressCirc;
    public TextView mTextProgress;
    public Timer timer;

    public int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digits);
        ProgressCirc = 4;
        mTextProgress = (TextView)findViewById(R.id.textViewProgress);
        mPrograssBar = (ProgressBar)findViewById(R.id.circular_progress_bar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        final ObjectAnimator anim = ObjectAnimator.ofInt(mPrograssBar, "progress", 80, 0);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.setDuration(4000);

        anim.start();

        level = getIntent().getIntExtra("gameLevel", 0);
        TextLevel = (TextView) findViewById(R.id.texNumbers);

        DigitNumber = 0;

        Arithmetics.SumNumbers(level);



        new CountDownTimer(5000, 1250) {

            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
            public void onTick(long millisUntilFinished) {
                ProgressCirc -= 1;
                mTextProgress.setText(Integer.toString(ProgressCirc));

            }

            //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
            public void onFinish() {
                mTextProgress.setVisibility(View.GONE);
                mPrograssBar.setVisibility(View.GONE);
                TextLevel.setVisibility(View.VISIBLE);
                timer = new Timer();

                timer.schedule(new DigitsON(), 100);

            }

        }.start();

    }

    @Override
        public void onBackPressed(){

        if (timer != null){
            timer.cancel();
        }
        Intent intent = new Intent(Digits.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    class DigitsON extends TimerTask {

        @Override
        public void run() {

            DigitNumber++;

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextLevel.setText(Integer.toString(Arithmetics.Numb[DigitNumber - 1]));
                }
            });

            timer = new Timer();
            timer.schedule(new DigitsOFF(), Arithmetics.intervalArray[level] * 10);

        }
    }

    class DigitsOFF extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextLevel.setText("");
                }
            });

            if (DigitNumber < Arithmetics.numbersArray[level]) {
                timer = new Timer();
                timer.schedule(new DigitsON(), 100);
            } else {
                Intent intent = new Intent(Digits.this, Rezult.class);
                intent.putExtra("level", level);
                startActivity(intent);
                finish();

            }
        }

    }

}