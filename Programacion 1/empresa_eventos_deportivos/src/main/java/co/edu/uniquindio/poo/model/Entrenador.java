package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Entrenador extends Persona{
    private String especializacion;

    public Entrenador(String nombre, String apellidos, LocalDate fechaNacimiento, String nacionalidad, String especializacion) {
        super(nombre, apellidos, fechaNacimiento, nacionalidad);
        this.especializacion = especializacion;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    @Override
    public String toString() {
        return "Entrenador [especializacion=" + especializacion + "]";
    }
    

}
