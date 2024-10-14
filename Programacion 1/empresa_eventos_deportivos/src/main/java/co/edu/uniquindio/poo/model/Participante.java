package co.edu.uniquindio.poo.model;

public class Participante {
    private int edad;
    private String paisRepresentativo;
    private Persona personaParticipante;

    public Participante(int edad, String paisRepresentativo, Persona personaParticipante) {
        this.edad = edad;
        this.paisRepresentativo = paisRepresentativo;
        this.personaParticipante = personaParticipante;
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

    public Persona getPersonaParticipante() {
        return personaParticipante;
    }

    public void setPersonaParticipante(Persona personaParticipante) {
        this.personaParticipante = personaParticipante;
    }

    
    

}
