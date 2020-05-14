package com.tanay.thunderbird.showingandhidinguielements;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button showButton;
    Button hideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        showButton = (Button)findViewById(R.id.showButton);
        hideButton = (Button)findViewById(R.id.hideButton);

        showButton.setOnClickListener(this);
        hideButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.showButton: {
                textView.setVisibility(View.VISIBLE);
                break;
            }

            case R.id.hideButton: {
                textView.setVisibility(View.INVISIBLE);
                break;
            }
        }
    }
}



