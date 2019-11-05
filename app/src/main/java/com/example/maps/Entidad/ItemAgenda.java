package com.example.maps.Entidad;

public class ItemAgenda {


    private String fecha;
    private String titulo;
    private String hora;
    private String lugar;
    private int Foto;
    public ItemAgenda(String fecha, String titulo, String hora, String lugar, int foto)
    {
        this.fecha=fecha;
        this.titulo=titulo;
        this.hora=hora;
        this.lugar=lugar;
        this.Foto=foto;

    }


    public String getFecha()
    {
        return fecha;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public String getHora()
    {
        return hora;
    }
    public String getLugar()
    {
        return lugar;
    }
    public int getFoto()
    {
        return Foto;
    }


}
