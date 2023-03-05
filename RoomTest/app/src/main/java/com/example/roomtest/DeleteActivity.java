package com.example.roomtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.roomtest.DB.AppDatabase;
import com.example.roomtest.VO.User;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeleteActivity extends AppCompatActivity {
    AppDatabase db;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        ExecutorService es = Executors.newSingleThreadExecutor();

        db = AppDatabase.getAppDatabase(this);

        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText = findViewById(R.id.edit_text);

                String name = editText.getText().toString();

                es.execute(() -> {
                    db.userDao().delete(name);
                });

                Intent intent = new Intent(DeleteActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });


    }
}
