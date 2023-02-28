package com.example.executorandhandler1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    Handler runOnUiThread = new Handler(Looper.getMainLooper());
    ExecutorService runOnBackgroundThread = Executors.newSingleThreadExecutor();
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.text_view);
        btn = (Button) findViewById(R.id.btn01);

        btn.setOnClickListener((btnView) -> {
            runOnBackgroundThread.submit(() -> {
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(1 * 1000);
                        increaseCounter();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

    }

    private void increaseCounter() {
        counter++;
        runOnUiThread.post(() -> {
            tv.setText(String.valueOf(counter));
        });
    }
}