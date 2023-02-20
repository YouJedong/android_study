package com.example.helloworld.Intent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.R;

public class IntentActivity01 extends AppCompatActivity {
    protected static final int NUMBER_TRANSER = 100;

    protected void onCreate(Bundle savedInstanceState) {
        Log.d("callBack", "onCreate1");

        super.onCreate(savedInstanceState);

        setContentView(R.layout.intent_test01);

        EditText ev = findViewById(R.id.editText01);
        findViewById(R.id.btn01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int editNum = Integer.parseInt(ev.getText().toString());

                Intent intent = new Intent(IntentActivity01.this, IntentActivity02.class);

                intent.putExtra("number", editNum);

                startActivityForResult(intent, NUMBER_TRANSER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView tv = findViewById(R.id.textView01);
        if (resultCode == RESULT_OK && requestCode == NUMBER_TRANSER) {
            int number = data.getIntExtra("number", -1);
            tv.setText(Integer.toString(number));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("callBack", "onDestroy1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("callBack", "onResume1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("callBack", "onPause1");
    }
}
