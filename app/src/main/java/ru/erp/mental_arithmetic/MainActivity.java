package ru.erp.mental_arithmetic;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView SumPoints;
    public Arithmetics ArithGame;
    SharedPreferences sPref;
    final String SAVED_POINT = "saved_coint";
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_POINT = "points";
    private SharedPreferences mSettings;
   //



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        Arithmetics.cointSum = mSettings.getInt(APP_PREFERENCES_POINT, 0);
        TextView SumPoints = (TextView) findViewById(R.id.textSumP);


        SumPoints.setText(Integer.toString(Arithmetics.cointSum));
    }

    public void onClickSettings(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickEasy(View view) {
        Intent intent = new Intent(MainActivity.this, Digits.class);
        intent.putExtra("gameLevel", 0);
        startActivity(intent);
        finish();
    }

    public void onClickMedium(View view) {
        Intent intent = new Intent(MainActivity.this, Digits.class);
        intent.putExtra("gameLevel", 1);
        startActivity(intent);
        finish();
    }

    public void onClickHard(View view) {
        Intent intent = new Intent(MainActivity.this, Digits.class);
        intent.putExtra("gameLevel", 2);
        startActivity(intent);
        finish();
    }

    public void onClickInfo(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("О приложении")
                .setMessage("Версия 1.0 © UCMAS Россия. Приложение было разработано студией fineLet")
                .setNegativeButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }

                });
        AlertDialog alert = builder.create();
        alert.show();
    }




}

