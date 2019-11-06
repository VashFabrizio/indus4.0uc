package com.example.vash.industria40uc;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ObjetoListView> {

    private Activity activity;
    private ArrayList<ObjetoListView> arrayList;

    public CustomAdapter(Activity activity, ArrayList<ObjetoListView> arrayList) {
        super(activity, R.layout.custom_layout_listview, arrayList);
        this.activity = activity;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView =
                    LayoutInflater.from(getContext())
                            .inflate(R.layout.custom_layout_listview, parent, false);
        }

        TextView txtNombre = convertView.findViewById(R.id.txtNombre);
        TextView txtMensaje = convertView.findViewById(R.id.txtMensaje);
        TextView txtFecha = convertView.findViewById(R.id.txtFecha);
        TextView txtBadgeNotification = convertView.findViewById(R.id.badge_notification);
        TextView txtSmallIcon = convertView.findViewById(R.id.txtSmallIcon);

        ImageView imgAudio = convertView.findViewById(R.id.imgAudio);
        ImageView imgPhoto = convertView.findViewById(R.id.imgPhoto);
        ImageView imgVideo = convertView.findViewById(R.id.imgVideo);
        ImageView imgP = convertView.findViewById(R.id.img_profile);


        imgP.setImageDrawable(activity.getResources().getDrawable(
                arrayList.get(position).getImg()
        ));

        txtNombre.setText(arrayList.get(position).getNombre());
        txtMensaje.setText(arrayList.get(position).getMensaje());
        txtFecha.setText(arrayList.get(position).getFecha());

        String tipoMensaje = arrayList.get(position).getTipoUltimoMensaje();

        switch (tipoMensaje) {
            case Ponentes.TEXTO:
                txtMensaje.setVisibility(View.VISIBLE);
                imgAudio.setVisibility(View.GONE);
                imgPhoto.setVisibility(View.GONE);
                imgVideo.setVisibility(View.GONE);
                txtSmallIcon.setVisibility(View.GONE);
                break;

        }


        if (!arrayList.get(position).isMsjLeido()) {
            txtFecha.setTextColor(activity.getResources().getColor(R.color.color_notification));
            txtBadgeNotification.setVisibility(View.VISIBLE);
            txtBadgeNotification.setText(String.valueOf(arrayList.get(position).getNrMsjNoLeido()));
        } else {
            txtFecha.setTextColor(Color.GRAY);
            txtBadgeNotification.setVisibility(View.GONE);
        }


        return convertView;
    }


}