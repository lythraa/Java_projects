package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Atleta extends Persona{
    private int aniosExperiencia;

    public Atleta(String nombre, String apellidos, LocalDate fechaNacimiento, String nacionalidad, int aniosExperiencia) {
        super(nombre, apellidos, fechaNacimiento, nacionalidad);
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return "Atleta [aniosExperiencia=" + aniosExperiencia + "]";
    }
    
    

}
