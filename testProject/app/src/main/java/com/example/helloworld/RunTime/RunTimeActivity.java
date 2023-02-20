package com.example.helloworld.RunTime;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.helloworld.MainActivity;
import com.example.helloworld.R;

public class RunTimeActivity extends AppCompatActivity {
    private static final int READ_CONTACTS = 3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.runtime_main);

        findViewById(R.id.runtime_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PackageManager.PERMISSION_GRANTED != checkSelfPermission(Manifest.permission.READ_CONTACTS)) {

                    Toast.makeText(getApplicationContext(), "설정창", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, READ_CONTACTS);

                } else {
                    Toast.makeText(getApplicationContext(), "이미 수락됨", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case READ_CONTACTS :
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "수락함", Toast.LENGTH_SHORT).show();
                } else if (!shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
                    Toast.makeText(getApplicationContext(), "앱 설정에서 허용해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "설정창", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, READ_CONTACTS);
                }
                break;

        }
    }
}
