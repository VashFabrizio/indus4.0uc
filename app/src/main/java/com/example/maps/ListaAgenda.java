package com.example.maps;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListaAgenda extends AppCompatActivity {

    private RecyclerView rvAgenda;
    private RecyclerViewEventoAdapter eventoAdapter;
    private Button btn14N,btn15N;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agenda);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        rvAgenda=findViewById(R.id.rvListAgenda);
        rvAgenda.setLayoutManager(new LinearLayoutManager(this));
        btn14N=findViewById(R.id.btn14Nov);
        btn15N=findViewById(R.id.btn15Nov);

        final IndustriaDB db=new IndustriaDB(this);
        db.insertarEvento();
        eventoAdapter=new RecyclerViewEventoAdapter(db.mostrarEventosAgenda());
        rvAgenda.setAdapter(eventoAdapter);

    }

    public void n14(View view)
    {
        final IndustriaDB db=new IndustriaDB(this);
        eventoAdapter=new RecyclerViewEventoAdapter(db.mostrarEventos14N());
        rvAgenda.setAdapter(eventoAdapter);
    }

    public void n15(View view)
    {
        final IndustriaDB db=new IndustriaDB(this);
        eventoAdapter=new RecyclerViewEventoAdapter(db.mostrarEventos15N());
        rvAgenda.setAdapter(eventoAdapter);
    }
}