package com.tanay.thunderbird.splitscreendemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig)
    {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);

        //called when the multi window mode changes
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isInMultiWindowMode())
        {

        }

        if(isInPictureInPictureMode())
        {

        }
    }
}
