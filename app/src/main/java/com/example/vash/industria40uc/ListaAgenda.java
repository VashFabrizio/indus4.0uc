package com.example.vash.industria40uc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ListaAgenda extends AppCompatActivity {

    private RecyclerView rvAgenda;
    private RecyclerViewEventoAdapter eventoAdapter;
    private Button btn14N,btn15N;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_agenda);

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
