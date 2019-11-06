package com.example.vash.industria40uc;

public class ObjetoListView {


    private String nombre, mensaje, fecha;
    private String tipoUltimoMensaje;
    private boolean msjLeido;
    private int nrMsjNoLeido;
    private String txtSmallIcon;
    private int img;

    public ObjetoListView(String nombre, String mensaje, String fecha, String tipoUltimoMensaje, boolean msjLeido, int nrMsjNoLeido, String txtSmallIcon, int img) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.tipoUltimoMensaje = tipoUltimoMensaje;
        this.msjLeido = msjLeido;
        this.nrMsjNoLeido = nrMsjNoLeido;
        this.txtSmallIcon = txtSmallIcon;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTipoUltimoMensaje() {
        return tipoUltimoMensaje;
    }

    public String getTxtSmallIcon() {
        return txtSmallIcon;
    }

    public int getNrMsjNoLeido() {
        return nrMsjNoLeido;
    }

    public boolean isMsjLeido() {
        return msjLeido;
    }
}