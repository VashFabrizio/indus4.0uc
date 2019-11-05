package com.example.maps;

import androidx.fragment.app.FragmentActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsLabJ301 extends FragmentActivity implements OnMapReadyCallback, View.OnTouchListener {

    private GoogleMap mMap;

    ImageView imglab1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_lab_j301);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        imglab1 = findViewById(R.id.imgLabRedes1);
        imglab1.setOnTouchListener(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng j301 = new LatLng(-12.048158, -75.199222);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        CameraPosition cameraPosition= CameraPosition.builder()
                .target(j301)
                .zoom(18)
                .build();
        mMap.addMarker(new MarkerOptions().position(j301).title("LABORATORIO DE REDES").snippet("3er piso Pabellon J")).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
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
        if(R.id.imgLabRedes1==a)
        {
            uri = Uri.parse("android.resource://"+getPackageName()+"/drawable/laboredes");    //path of image
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
