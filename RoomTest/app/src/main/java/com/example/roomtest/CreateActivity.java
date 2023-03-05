package com.example.roomtest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roomtest.DB.AppDatabase;
import com.example.roomtest.VO.User;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateActivity extends AppCompatActivity {

    AppDatabase db;
    EditText editText;
    ProgressBar progressBar;

    private String[] url = {
            "https://demo.ycart.kr/shopboth_farm_max5_001/data/editor/1612/cd2f39a0598c81712450b871c218164f_1482469221_493.jpg",
            "https://t1.daumcdn.net/cfile/tistory/24283C3858F778CA2E",
            "https://www.codingfactory.net/wp-content/uploads/abc.jpg",
            "https://source.unsplash.com/random",
            "https://picsum.photos/250/250",
            "https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg",
            "https://helpx.adobe.com/content/dam/help/en/photoshop/using/quick-actions/remove-background-after-qa1.png",
            "https://www.urbanbrush.net/en/wp-content/uploads/edd/2022/11/urbanbrush-20221112181833147836.jpg",
            "https://static.news.zumst.com/images/36/2020/09/29/9a2dbdaab03441a99e1cfab6ffaaa408.jpg",
            "https://cdn.aitimes.com/news/photo/202204/143854_149286_5624.png"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        progressBar = (ProgressBar) findViewById(R.id.progress_circular);

        ExecutorService es = Executors.newSingleThreadExecutor();

        Handler runOnUiThread = new Handler(Looper.getMainLooper());

        db = AppDatabase.getAppDatabase(this);

        findViewById(R.id.btn_create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = findViewById(R.id.edit_text);
                Random random = new Random();
                User user = new User();
                user.name = editText.getText().toString();

                progressBar.setVisibility(View.VISIBLE);
                es.execute(() -> {
                    user.url = db.imageDao().getImageUrl(random.nextInt(url.length - 1) + 1).imgUrl;
                    db.userDao().insert(user);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    runOnUiThread.post(() -> {
                        progressBar.setVisibility(View.GONE);
                        Intent intent = new Intent(CreateActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    });
                });
            }
        });


    }
}
