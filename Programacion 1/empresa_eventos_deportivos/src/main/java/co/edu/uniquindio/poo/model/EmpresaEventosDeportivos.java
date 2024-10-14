package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class EmpresaEventosDeportivos {
    public String nombre;
    public LinkedList<EventoDeportivo> listaEventos;
    public LinkedList<Persona> listaPersonas;

    public EmpresaEventosDeportivos(String nombre) {
        this.nombre = nombre;
        this.listaEventos = new LinkedList<EventoDeportivo>();
        this.listaPersonas = new LinkedList<Persona>(); //inician vacias no nulas!!!
    }

    //──────────────────────── ≪CRUD PERSONA≫ ────────────────────────//
    
    public String agregarPersona(Persona persona) throws IllegalArgumentException{
        if (persona==null){
            throw new IllegalArgumentException("Persona no puede ser nula");
        }
        if (buscarPersonaNombreApellido(persona.getNombre(), persona.getApellidos())!=null){
            return "Repetido";
        }
        listaPersonas.add(persona);
        return "Añadido";
    }

    
    public Persona buscarPersonaNombreApellido(String nombre, String apellidos) throws IllegalArgumentException{
        if (nombre==null || apellidos==null){
            throw new IllegalArgumentException("Los nombres a buscar no pueden ser nulos");
        }
        for (Persona persona : listaPersonas) {
            if (persona.getNombre()==nombre &&persona.getApellidos()==apellidos){
                return persona;
            }
        }
        return null;
    }

    
    public String actualizarPersona(String nombre, String apellidos, Persona nuevaPersona) throws IllegalArgumentException{
        if (nombre==null || apellidos==null||nuevaPersona==null){
            throw new IllegalArgumentException("Los nombres o la persona no pueden ser nulos");
        }
        if (buscarPersonaNombreApellido(nombre, apellidos)==null){
            return "No existe";
        }
        eliminarPersona(nombre, apellidos);
        agregarPersona(nuevaPersona);
        return "Actualizado";

    }

    public String eliminarPersona(String nombre, String apellidos) throws IllegalArgumentException{
        if(nombre==null || apellidos==null){
            throw new IllegalArgumentException("Los nombres no pueden ser nulos");
        }
        if(buscarPersonaNombreApellido(nombre, apellidos)==null){
            return "No existe";
        }
        listaPersonas.remove(buscarPersonaNombreApellido(nombre, apellidos));
        return "Eliminado";
    }

    //──────────────────────── ≪CRUD EventoDeportivo≫ ────────────────────────//

     // Crear: Agregar un nuevo evento
     public void agregarEvento(EventoDeportivo evento) {
        listaEventos.add(evento);
    }

    // Leer: Obtener un evento por su nombre
    public EventoDeportivo obtenerEvento(String nombre) {
        for (EventoDeportivo evento : listaEventos) {
            if (evento.getNombre().equalsIgnoreCase(nombre)) {
                return evento;
            }
        }
        return null; // Si no se encuentra, devolver null
    }

    // Actualizar: Modificar un evento existente
    public boolean actualizarEvento(String nombre, EventoDeportivo nuevoEvento) {
        for (int i = 0; i < listaEventos.size(); i++) {
            if (listaEventos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                listaEventos.set(i, nuevoEvento);
                return true; // Evento actualizado
            }
        }
        return false; // Evento no encontrado
    }

    // Borrar: Eliminar un evento por su nombre
    public boolean eliminarEvento(String nombre) {
        return listaEventos.removeIf(evento -> evento.getNombre().equalsIgnoreCase(nombre));
    }

    // Obtener todos los eventos
    public LinkedList<EventoDeportivo> obtenerTodosLosEventos() {
        return new LinkedList<>(listaEventos); // Devuelve una copia de la lista
    }


    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<EventoDeportivo> getListaEventosDeportivos() {
        return listaEventos;
    }

    public void setListaEventosDeportivos(LinkedList<EventoDeportivo> listaEventosDeportivos) {
        this.listaEventos = listaEventosDeportivos;
    }

    public LinkedList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(LinkedList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "EmpresaEventosDeportivos [nombre=" + nombre + ", listaEventosDeportivos=" + listaEventos
                + ", listaPersonas=" + listaPersonas + "]";
    }

    
}