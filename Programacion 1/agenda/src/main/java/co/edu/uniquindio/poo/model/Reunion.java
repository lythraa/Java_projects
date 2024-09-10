package co.edu.uniquindio.poo.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;

public class Reunion {
    private String descripcion;
    private LocalDate fecha;
    private Time hora;
    private Contacto[] listaContactosAsistentes;

    /**
     * Constructor Reunion
     * @param descripcion
     * @param fecha
     * @param hora
     * @param numeroAsistentes Numero de contactos que asistirán a una reunión
     */
    public Reunion(String descripcion,LocalDate fecha,Time hora, int numeroAsistentes){
        this.descripcion=descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.listaContactosAsistentes = new Contacto[numeroAsistentes];
        
    }


    /**
     * Agregar los asistentes de la reunion
     * @param contacto
     */
    public void agregarContactoAsistente(Contacto contacto){
    String mensaje = "";
    Contacto contactoEncontrado = null;

    // Buscar si el contacto ya existe en la lista
    for (int i = 0; i < listaContactosAsistentes.length; i++) {
        if (listaContactosAsistentes[i]!= null){
            if (contacto.equals(listaContactosAsistentes[i])) {
                contactoEncontrado = listaContactosAsistentes[i];
                mensaje = "El contacto ya está en el grupo.";
                break;
            }
    }
    }

    // Si no se encontró el contacto, se agregara lista
    if (contactoEncontrado == null) {
        for (int i = 0; i < listaContactosAsistentes.length; i++) {
            if (listaContactosAsistentes[i] == null) {
                listaContactosAsistentes[i] = contacto;
                mensaje = "Contacto añadido correctamente";
                break;
            }
        }
    }
    
    System.out.println(mensaje);
}


    /**
     * Eliminar contactos asistentes de la reunion
     * @param contacto
     */
    public void eliminarContactoAsistente(Contacto contacto) {
    String mensaje = "Contacto no encontrado";

    for (int i = 0; i < listaContactosAsistentes.length; i++) {
        if (contacto.equals(listaContactosAsistentes[i])) {
            listaContactosAsistentes[i] = null;
            mensaje = "Contacto eliminado exitosamente";
            break;
        }
    }

    System.out.println(mensaje);
}


    
    //getters  y setters
    /**
     * Obtener descripcion de la reunion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }


    /**
     * Cambiar descripcion de la reunion
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Obtener fecha de la reunion
     * @return fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }


    /**
     * Cambiar fecha de la reunion
     * @param fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtener hora de la reunion
     * @return hora
     */
    public Time getHora() {
        return hora;
    }

    /**
     * Cambiar hora de la reunion
     * @param hora
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((hora == null) ? 0 : hora.hashCode());
        result = prime * result + ((listaContactosAsistentes == null) ? 0 : listaContactosAsistentes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reunion other = (Reunion) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (hora == null) {
            if (other.hora != null)
                return false;
        } else if (!hora.equals(other.hora))
            return false;
        if (listaContactosAsistentes == null) {
            if (other.listaContactosAsistentes != null)
                return false;
        } else if (!listaContactosAsistentes.equals(other.listaContactosAsistentes))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Reunion [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora
                + ", listaContactosAsistentes=" + Arrays.toString(listaContactosAsistentes) + ", getClass()="
                + getClass() + ", getDescripcion()=" + getDescripcion() + ", getFecha()=" + getFecha() + ", getHora()="
                + getHora() + ", hashCode()=" + hashCode() + ", getListaContactosAsistentes()="
                + Arrays.toString(getListaContactosAsistentes()) + ", toString()=" + super.toString() + "]";
    }


    public Contacto[] getListaContactosAsistentes() {
        return listaContactosAsistentes;
    }


    public void setListaContactosAsistentes(Contacto[] listaContactosAsistentes) {
        this.listaContactosAsistentes = listaContactosAsistentes;
    }


}