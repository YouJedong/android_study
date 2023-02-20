package com.example.helloworld.Intent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class IntentActivity02 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_test02);
        Log.d("callBack", "onCreate");

        Intent intent = getIntent();
        int number = intent.getIntExtra("number", 1);

        TextView tv = findViewById(R.id.textView02);
        tv.setText(Integer.toString(number));

        EditText ev = findViewById(R.id.editText02);
        findViewById(R.id.btn02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int editNum = Integer.parseInt(ev.getText().toString());

                intent.putExtra("number", editNum);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("callBack", "onDestroy");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("callBack", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("callBack", "onPause");
    }
}
