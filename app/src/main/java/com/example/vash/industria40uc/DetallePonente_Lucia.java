package com.example.vash.industria40uc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Lucia extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente_lucia);

        mTextView = findViewById(R.id.tvBiografiaHenna);
        m2TextView=findViewById(R.id.tvNombreHenna);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Ingeniera electrónica por la Universidad Nacional de Tucumán, Argentina. Es Project Coordinator de Sinergia S.A. y Energy Service Company en Argentina. Profesional referente en Young Women and Men in Science/Technology/Engineering.");
        m2TextView.setText("Lucía Pía Torres");
        m3TextView.setText("Personal and Professional Development Challengers of Young Professionals in the Industry 4.0");
        m4TextView.setText("Jueves 14 Noviembre");
        m5TextView.setText("9:30 a. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}