package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.maps.Adaptador.RecyclerViewAdapter;
import com.example.maps.Entidad.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rvListItems);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new RecyclerViewAdapter(this,GetListItems());
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Item> GetListItems()
    {
        ArrayList<Item> ListItems = new ArrayList<>();
        ListItems.add(new Item(R.drawable.auditoriomap,"Auditorio UC", "Auditorio Universidad Continental"));
        ListItems.add(new Item(R.drawable.fablabmap,"FabLab UC", "Laboratorio de Fabricación Digital"));
        ListItems.add(new Item(R.drawable.labj301map,"Laboratorio de Redes", "Laboratorio de Redes J301"));
        return ListItems;

    }

}
