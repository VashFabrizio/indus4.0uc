package com.example.vash.industria40uc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Juan extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente_juan);

        mTextView = findViewById(R.id.tvBiografiaHenna);
        m2TextView=findViewById(R.id.tvNombreHenna);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Arquitecto y magister en Gestión Urbana de la Universidad. Piloto de Colombia/ Eninco S.Ay Magister en Gestión Urbana. Vinculado al sector académico e investigativo con diferentes universidades como la Universidad Piloto de Colombia y la Universidad de los Andes – CIDER, entre otras.");
        m2TextView.setText("Juan Pablo Serna Cardona");
        m3TextView.setText("La planificación territorial como base para constituir ciudades y territorios inteligentes");
        m4TextView.setText("Jueves 14 Noviembre");
        m5TextView.setText("12:15 p. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}