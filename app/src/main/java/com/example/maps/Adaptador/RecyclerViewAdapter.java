package com.example.maps.Adaptador;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maps.Entidad.Item;
import com.example.maps.MapsAuditorio;
import com.example.maps.MapsFabLab;
import com.example.maps.MapsLabJ301;
import com.example.maps.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Item> listItems;


    public RecyclerViewAdapter(Context context, ArrayList<Item> listItems) {
        this.context = context;
        this.listItems = listItems;

    }

    public RecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.layout_item_lista,null);

        return new Holder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Item item = listItems.get(position);
        Holder Holder = (Holder) holder;
        Holder.ivFoto.setImageResource(item.getFoto());
        Holder.tvTitulo.setText(item.getTitulo());
        Holder.tvDescripcion.setText(item.getDescripcion());
        Holder.layrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position)
                {
                    case 0:
                        Intent i0 = new Intent(context, MapsAuditorio.class);
                        context.startActivity(i0);
                        break;
                    case 1:
                        Intent i1 = new Intent(context, MapsFabLab.class);
                        context.startActivity(i1);
                        break;
                    case 2:
                        Intent i2 = new Intent(context, MapsLabJ301.class);
                        context.startActivity(i2);
                        break;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvTitulo, tvDescripcion;
        LinearLayout layrv;



        public Holder(@NonNull View itemView) {
            super(itemView);
            ivFoto= itemView.findViewById(R.id.ivFoto);
            tvTitulo= itemView.findViewById(R.id.tvTitulo);
            tvDescripcion= itemView.findViewById(R.id.tvDescripcion);
            layrv= itemView.findViewById(R.id.layoutRV);

        }


    }




}
