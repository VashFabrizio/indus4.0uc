package com.example.vash.industria40uc;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewEventoAdapter extends RecyclerView.Adapter<RecyclerViewEventoAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvFecha,tvHora,tvId;
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

    public List<Evento> listaeventos;
    public RecyclerViewEventoAdapter(List<Evento> eventos)
    {
        this.listaeventos=eventos;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
