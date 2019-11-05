package com.example.maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsLabJ301 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_lab_j301);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.addMarker(new MarkerOptions().position(j301).title("LABORATORIO DE REDES").snippet("3er piso Pabellon J"));
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
