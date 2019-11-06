package com.example.vash.industria40uc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Jairo extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente__jairo);

        mTextView = findViewById(R.id.tvBiografiaJorge);
        m2TextView=findViewById(R.id.tvNombreJorge);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Ingeniero industrial de la Universidad Javeriana y MBA de Atlantic International University. Fue Region Vice President para Centro y Sur América del Institute of Industrial and Systems Engineers (IISE), Estados Unidos.");
        m2TextView.setText("Jairo Vargas Bonilla");
        m3TextView.setText("¿Cómo realizar una transformación cultural para lograr holismo en la organización?");
        m4TextView.setText("Jueves Noviembre");
        m5TextView.setText("5:45 p. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}