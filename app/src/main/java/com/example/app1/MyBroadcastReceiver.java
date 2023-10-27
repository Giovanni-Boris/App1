package com.example.app1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String FILTRO = "com.example.app1.lab04";
    private TextView textView; // TextView asociado

    public MyBroadcastReceiver(TextView textView) {
        this.textView = textView;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(FILTRO)) {
            String message = intent.getStringExtra("mensaje");
            textView.setText(message);
            Toast.makeText(context, "Mensaje  recibido en App1: " + message, Toast.LENGTH_SHORT).show();
        }
    }
}
