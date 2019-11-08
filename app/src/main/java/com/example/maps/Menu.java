package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    CardView ponenteCardView, agendaCardView, qrCardView, mapsCardView , notiCardView
                , documentosCardView , participantesCardView;
    public String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Bundle datos = this.getIntent().getExtras();
        email = datos.getString("email");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ponenteCardView = findViewById(R.id.ponentes);
        agendaCardView = findViewById(R.id.agenda);
        qrCardView = findViewById(R.id.qr);
        mapsCardView=findViewById(R.id.mapas);
        notiCardView = findViewById(R.id.notificacion);
        documentosCardView = findViewById(R.id.documentos);
        participantesCardView = findViewById(R.id.participantes);

        ponenteCardView.setOnClickListener(this);
        agendaCardView.setOnClickListener(this);
        qrCardView.setOnClickListener(this);
        notiCardView.setOnClickListener(this);
        mapsCardView.setOnClickListener(this);
        documentosCardView.setOnClickListener(this);
        participantesCardView.setOnClickListener(this);
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

            case R.id.mapas:
                Intent k = new Intent(this, MainActivity.class);
                startActivity(k);
                break;

            case R.id.qr:
                Intent q = new Intent(this,AsistenciaActivity.class);
                q.putExtra("correo_usr" , email);
                startActivity(q);
                break;
            case R.id.notificacion:
                Intent w = new Intent(this, Notificaciones.class);
                startActivity(w);
                break;
            case R.id.documentos:
                Intent s = new Intent(this, Documentos.class);
                startActivity(s);
                break;

            case R.id.participantes:
                Intent p = new Intent(this, Participantes.class);
                startActivity(p);
                break;
           /* case R.id.qr:
                Intent a=new Intent(this, LoginActivity.class);
                startActivity(a);
                break;*/
        }
    }
}
