package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class EmpresaEventosDeportivos {
    public String nombre;
    public LinkedList<EventoDeportivo> listaEventosDeportivos;
    public LinkedList<Persona> listaPersonas;

    public EmpresaEventosDeportivos(String nombre) {
        this.nombre = nombre;
        this.listaEventosDeportivos = new LinkedList<EventoDeportivo>();
        this.listaPersonas = new LinkedList<Persona>(); //inician vacias no nulas!!!
    }

    //3.	Realizar el método para obtener una colección de atletas que participaron en un evento deportivo de natación de tipo competición.
    public LinkedList atletasEventoCompeticionNatacion(){
        return listaEventosDeportivos.stream()
                                     .filter(EventoDeportivo->.getTipoEvento().equals(TipoEvento.COMPETICION))
                                     &&EventoDeportivo.getDeporte=="natacion"
    }

    //──────────────────────── ≪CRUD PERSONA≫ ────────────────────────//
    
    public Boolean agregarPersona(Persona persona) throws IllegalArgumentException{
        if (persona==null){
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
        if (buscarPersona(persona)==null){
            return false;
        }
        listaPersonas.add(persona);
        return true;
    }

    
    public Persona buscarPersona(Persona personaBusqueda) throws IllegalArgumentException{
        if (personaBusqueda==null){
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
        return listaPersonas.stream()
                            .filter(persona->persona.equals(personaBusqueda))
                            .findFirst()
                            .orElse(null);
    }

    
    public Boolean actualizarPersona(Persona personaObsoleta, Persona personaNueva) throws IllegalArgumentException{
        if (personaObsoleta==null||personaNueva==null){
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
        if (buscarPersona(personaObsoleta)==null){
            return false;
        }
        eliminarPersona(personaObsoleta);
        agregarPersona(personaNueva);
        return true;

    }

    public Boolean eliminarPersona(Persona persona) throws IllegalArgumentException{
        if(persona==null){
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
        if(buscarPersona(persona)==null){
            return false;
        }
        listaPersonas.remove(persona);
        return true;
    }

    //──────────────────────── ≪CRUD EventoDeportivo≫ ────────────────────────//

    public Boolean agregarEventoDeportivo(EventoDeportivo EventoDeportivo) throws IllegalArgumentException{
        if (EventoDeportivo==null){
            throw new IllegalArgumentException("EventoDeportivo no puede ser nulo");
        }
        if (buscarEventoDeportivo(EventoDeportivo)==null){
            return false;
        }
        listaEventosDeportivos.add(EventoDeportivo);
        return true;
    }
    
    
    public EventoDeportivo buscarEventoDeportivo(EventoDeportivo EventoDeportivoBusqueda) throws IllegalArgumentException{
        if (EventoDeportivoBusqueda==null){
            throw new IllegalArgumentException("EventoDeportivo no puede ser nulo");
        }
        return listaEventosDeportivos.stream()
                            .filter(EventoDeportivo->EventoDeportivo.equals(EventoDeportivoBusqueda))
                            .findFirst()
                            .orElse(null);
    }
    
    
    public Boolean actualizarEventoDeportivo(EventoDeportivo EventoDeportivoObsoleto, EventoDeportivo EventoDeportivoNuevo) throws IllegalArgumentException{
        if (EventoDeportivoObsoleto==null||EventoDeportivoNuevo==null){
            throw new IllegalArgumentException("EventoDeportivo no puede ser nulo");
        }
        if (buscarEventoDeportivo(EventoDeportivoObsoleto)==null){
            return false;
        }
        eliminarEventoDeportivo(EventoDeportivoObsoleto);
        agregarEventoDeportivo(EventoDeportivoNuevo);
        return true;
    
    }
    
    public Boolean eliminarEventoDeportivo(EventoDeportivo EventoDeportivo) throws IllegalArgumentException{
        if(EventoDeportivo==null){
            throw new IllegalArgumentException("EventoDeportivo no puede ser nulo");
        }
        if(buscarEventoDeportivo(EventoDeportivo)==null){
            return false;
        }
        listaEventosDeportivos.remove(EventoDeportivo);
        return true;
    }


    

}