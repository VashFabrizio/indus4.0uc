package com.example.vash.industria40uc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Heena extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente_heena);

        mTextView = findViewById(R.id.tvBiografiaHenna);
        m2TextView=findViewById(R.id.tvNombreHenna);
        m3TextView=findViewById(R.id.tvEventoH);
        m4TextView=findViewById(R.id.tvDiaEventoH);
        m5TextView=findViewById(R.id.tvHoraEventoH);

        mTextView.setText("Ph.D. en Ciencias de la Computación. Científica investigadora y docente visitante en la Universidad de Texas A&M en Estado Unidos, Austin y SS College of Engineering en India. Expositora distinguida de Associtation for Computing Machinery (ACM).");
        m2TextView.setText("Heena Rathore");
        m3TextView.setText("Improving Security in the Internet of Things (IoT) through Bio - Inspired Approaches");
        m4TextView.setText("Jueves 14 Noviembre");
        m5TextView.setText("10:15 a. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}
