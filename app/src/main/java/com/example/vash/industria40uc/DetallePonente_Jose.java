package com.example.vash.industria40uc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Jose extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente__jose);

        mTextView = findViewById(R.id.tvBiografiaHenna);
        m2TextView=findViewById(R.id.tvNombreHenna);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Ingeniero electrónico por la Universidad Nacional Mayor de San Marcos. Ejecutivo de Procesos de Acreditación en el Instituto de Calidad y Acreditación de Programas de Computación, Ingeniería y Tecnología en Ingeniería (ICACIT).");
        m2TextView.setText("José Durán Talledo");
        m3TextView.setText("El ingeniero global y los desafíos de la Agenda 2030");
        m4TextView.setText("Jueves 14 Noviembre");
        m5TextView.setText("11:30 a. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}