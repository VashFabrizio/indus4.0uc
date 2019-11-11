package com.example.maps;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewEvento15Adapter extends RecyclerView.Adapter<RecyclerViewEvento15Adapter.ViewHolder>  {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvFecha,tvHora,tvId;
        private Button btnEvento;
        Context context;
        public ViewHolder(View itemView) {
            super(itemView);
            context=itemView.getContext();
            tvFecha=itemView.findViewById(R.id.tvFechaI);
            tvHora=itemView.findViewById(R.id.tvHoraI);
            tvId=itemView.findViewById(R.id.tvIdEvento);
            btnEvento=itemView.findViewById(R.id.btnEventoDetalle);
        }
        public void setOnclickListener()
        {
            btnEvento.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnEventoDetalle:
                    Intent i=new Intent(context,DetalleAgenda.class);
                    i.putExtra("idEvento",tvId.getText().toString());
                    context.startActivity(i);
                    break;
            }
        }
    }

    public boolean prueba=true;

    public List<Evento> listaeventos;
    public RecyclerViewEvento15Adapter(List<Evento> eventos)
    {
        this.listaeventos=eventos;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda2, parent, false);
        RecyclerViewEvento15Adapter.ViewHolder viewHolder=new RecyclerViewEvento15Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewEvento15Adapter.ViewHolder holder, int position) {
        holder.tvFecha.setText(listaeventos.get(position).getFecha());
        holder.tvHora.setText(listaeventos.get(position).getHora());
        holder.btnEvento.setText(listaeventos.get(position).getNombre());
        holder.tvId.setText(String.valueOf(listaeventos.get(position).getIdEvento()));

        holder.setOnclickListener();
    }

    @Override
    public int getItemCount() {
        return listaeventos.size();
    }
}
