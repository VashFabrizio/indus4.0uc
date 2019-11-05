package com.example.maps.Entidad;

public class Item {

    private int Foto;
    private String titulo;
    private String descripcion;

    public Item(int foto, String titulo, String descripcion)
    {
        Foto=foto;
        this.titulo=titulo;
        this.descripcion=descripcion;

    }

    public int getFoto(){
        return Foto;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public String getDescripcion()
    {
        return descripcion;
    }
}
