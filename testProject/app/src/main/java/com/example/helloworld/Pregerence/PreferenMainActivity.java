package com.example.helloworld.Pregerence;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class PreferenMainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new TestPreference()).commit();
    }
}
