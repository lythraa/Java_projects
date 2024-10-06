package co.edu.uniquindio.poo.model;

import java.util.LinkedList;

public class Estudiante extends Usuario {

    private LinkedList<Prestamo> listaPrestamosDeUnEstudiante;

    public Estudiante(String nombre, String id, String telefono, String correo){
        super(nombre, id, correo);
        this.listaPrestamosDeUnEstudiante =  new LinkedList<Prestamo>();

    }

    public LinkedList<Prestamo> getListaPrestamosDeUnEstudiante() {
        return listaPrestamosDeUnEstudiante;
    }

    public void setListaPrestamosDeUnEstudiante(LinkedList<Prestamo> listaPrestamosDeUnEstudiante) {
        this.listaPrestamosDeUnEstudiante = listaPrestamosDeUnEstudiante;
    }
    
}
