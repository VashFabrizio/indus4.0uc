package com.example.vash.industria40uc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallePonente_Ruth extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView, m2TextView,m3TextView,m4TextView,m5TextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_ponente_ruth);

        mTextView = findViewById(R.id.tvBiografiaHenna);
        m2TextView=findViewById(R.id.tvNombreHenna);
        m3TextView=findViewById(R.id.tvEventoJ);
        m4TextView=findViewById(R.id.tvDiaEventoJ);
        m5TextView=findViewById(R.id.tvHoraEventoJ);

        mTextView.setText("Magíster en Ingeniería Automotriz del Tecnológico de Monterrey, México. Ingeniera Mecánica con diplomado en Seguridad Basado en el Comportamiento en Minería de la PUCP. Jefa y fundadora del Equipo DEIMOS Perú con participaciones en NASA Human Exploration Rover Challenge.");
        m2TextView.setText("Ruth Manzanares Grados");
        m3TextView.setText("Los nuevos materiales en la manufactura 4.0");
        m4TextView.setText("Viernes 15 Noviembre");
        m5TextView.setText("9:45 a. m.");

        button=findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, ListaAgenda.class);
        startActivity(i);
    }
}
