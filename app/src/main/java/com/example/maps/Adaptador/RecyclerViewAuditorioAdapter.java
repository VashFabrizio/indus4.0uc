package com.example.maps.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maps.Entidad.Item;
import com.example.maps.Entidad.ItemAgenda;
import com.example.maps.R;

import java.util.ArrayList;

public class RecyclerViewAuditorioAdapter extends RecyclerView.Adapter{

    private Context context;
    private ArrayList<ItemAgenda> listItems;

    public RecyclerViewAuditorioAdapter(Context context, ArrayList<ItemAgenda> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.layout_item_ag_auditorio,null);
        return new Holder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemAgenda itemAgenda = listItems.get(position);
        Holder Holder = (Holder) holder;
        Holder.tvFecha.setText(itemAgenda.getFecha());
        Holder.tvTitulo.setText(itemAgenda.getTitulo());
        Holder.tvHora.setText(itemAgenda.getHora());
        Holder.tvLugar.setText(itemAgenda.getLugar());
        Holder.ivFoto.setImageResource(itemAgenda.getFoto());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{

        TextView tvFecha, tvTitulo, tvHora, tvLugar;
        ImageView ivFoto;
        public Holder(@NonNull View itemView) {
            super(itemView);

            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvHora = itemView.findViewById(R.id.tvHora);
            tvLugar = itemView.findViewById(R.id.tvLugar);
            ivFoto= itemView.findViewById(R.id.imgFlecha);
        }
    }
}
