package com.tanay.thunderbird.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000, 1000)  // total time, "ticks" (in milliseconds)
        {
            public void onTick(long millisecondsUntilDone) //at every "tick"
            {
                Log.i("Seconds left", String.valueOf(millisecondsUntilDone/1000));
            }

            public void onFinish() //when countdown is over
            {
                Log.i("DONE!", "Countdown finished");
            }

        }.start();


        /*
        //posting every second handler
        final Handler handler = new Handler();    //allows code to be run in a delayed way

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                // code that has to be run every n second/s
                Log.i("Runnable run", "a second must've passed!");
                handler.postDelayed(this, 1000); //delay of 1000 millisec
            }
        };

        handler.post(runnable);
        */

    }
}
