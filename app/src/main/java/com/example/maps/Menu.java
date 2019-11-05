package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    CardView ponenteCardView, agendaCardView, qrCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        ponenteCardView = findViewById(R.id.ponentes);
        agendaCardView = findViewById(R.id.agenda);
        qrCardView = findViewById(R.id.qr);

        ponenteCardView.setOnClickListener(this);
        agendaCardView.setOnClickListener(this);
        qrCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.ponentes:
                Intent i=new Intent(this, Ponentes.class);
                startActivity(i);
                break;

            case R.id.agenda:
                Intent j=new Intent(this, ListaAgenda.class);
                startActivity(j);
                break;
           /* case R.id.qr:
                Intent a=new Intent(this, LoginActivity.class);
                startActivity(a);
                break;*/
        }
    }
}
