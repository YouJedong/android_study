package com.example.helloworld.LifeCycle;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class TestMain extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("MainCycle", "onCreate");
        super.onCreate(savedInstanceState);

        setContentView(R.layout.life_cycle_main);

        findViewById(R.id.lifecycle_Main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestMain.this, TestSub.class);

                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Log.d("Result", "onActivityResult");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainCycle", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainCycle", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainCycle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainCycle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainCycle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainCycle", "onDestroy");
    }
}
