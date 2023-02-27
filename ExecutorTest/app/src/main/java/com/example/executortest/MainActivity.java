package com.example.executortest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExecutorService ec = Executors.newFixedThreadPool(2);

        ExecutorService ec1 = Executors.newSingleThreadExecutor();

        // executor(싱글) 1씩증가 + 핸들러 사용해서 ui 에 보내기

        findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {

            Callable<Integer> task = () -> {
              return 123;
            };

            @Override
            public void onClick(View view) {
                Thread[] threads = threadSetting();

                ec.execute(threads[0]);
                ec.execute(threads[1]);
                ec.execute(threads[2]);

                try {
                    while (!ec.awaitTermination(5, TimeUnit.SECONDS)) {
                        ec.shutdown();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                Future<Integer> future = ec.submit(task);
                try {
                    Integer i = future.get();
                    Log.d("future", "i = " + i);

                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

    }

    private Thread[] threadSetting() {
        Thread[] threads = new Thread[10];
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0 ; i < 100; i++) {
                    Thread.sleep(1000);
                    Log.d("Thread1", "Thread_1 : " + i);

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads[0] = t1;

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0 ; i < 100; i++) {
                    Thread.sleep(1000);
                    Log.d("Thread2", "Thread_2 : " + i);

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads[1] = t2;

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0 ; i < 100; i++) {
                    Thread.sleep(1000);
                    Log.d("Thread3", "Thread_3 : " + i);

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threads[2] = t3;

        return threads;
    }

}

