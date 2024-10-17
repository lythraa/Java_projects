package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class EmpresaEventosDeportivos {
    public String nombre;
    public LinkedList<EventoDeportivo> listaEventosDeportivos;
    public LinkedList<Participante> listaParticipantes;

    public EmpresaEventosDeportivos(String nombre) {
        this.nombre = nombre;
        this.listaEventosDeportivos = new LinkedList<EventoDeportivo>();
        this.listaParticipantes = new LinkedList<Participante>(); //inician vacias no nulas!!! 
    }

    //*3.	Realizar el método para obtener una colección de atletas que participaron en un evento deportivo de natación de tipo competición.
    public LinkedList atletasEventoCompeticionNatacion(){
        LinkedList<Participante>listaParticipantesNatacion= new LinkedList<>();

        for (EventoDeportivo eventoDeportivo : listaEventosDeportivos) {
            if (eventoDeportivo.getTipoEvento() ==TipoEvento.COMPETICION && eventoDeportivo.getDeporte()=="natación"){
                LinkedList<Participante>nadadores= eventoDeportivo.getlistaParticipantesEvento();
                listaParticipantesNatacion.addAll(nadadores);
                }//CAST lo enstance si pero lo otro no y tu?
                //ya estoy preguntando hay upcast and downcast 
            }
        
        return listaParticipantesNatacion;
        }

    //──────────────────────── ≪CRUD Participante≫ ────────────────────────//
    
    /**
     * 
     * @param Participante
     * @return
     * @throws IllegalArgumentException
     */
    public String agregarParticipante(Participante Participante) throws IllegalArgumentException{
        if (Participante==null){
            throw new IllegalArgumentException("Participante no puede ser nula");
        }
        if (buscarParticipante(Participante)!=null){
            return "Ya existe";
        }
        listaParticipantes.add(Participante);
        return "Añadido";
    }

    
    public Participante buscarParticipante(Participante ParticipanteBusqueda) throws IllegalArgumentException{
        if (ParticipanteBusqueda==null){
            throw new IllegalArgumentException("Participante no puede ser nula");
        }
        return listaParticipantes.stream()
                            .filter(Participante->Participante.equals(ParticipanteBusqueda))
                            .findFirst()
                            .orElse(null);
    }

    
    public String actualizarParticipante(Participante ParticipanteObsoleta, Participante ParticipanteNueva) throws IllegalArgumentException{
        if (ParticipanteObsoleta==null||ParticipanteNueva==null){
            throw new IllegalArgumentException("Participante no puede ser nula");
        }
        if (buscarParticipante(ParticipanteObsoleta)!=null){
            return "Ya existe";
        }
        eliminarParticipante(ParticipanteObsoleta);
        agregarParticipante(ParticipanteNueva);
        return "Añadido";

    }

    public String eliminarParticipante(Participante Participante) throws IllegalArgumentException{
        if(Participante==null){
            throw new IllegalArgumentException("Participante no puede ser nula");
        }
        if(buscarParticipante(Participante)!=null){
            return "Ya existe";
        }
        listaParticipantes.remove(Participante);
        return "Añadido";
    }

    //──────────────────────── ≪CRUD EventoDeportivo≫ ────────────────────────//

    public String agregarEventoDeportivo(EventoDeportivo EventoDeportivo) throws IllegalArgumentException{
        if (EventoDeportivo==null){
            throw new IllegalArgumentException("EventoDeportivo no puede ser nulo");
        }
        if (buscarEventoDeportivo(EventoDeportivo)!=null){
            return "Ya existe";
        }
        listaEventosDeportivos.add(EventoDeportivo);
        return "Añadido";
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
    
    
    public String actualizarEventoDeportivo(EventoDeportivo EventoDeportivoObsoleto, EventoDeportivo EventoDeportivoNuevo) throws IllegalArgumentException{
        if (EventoDeportivoObsoleto==null||EventoDeportivoNuevo==null){
            throw new IllegalArgumentException("EventoDeportivo no puede ser nulo");
        }
        if (buscarEventoDeportivo(EventoDeportivoObsoleto)!=null){
            return "Ya existe";
        }
        eliminarEventoDeportivo(EventoDeportivoObsoleto);
        agregarEventoDeportivo(EventoDeportivoNuevo);
        return "Añadido";
    
    }
    
    public String eliminarEventoDeportivo(EventoDeportivo EventoDeportivo) throws IllegalArgumentException{
        if(EventoDeportivo==null){
            throw new IllegalArgumentException("EventoDeportivo no puede ser nulo");
        }
        if(buscarEventoDeportivo(EventoDeportivo)!=null){
            return "Ya existe";
        }
        listaEventosDeportivos.remove(EventoDeportivo);
        return "Añadido";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<EventoDeportivo> getListaEventosDeportivos() {
        return listaEventosDeportivos;
    }

    public void setListaEventosDeportivos(LinkedList<EventoDeportivo> listaEventosDeportivos) {
        this.listaEventosDeportivos = listaEventosDeportivos;
    }

    public LinkedList<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(LinkedList<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }


    

}