package com.example.maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_participante, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);
        holder.correo.setText(listItem.getParticipante_correo());
        holder.nombre.setText(listItem.getParticipante_nombre());
        holder.apellido.setText(listItem.getParticipante_apellido());
        holder.cargo.setText(listItem.getParticipante_cargo());
        holder.empresa.setText(listItem.getParticipante_empresa());
        holder.celular.setText(listItem.getParticipante_celular());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView correo;
        public TextView nombre;
        public TextView apellido;
        public TextView cargo;
        public TextView empresa;
        public TextView celular;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            correo = (TextView) itemView.findViewById(R.id.tvCorreo);
            nombre = (TextView) itemView.findViewById(R.id.tvNombre);
            apellido = (TextView) itemView.findViewById(R.id.tvApellido);
            cargo = (TextView) itemView.findViewById(R.id.tvCargo);
            empresa = (TextView) itemView.findViewById(R.id.tvEmpresa);
            celular = (TextView) itemView.findViewById(R.id.tvCelular);
        }
    }
}
