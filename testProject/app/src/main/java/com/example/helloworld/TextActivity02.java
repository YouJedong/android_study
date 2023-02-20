package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TextActivity02 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test02);

        Intent intent = new Intent(this.getIntent());
        int number = intent.getIntExtra("number", -1);

        TextView tv = findViewById(R.id.test_02);
        tv.setText(number);



    }


}
