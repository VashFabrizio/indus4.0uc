package com.example.maps;

public class ListItem {
    private String participante_correo;
    private String participante_nombre;
    private String participante_apellido;
    private String participante_cargo;
    private String participante_empresa;
    private String participante_celular;

    public ListItem(String participante_correo,
                    String participante_nombre,
                    String participante_apellido,
                    String participante_cargo,
                    String participante_empresa,
                    String participante_celular){

        this.participante_correo = participante_correo;
        this.participante_nombre = participante_nombre;
        this.participante_apellido = participante_apellido;
        this.participante_cargo = participante_cargo;
        this.participante_empresa = participante_empresa;
        this.participante_celular = participante_celular;
    }

    public String getParticipante_correo() {
        return participante_correo;
    }

    public String getParticipante_nombre() {
        return participante_nombre;
    }

    public String getParticipante_apellido() {
        return participante_apellido;
    }

    public String getParticipante_cargo() {
        return participante_cargo;
    }

    public String getParticipante_empresa() {
        return participante_empresa;
    }

    public String getParticipante_celular() {
        return participante_celular;
    }
}
