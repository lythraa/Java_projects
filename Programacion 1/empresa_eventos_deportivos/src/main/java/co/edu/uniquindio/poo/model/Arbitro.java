package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Arbitro extends Persona{
    private String categoriaArbitraje;

    public Arbitro(String nombre, String apellidos, LocalDate fechaNacimiento, String nacionalidad, String categoriaArbitraje){
        super(nombre, apellidos, fechaNacimiento, nacionalidad);
        this.categoriaArbitraje = categoriaArbitraje;
    }

    public String getCategoriaArbitraje() {
        return categoriaArbitraje;
    }

    public void setCategoriaArbitraje(String categoriaArbitraje) {
        this.categoriaArbitraje = categoriaArbitraje;
    }

    

}
