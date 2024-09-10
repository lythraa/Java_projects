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

    public void asignarMiembroEntrenador(Miembro miembro){
        
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
