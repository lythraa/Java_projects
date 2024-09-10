package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Entrenador {
    private String nombre;
    private String especialidad;
    private String telefono;
    private String correo;
    private Miembro[] listaMiembrosEntrenador;
    
    public Entrenador(String nombre, String especialidad, String telefono, String correo, Miembro[] listaMiembrosEntrenador, int numeroMiembros) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.correo = correo;
        this.listaMiembrosEntrenador = new Miembro[numeroMiembros];
    }

    private int buscarPosicionDisponible(){
        int posicionDisponible=-1;

        for (int i = 0; i < listaMiembrosEntrenador.length; i++) {
            Miembro miembro = listaMiembrosEntrenador[i];
            if (miembro==null){
                posicionDisponible = i;
                return posicionDisponible;
            }
        }
        return posicionDisponible;
    }

    public String asignarMiembroEntrenador(Miembro nuevoMiembro){
        String mensaje = "";
        int posicionDisponible = buscarPosicionDisponible();
        Miembro miembroEncontrado = null;
        if(posicionDisponible == -1){
            mensaje = "No hay espacio para un nuevo miembro.";
            return mensaje;

        } else {
            miembroEncontrado = buscarMiembro(nuevoMiembro.getCedula());

            if (miembroEncontrado != null) {
                mensaje= "El miembro ya esta asignado a "+nombre;
            } else {
                listaMiembrosEntrenador[posicionDisponible] = nuevoMiembro;
                mensaje = "El miembro se ha asignado a "+nombre+"exitosamente";
            }

        }
        
        return mensaje;

    }

    public Miembro buscarMiembro(String cedula){
        for (Miembro miembro : listaMiembrosEntrenador) {
            if (miembro != null && miembro.getCedula().equals(cedula)){
                return miembro;
            }
        }
        return null;
    }
        


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Miembro[] getListaMiembros() {
        return listaMiembrosEntrenador;
    }

    public void setListaMiembros(Miembro[] listaMiembros) {
        this.listaMiembrosEntrenador = listaMiembros;
    }

    @Override
    public String toString() {
        return "Entrenador [nombre=" + nombre + ", especialidad=" + especialidad + ", telefono=" + telefono
                + ", correo=" + correo + ", listaMiembros=" + Arrays.toString(listaMiembrosEntrenador) + "]";
    }
    
    


}
