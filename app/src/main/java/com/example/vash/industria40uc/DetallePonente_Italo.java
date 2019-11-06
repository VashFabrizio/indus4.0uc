package com.example.vash.industria40uc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Italo extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente__italo);

        mTextView = findViewById(R.id.tvBiografiaHenna);
        m2TextView=findViewById(R.id.tvNombreHenna);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Google Product Experts. Beta Tester de Programas de Google. Platino en Youtube y Google Play. Contribuye al Programa de Google Crowdsource para mejorar el Machine Learning de Google y la experiencia del usuario en sus aplicaciones.");
        m2TextView.setText("Italo Quispe Guerra");
        m3TextView.setText("Crowdsource in the age of Artificial Intelligence");
        m4TextView.setText("Jueves 14 Noviembre");
        m5TextView.setText("5:00 p. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}
