package com.example.executorandhandlertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private static final int COUNT_PER_SECOND = 0;

    TextView textView;
    Handler handler;

    @SuppressLint({"MissingInflatedId", "HandlerLeak"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        ExecutorService es = Executors.newSingleThreadExecutor();
        // ExecutorService es = Executors.newFixedThreadPool(3);
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case COUNT_PER_SECOND :
                        Bundle bd = msg.getData();
                        int value = bd.getInt("Count_Num");
                        textView.setText("현재 숫자 : " + value);
                }
            }
        };

        findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                es.submit(() -> {
                    for (int i = 0; i < 100; i++) {
                        Message msg = handler.obtainMessage();
                        Bundle bd = new Bundle();

                        bd.putInt("Count_Num", i);
                        msg.setData(bd);
                        msg.what = COUNT_PER_SECOND;
                        handler.sendMessage(msg);

                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            Log.d("Thread", "Thread.sleep Error!");
                        }

                    }
                });
            }
        });
    }
}