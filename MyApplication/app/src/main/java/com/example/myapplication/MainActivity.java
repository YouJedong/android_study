package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_btn = findViewById(R.id.btn01);
        start_btn.setOnClickListener(this);
        Button stop_btn = findViewById(R.id.btn02);
        stop_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ServiceTest.class);
        switch(view.getId()) {
            case R.id.btn01:
                startService(intent);
                break;
            case R.id.btn02:
                stopService(intent);
                break;
        }
    }
}