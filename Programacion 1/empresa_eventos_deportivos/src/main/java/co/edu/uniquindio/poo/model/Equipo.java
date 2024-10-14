package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Equipo {
    private String nombre;
    private String paisOrigen;
    private LinkedList<Atleta> listaAtletasEquipo;

    public Equipo(String nombre, String paisOrigen, LinkedList<Atleta> listaAtletasEquipo) {
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.listaAtletasEquipo = listaAtletasEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public LinkedList<Atleta> getListaAtletasEquipo() {
        return listaAtletasEquipo;
    }

    public void setListaAtletasEquipo(LinkedList<Atleta> listaAtletasEquipo) {
        this.listaAtletasEquipo = listaAtletasEquipo;
    }
    
    
}


