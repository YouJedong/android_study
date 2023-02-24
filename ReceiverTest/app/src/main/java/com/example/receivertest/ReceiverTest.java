package com.example.receivertest;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

public class ReceiverTest extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // 비행기 모드의 on/off 확인 (현재 비행기 모드 이벤트가 발생한 상황)
        boolean isOn = isAirModeOn(context);

        if (isOn) {
            Toast.makeText(context, "air.. on..", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "air.. off..", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isAirModeOn(Context context) {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1){
            return Settings.System.getInt(context.getContentResolver(),
                    Settings.System.AIRPLANE_MODE_ON, 0) == 1;
        }else{
            return Settings.Global.getInt(context.getContentResolver(),
                    Settings.Global.AIRPLANE_MODE_ON, 0) == 1;
        }

    }
}
