package com.example.handlertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyHandler handler;
    TextView textView;

    private static final int COUNT_PER_SECOND = 0;
    private static final int COUNT_TIMER = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text01);
        handler = new MyHandler();

        findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyThread t = new MyThread();
                t.start();
            }
        });

    }

    class MyThread extends Thread {
        @Override
        public void run() {
            Message msg = handler.obtainMessage();
            Bundle bd = new Bundle();
            bd.putInt("Count_Num", 1);
            msg.setData(bd);
            msg.what = COUNT_PER_SECOND;
            handler.sendMessage(msg);
        }
    }

    class MyHandler extends Handler {
        int value = 0;

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case COUNT_PER_SECOND:
                    Bundle bd = msg.getData();
                    value = bd.getInt("Count_Num");

                    textView.setText("현재 숫자 : " + value++);
                    this.sendEmptyMessageDelayed(COUNT_TIMER, 1000);

                    break;
                case COUNT_TIMER:
                    textView.setText("현재 숫자 : " + value++);
                    if (value <= 100) {
                        this.sendEmptyMessageDelayed(COUNT_TIMER, 1000);
                    }

            }
        }
    }

}