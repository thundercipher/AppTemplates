package com.tanay.thunderbird.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.tanay.thunderbird.sharedpreferencesdemo", MODE_PRIVATE);
        sharedPreferences.edit().putString("username", "thunderbird").apply();

        String username = sharedPreferences.getString("username", "");
        Log.i("Username: ", username);
    }
}
