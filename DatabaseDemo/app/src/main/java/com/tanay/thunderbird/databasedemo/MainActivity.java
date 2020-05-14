package com.tanay.thunderbird.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try
        {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
            //myDatabase.execSQL("INSERT  INTO users (name, age) VALUES ('Arvind', 64)");
            //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Deepti', 55)");
            myDatabase.execSQL("DELETE FROM users WHERE name = 'Tanay'");                             // command to delete a tuple
            myDatabase.execSQL("UPDATE users SET age = 20 WHERE name = 'Tanuj'");                     // command to update a tuple

            // now to fetch the data out of the database, cursor allows us to loop through all the particular results of a query and do something with them
            // Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age < 30", null);         // for null, there exists a signal/method that can cancel a query in progress
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name = 'Tanay' AND age = 20", null);
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'T%'", null);      //for names starting with T
            Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'T%' LIMIT 1", null);      //to display just one name

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            c.moveToFirst();

            while(c != null)
            {
                Log.i("UserResults - Name", c.getString(nameIndex));
                Log.i("UserResults - Age", Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();
            }
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
