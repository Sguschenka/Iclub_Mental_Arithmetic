package ru.erp.mental_arithmetic;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.logging.Handler;
import java.util.logging.LogRecord;


public class Loading extends AppCompatActivity {

        public ImageView Image;
        ProgressBar mPrograssBar;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        mPrograssBar = (ProgressBar)findViewById(R.id.circular_progress_bar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
      //  final ImageView Image = (ImageView) findViewById(R.id.imageView2);

        ObjectAnimator anim = ObjectAnimator.ofInt(mPrograssBar, "progress", 0, 4);
        anim.setDuration(15000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();

//        Arithmetics Game = new Arithmetics();
//        final int level = getIntent().getIntExtra("gameLevel", 0);
//
//
//        new CountDownTimer(4000, 1000) {
//
//
//
//            //Здесь обновляем текст счетчика обратного отсчета с каждой секундой
//            public void onTick(long millisUntilFinished) {
//
//            }
//
//            //Задаем действия после завершения отсчета (высвечиваем надпись "Бабах!"):
//            public void onFinish() {
//                Intent intent = new Intent(Loading.this, Digits.class);
//                intent.putExtra("level", level);
//                startActivity(intent);
//            }
//
//
//        }
//                .start();

 //         this.finish();



    }
}
