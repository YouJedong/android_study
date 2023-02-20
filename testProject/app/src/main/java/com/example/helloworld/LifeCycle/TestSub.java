package com.example.helloworld.LifeCycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class TestSub extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("SubCycle", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_cycle_sub);

        Intent intent = getIntent();
        findViewById(R.id.lifecycle_Sub_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("SubCycle", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("SubCycle", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("SubCycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("SubCycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("SubCycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SubCycle", "onDestroy");
    }
}
