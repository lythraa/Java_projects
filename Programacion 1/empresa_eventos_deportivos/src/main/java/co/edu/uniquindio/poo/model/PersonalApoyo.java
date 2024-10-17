package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class PersonalApoyo extends Participante {
    private int aniosExperienciaLaboral;

    public PersonalApoyo(String nombre, String apellidos, LocalDate fechaNacimiento,
                        String nacionalidad, int edad, String paisRepresentativo,
                        int aniosExperienciaLaboral) {
        super(nombre, apellidos, fechaNacimiento, nacionalidad, edad, paisRepresentativo);
;        this.aniosExperienciaLaboral = aniosExperienciaLaboral;
    }

    public int getAniosExperienciaLaboral() {
        return aniosExperienciaLaboral;
    }

    public void setAniosExperienciaLaboral(int aniosExperienciaLaboral) {
        this.aniosExperienciaLaboral = aniosExperienciaLaboral;
    }
    
    
}
