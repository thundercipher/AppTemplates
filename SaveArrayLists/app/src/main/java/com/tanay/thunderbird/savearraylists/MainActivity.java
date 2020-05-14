package com.tanay.thunderbird.savearraylists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = this.getSharedPreferences("com.tanay.thunderbird.savearraylists", Context.MODE_PRIVATE);

        ArrayList<String> friends = new ArrayList<>();
        friends.add("Monica");
        friends.add("Chandler");

        try
        {
            preferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        ArrayList<String> newFriends = new ArrayList<>();
        try
        {
            newFriends = (ArrayList<String>)ObjectSerializer.deserialize(preferences.getString("friends", ObjectSerializer.serialize(new ArrayList<String>())));   // in the default, we add a new empty ArrayList as if we leave it as an empty string, it would cause an error if we try to deserialize it
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        Log.i("newFriends: ", newFriends.toString());
    }
}
