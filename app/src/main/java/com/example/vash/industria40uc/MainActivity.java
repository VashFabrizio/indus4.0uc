package com.example.vash.industria40uc;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView ponenteCardView, agendaCardView;
    CardView notificationCardView , qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ponenteCardView = findViewById(R.id.ponentes);
        agendaCardView = findViewById(R.id.agenda);
        notificationCardView = findViewById(R.id.notificacion);
        qr = findViewById(R.id.qr);

        notificationCardView.setOnClickListener(this);
        ponenteCardView.setOnClickListener(this);
        agendaCardView.setOnClickListener(this);
        qr.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.ponentes:
                Intent i=new Intent(this, Ponentes.class);
                startActivity(i);
                break;

            case R.id.agenda:
                Intent j=new Intent(this, ListaAgenda.class);
                startActivity(j);
                break;
            case R.id.notificacion:
                Intent a=new Intent(this, Notificaciones.class);
                startActivity(a);
                break;
            case R.id.qr:
                Intent t=new Intent(this, LoginActivity.class);
                startActivity(t);
                break;
        }
    }
}
