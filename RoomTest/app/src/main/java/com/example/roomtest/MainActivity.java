package com.example.roomtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.roomtest.DB.AppDatabase;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);

                startActivity(intent);
            }
        });
        findViewById(R.id.btn_create_form).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_delete_form).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                startActivity(intent);
            }
        });




    }
}