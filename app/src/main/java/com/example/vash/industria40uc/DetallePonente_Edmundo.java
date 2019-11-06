package com.example.vash.industria40uc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Edmundo extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente__edmundo);

        mTextView = findViewById(R.id.tvBiografiaHenna);
        m2TextView=findViewById(R.id.tvNombreHenna);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Doctor en Ingeniería Medioambiental, investigador del Centro de Investigación para la Sustentabilidad y Director de Posgrado de la Universidad Andrés Bello, Chile. Investigador y autor de artículos científicos en temáticas de ciclo de vida y residuos.");
        m2TextView.setText("Edmundo Muñoz Alvear");
        m3TextView.setText("Oportunidades del Análisis del Ciclo de Vida Ambiental ACV en la producción sostenible");
        m4TextView.setText("Viernes 15 Noviembre");
        m5TextView.setText("11:00 a. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}
