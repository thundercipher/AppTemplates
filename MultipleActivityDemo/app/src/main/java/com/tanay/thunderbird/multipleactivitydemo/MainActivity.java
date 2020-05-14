package com.tanay.thunderbird.multipleactivitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // fn to jump back and forth
    public void jumpToSecond(View view)
    {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        intent.putExtra("username", "thunderbird");

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
