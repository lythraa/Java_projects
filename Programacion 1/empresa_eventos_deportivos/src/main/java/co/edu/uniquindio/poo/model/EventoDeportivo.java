package co.edu.uniquindio.poo.model;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class EventoDeportivo {
    private String nombre;
    private LocalDateTime fechaInicio;
    private String deporte;
    private String pais;
    private String ciudad;
    private LinkedList<Participante> listaParticipantes;
    private LinkedList<Equipo> listaEquipos;
    private TipoEvento tipoEvento;
    
    public EventoDeportivo(String nombre, LocalDateTime fechaInicio, String deporte, String pais, String ciudad,
            LinkedList<Participante> listaParticipantes, LinkedList<Equipo> listaEquipos, TipoEvento tipoEvento) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.deporte = deporte;
        this.pais = pais;
        this.ciudad = ciudad;
        this.listaParticipantes = listaParticipantes;
        this.listaEquipos = listaEquipos;
        this.tipoEvento = tipoEvento;
    }

    //──────────────────────── ≪CRUD PARTICIPANTE≫ ────────────────────────//

    public String agregarParticipante(Participante Participante) throws IllegalArgumentException{
        if (Participante==null){
            throw new IllegalArgumentException("Participante no puede ser nula");
        }
        if (buscarParticipanteNombreApellido(Participante.getPersonaParticipante().getNombre(), Participante.getPersonaParticipante().getApellidos())!=null){
            return "Repetido";
        }
        listaParticipantes.add(Participante);
        return "Añadido";
    }

    
    public Participante buscarParticipanteNombreApellido(String nombre, String apellidos) throws IllegalArgumentException{
        if (nombre==null || apellidos==null){
            throw new IllegalArgumentException("Los nombres a buscar no pueden ser nulos");
        }
        for (Participante Participante : listaParticipantes) {
            if (Participante.getPersonaParticipante().getNombre()==nombre &&Participante.getPersonaParticipante().getApellidos()==apellidos){
                return Participante;
            }
        }
        return null;
    }

    
    public String actualizarParticipante(String nombre, String apellidos, Participante nuevaParticipante) throws IllegalArgumentException{
        if (nombre==null || apellidos==null||nuevaParticipante==null){
            throw new IllegalArgumentException("Los nombres o la Participante no pueden ser nulos");
        }
        if (buscarParticipanteNombreApellido(nombre, apellidos)==null){
            return "No existe";
        }
        eliminarParticipante(nombre, apellidos);
        agregarParticipante(nuevaParticipante);
        return "Actualizado";

    }

    public String eliminarParticipante(String nombre, String apellidos) throws IllegalArgumentException{
        if(nombre==null || apellidos==null){
            throw new IllegalArgumentException("Los nombres no pueden ser nulos");
        }
        if(buscarParticipanteNombreApellido(nombre, apellidos)==null){
            return "No existe";
        }
        listaParticipantes.remove(buscarParticipanteNombreApellido(nombre, apellidos));
        return "Eliminado";
    }

    


}
