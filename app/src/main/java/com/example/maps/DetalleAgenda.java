package com.example.maps;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class DetalleAgenda extends AppCompatActivity implements View.OnClickListener {

    private int idEvento;
    private String evento,fecha,hora,ponente,mapa;
    private Button btnLugar;
    private TextView tvFecha,tvEventoNombre,tvHora,tvPonente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_agenda);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tvFecha=findViewById(R.id.tvFecha);
        tvEventoNombre=findViewById(R.id.tvEventoNombre);
        tvHora=findViewById(R.id.tvHora);
        tvPonente=findViewById(R.id.tvPonente);
        btnLugar=findViewById(R.id.btnLugar);
        btnLugar.setOnClickListener(this);

        idEvento= Integer.parseInt(getIntent().getStringExtra("idEvento"));
        final IndustriaDB db=new IndustriaDB(this);
        List<Evento> eventoList=db.mostrarEventosAgenda();
        for(int i=0;i<=eventoList.size();i++)
        {
            if(i==idEvento)
            {
                evento=eventoList.get(i-1).getNombre();
                fecha=eventoList.get(i-1).getFecha();
                hora=eventoList.get(i-1).getHora();
                ponente=eventoList.get(i-1).getPonente();
                mapa=eventoList.get(i-1).getLugar();
            }
        }
        tvPonente.setText(ponente);
        tvHora.setText(hora);
        tvEventoNombre.setText(evento);
        tvFecha.setText(fecha);
        btnLugar.setText(mapa);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MapsAuditorio.class);
        startActivity(i);
    }
}