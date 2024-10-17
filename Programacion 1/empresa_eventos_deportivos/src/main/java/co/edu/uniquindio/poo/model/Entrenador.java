package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Entrenador extends Participante{
    private String especializacion;

    public Entrenador(String nombre, String apellidos, LocalDate fechaNacimiento,
                      String nacionalidad, int edad, String paisRepresentativo,
                      String especializacion) {
        super(nombre, apellidos, fechaNacimiento, nacionalidad, edad, paisRepresentativo);
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
