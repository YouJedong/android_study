package com.example.activitytasktest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class B_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        findViewById(R.id.buttonBtoA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(B_Activity.this, A_Activity.class);

                startActivity(i);
            }
        });
        findViewById(R.id.buttonBtoC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(B_Activity.this, C_Activity.class);

                startActivity(i);
            }
        });
    }
}