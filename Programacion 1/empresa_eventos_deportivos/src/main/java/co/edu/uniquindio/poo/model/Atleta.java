package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Atleta extends Participante{
    private int aniosExperiencia;

    public Atleta(String nombre, String apellidos, LocalDate fechaNacimiento,
                  String nacionalidad, int edad, String paisRepresentativo, int aniosExperiencia) {
        super(nombre, apellidos, fechaNacimiento, nacionalidad, edad, paisRepresentativo);
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + aniosExperiencia;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Atleta other = (Atleta) obj;
        if (aniosExperiencia != other.aniosExperiencia)
            return false;
        return true;
    }
    
    

}
