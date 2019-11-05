package com.example.maps;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.maps.Adaptador.RecyclerViewAdapter;
import com.example.maps.Adaptador.RecyclerViewAuditorioAdapter;
import com.example.maps.Entidad.Item;
import com.example.maps.Entidad.ItemAgenda;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsAuditorio extends FragmentActivity implements OnMapReadyCallback, View.OnTouchListener {

    private GoogleMap mMap;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    ImageView imageView;

    private boolean zoomOut =  false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_auditorio);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        recyclerView = findViewById(R.id.rvAgendaAuditorio);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        adapter = new RecyclerViewAuditorioAdapter(this, GetListItems());
        recyclerView.setAdapter(adapter);

        imageView = findViewById(R.id.imgAuditorio1);
        imageView.setOnTouchListener(this);





    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng fabLab = new LatLng(-12.047307, -75.198886);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        CameraPosition cameraPosition= CameraPosition.builder()
                .target(fabLab)
                .zoom(18)
                .build();
        mMap.addMarker(new MarkerOptions().position(fabLab).title("Auditorio UC"));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    private ArrayList<ItemAgenda> GetListItems()
    {
        ArrayList<ItemAgenda> ListItems = new ArrayList<>();
        ListItems.add(new ItemAgenda("14 NOV","Personal and Professional Development Challengers of Young Professionals in the Industry 4.0", "9:30 a.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("14 NOV","Improving Security in the Internet of Things (IoT) through Bio - Inspired Approaches", "10:15 a.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("14 NOV","El ingeniero global y los desafíos de la Agenda 2030", "11:30 a.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("14 NOV","La planificación territorial como base para constituir ciudades y territorios inteligentes", "12:15 p.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("14 NOV","La incorporación de la gestión del riesgo de desastres en el ordenamiento del territorio, para la construcción de ciudades inteligentes", "3:00 p.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("14 NOV","Propuesta de Arquitectura Empresarial para la Transformación Digital", "3:45 p.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("14 NOV","Crowdsource in the age of Artificial Intelligence", "5:00 p.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("14 NOV","¿Cómo realizar una transformación cultural para lograr holismo en la organización?", "5:45 p.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("15 NOV","Remediación Ambiental en la Industria 4.0. Caso de estudio:", "9:00 a.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("15 NOV","Los nuevos materiales en la manufactura 4.0", "9:45 a.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("15 NOV","Oportunidades del Análisis del Ciclo de Vida Ambiental ACV en la producción sostenible", "11:00 a.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("15 NOV","Territorios instantáneos, Chasquis 4.0", "11:45 a.m.","Auditorio UC",R.drawable.flecha));
        ListItems.add(new ItemAgenda("15 NOV","Clausura del evento", "12:30 p.m.","Auditorio UC",R.drawable.flecha));

        return ListItems;

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/drawable/auditoriomap");;
        Dialog builder = new Dialog(this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });
        int a=v.getId();
        if(R.id.imgAuditorio1==a)
        {
            uri = Uri.parse("android.resource://"+getPackageName()+"/drawable/auditorioucci");    //path of image
        }

        ImageView imageView = new ImageView(this);
        imageView.setImageURI(uri);
        builder.addContentView(imageView, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        builder.show();
        return false;
    }
}
