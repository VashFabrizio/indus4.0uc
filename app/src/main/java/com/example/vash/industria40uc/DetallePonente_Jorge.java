package com.example.vash.industria40uc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Jorge extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente_jorge);

        mTextView = findViewById(R.id.tvBiografiaJorge);
        m2TextView=findViewById(R.id.tvNombreJorge);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Ingeniero de Medio Ambiente y Energía de la Universidad de Tohoku, Japón; con especialización en tratamiento de aguas y recuperación de energía. Pasante de visitas técnicas en múltiples plantas de tratamiento de agua y de residuos sólidos en Japón.");
        m2TextView.setText("Jorge Ascencio Damián");
        m3TextView.setText("Remediación Ambiental en la Industria 4.0. Caso de estudio: Japón");
        m4TextView.setText("Viernes 15 Noviembre");
        m5TextView.setText("9:00 a. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}