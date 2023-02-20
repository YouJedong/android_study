package com.example.helloworld.Pregerence;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.helloworld.R;

public class TestPreference extends PreferenceFragment implements OnSharedPreferenceChangeListener {
    SharedPreferences sp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("callback", "onCreate: y");

        addPreferencesFromResource(R.xml.preferences);
        sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("callback", "onResume: y");
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Toast.makeText(getActivity(), sp.getString("id", ""), Toast.LENGTH_SHORT).show();
    }
}
