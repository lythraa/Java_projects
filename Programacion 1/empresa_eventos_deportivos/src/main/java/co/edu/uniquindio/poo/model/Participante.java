package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Participante extends Persona{
    private int edad;
    private String paisRepresentativo;

    public Participante(String nombre, String apellidos, LocalDate fechaNacimiento, String nacionalidad, int edad, String paisRepresentativo) {
        super(nombre, apellidos, fechaNacimiento, nacionalidad);
        this.edad = edad;
        this.paisRepresentativo = paisRepresentativo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPaisRepresentativo() {
        return paisRepresentativo;
    }

    public void setPaisRepresentativo(String paisRepresentativo) {
        this.paisRepresentativo = paisRepresentativo;
    }


}
