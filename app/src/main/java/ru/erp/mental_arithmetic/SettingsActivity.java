package ru.erp.mental_arithmetic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    private CheckBox mCheckBox;
    private int interval;
    private Spinner mSpinnerRazr;
    static public Spinner mSpinnerKol;
    private SeekBar mSeekBarSpeed;
    static int kol;

    private SharedPreferences mSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mCheckBox = (CheckBox)findViewById(R.id.checkBoxNegative);
        mSpinnerRazr = (Spinner)findViewById(R.id.spinnerR);
        mSpinnerKol = (Spinner)findViewById(R.id.spinnerK);


        interval = 109;


        final SeekBar mSeekBarSpeed = (SeekBar)findViewById(R.id.seekBarSpeed);
            mSeekBarSpeed.setProgress(109-Arithmetics.intervalArray[3]);
            mCheckBox.setChecked(Arithmetics.negativesArray[3]);
            mSpinnerRazr.setSelection(Arithmetics.numbersLengthArray[3] - 1);
            mSpinnerKol.setSelection(kol);

        mSeekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


                interval = 109 - seekBar.getProgress();

            }
        });

    }



    public void onClick(View view) {

        kol = mSpinnerKol.getSelectedItemPosition();
        Arithmetics.numbersLengthArray[3] = 1 + mSpinnerRazr.getSelectedItemPosition();
        Arithmetics.numbersArray[3] = Integer.valueOf(mSpinnerKol.getSelectedItem().toString());

        if(mCheckBox.isChecked())
            Arithmetics.negativesArray[3] = true;
        else Arithmetics.negativesArray[3] = false;

        Arithmetics.intervalArray[3] = interval;


        Intent intent = new Intent(SettingsActivity.this, Digits.class);
        intent.putExtra("gameLevel", 3);
        startActivity(intent);
        finish();


    }
}
