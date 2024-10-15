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
    public Boolean agregarParticipante(Participante Participante) throws IllegalArgumentException{
        if (Participante==null){
            throw new IllegalArgumentException("Participante no puede ser nulo");
        }
        if (buscarParticipante(Participante)==null){
            return false;
        }
        listaParticipantes.add(Participante);
        return true;
    }
    
    
    public Participante buscarParticipante(Participante ParticipanteBusqueda) throws IllegalArgumentException{
        if (ParticipanteBusqueda==null){
            throw new IllegalArgumentException("Participante no puede ser nulo");
        }
        return listaParticipantes.stream()
                            .filter(Participante->Participante.equals(ParticipanteBusqueda))
                            .findFirst()
                            .orElse(null);
    }
    
    
    public Boolean actualizarParticipante(Participante ParticipanteObsoleto, Participante ParticipanteNuevo) throws IllegalArgumentException{
        if (ParticipanteObsoleto==null||ParticipanteNuevo==null){
            throw new IllegalArgumentException("Participante no puede ser nulo");
        }
        if (buscarParticipante(ParticipanteObsoleto)==null){
            return false;
        }
        eliminarParticipante(ParticipanteObsoleto);
        agregarParticipante(ParticipanteNuevo);
        return true;
    
    }
    
    public Boolean eliminarParticipante(Participante Participante) throws IllegalArgumentException{
        if(Participante==null){
            throw new IllegalArgumentException("Participante no puede ser nulo");
        }
        if(buscarParticipante(Participante)==null){
            return false;
        }
        listaParticipantes.remove(Participante);
        return true;
    }

    
    //──────────────────────── ≪CRUD EQUIPO≫ ────────────────────────//

    public Boolean agregarEquipo(Equipo Equipo) throws IllegalArgumentException{
        if (Equipo==null){
            throw new IllegalArgumentException("Equipo no puede ser nulo");
        }
        if (buscarEquipo(Equipo)==null){
            return false;
        }
        listaEquipos.add(Equipo);
        return true;
    }
    
    
    public Equipo buscarEquipo(Equipo EquipoBusqueda) throws IllegalArgumentException{
        if (EquipoBusqueda==null){
            throw new IllegalArgumentException("Equipo no puede ser nulo");
        }
        return listaEquipos.stream()
                            .filter(Equipo->Equipo.equals(EquipoBusqueda))
                            .findFirst()
                            .orElse(null);
    }
    
    
    public Boolean actualizarEquipo(Equipo EquipoObsoleto, Equipo EquipoNuevo) throws IllegalArgumentException{
        if (EquipoObsoleto==null||EquipoNuevo==null){
            throw new IllegalArgumentException("Equipo no puede ser nulo");
        }
        if (buscarEquipo(EquipoObsoleto)==null){
            return false;
        }
        eliminarEquipo(EquipoObsoleto);
        agregarEquipo(EquipoNuevo);
        return true;
    
    }
    
    public Boolean eliminarEquipo(Equipo Equipo) throws IllegalArgumentException{
        if(Equipo==null){
            throw new IllegalArgumentException("Equipo no puede ser nulo");
        }
        if(buscarEquipo(Equipo)==null){
            return false;
        }
        listaEquipos.remove(Equipo);
        return true;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LinkedList<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(LinkedList<Participante> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public LinkedList<Equipo> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(LinkedList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    

}
