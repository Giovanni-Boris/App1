package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String FILTRO = "com.example.app1.lab04";
    private MyBroadcastReceiver customReceiver;
    EditText mensajeText;
    Button enviar;
    TextView receiverMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enviar = findViewById(R.id.buttonEnviar);
        mensajeText = findViewById(R.id.editTextMensaje);
        receiverMessage = findViewById(R.id.textViewMensaje);
        //Broadcast
        customReceiver = new MyBroadcastReceiver(receiverMessage);
        IntentFilter filter = new IntentFilter(FILTRO);
        registerReceiver(customReceiver, filter);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = mensajeText.getText().toString();
                enviarMensajeAApp1(msg);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(customReceiver);
    }

    public void enviarMensajeAApp1(String mensaje) {
        Intent intent = new Intent(FILTRO);
        intent.putExtra("mensaje", mensaje);
        sendBroadcast(intent);
    }
}