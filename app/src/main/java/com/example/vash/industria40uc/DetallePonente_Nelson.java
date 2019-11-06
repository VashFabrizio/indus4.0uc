package com.example.vash.industria40uc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Nelson extends AppCompatActivity implements View.OnClickListener  {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente__nelson);

        mTextView = findViewById(R.id.tvBiografiaHenna);
        m2TextView=findViewById(R.id.tvNombreHenna);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Geólogo y magíster en Ciencias por la Universidad Nacional de Colombia / Eninco S.A. Expositor en temas relacionados a la incorporación de la Gestión del Riesgo en el Ordenamiento Territorial en la Universidad del Rosario y Universidad de Los Andes.");
        m2TextView.setText("Nelson Alfonso Huertas");
        m3TextView.setText("La incorporación de la gestión del riesgo de desastres en el ordenamiento del territorio, para la construcción de ciudades inteligentes");
        m4TextView.setText("Jueves 14 Noviembre");
        m5TextView.setText("3:00 p. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}
