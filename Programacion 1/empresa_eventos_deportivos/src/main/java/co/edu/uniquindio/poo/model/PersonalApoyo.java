package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class PersonalApoyo extends Persona {
    private int aniosExperienciaLaboral;

    public PersonalApoyo(String nombre, String apellidos, LocalDate fechaNacimiento, String nacionalidad, int aniosExperienciaLaboral) {
        super(nombre, apellidos, fechaNacimiento, nacionalidad);
        this.aniosExperienciaLaboral = aniosExperienciaLaboral;
    }

    public int getAniosExperienciaLaboral() {
        return aniosExperienciaLaboral;
    }

    public void setAniosExperienciaLaboral(int aniosExperienciaLaboral) {
        this.aniosExperienciaLaboral = aniosExperienciaLaboral;
    }
    
    
}
