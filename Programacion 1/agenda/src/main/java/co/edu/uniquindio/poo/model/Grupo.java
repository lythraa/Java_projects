package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Grupo {
    private String nombre;
    private Categoria categoria;
    private Contacto[] listaContactosPertenecientes;

    //constructor
    public Grupo(String nombre, Categoria categoria){
        this.nombre=nombre;
        this.categoria=categoria;
        this.listaContactosPertenecientes = new Contacto[5]; 
    }


    /**
     * Añadir contacto al grupo
     * @param contacto
     */
    public void añadirContactoGrupo(Contacto contacto){
        String mensaje = "";
        Contacto contactoEncontrado = null;
        for (int i = 0; i < listaContactosPertenecientes.length; i++) {
            if (listaContactosPertenecientes[i] != null){
                if (listaContactosPertenecientes[i].equals(contacto)){
                    contactoEncontrado = listaContactosPertenecientes[i];
                    mensaje = "El contacto ya esta en el grupo.";
                    break;
                }
            }
        }
        // Si no se encontró el contacto, se agregara lista
        if (contactoEncontrado == null) {
            for (int i = 0; i < listaContactosPertenecientes.length; i++) {
                if (listaContactosPertenecientes[i] == null) {
                    listaContactosPertenecientes[i] = contacto;
                    mensaje = "Contacto añadido correctamente";
                    break;
                }
            }
        }
        
        System.out.println(mensaje);
    }

    /**
     * Eliminar un contacto de un grupo
     * @param contacto
     */
    public void eliminarContactoGrupo(Contacto contacto){
        String mensaje = "Contacto no encontrado";
        for (int i = 0; i < listaContactosPertenecientes.length; i++) {
            if (listaContactosPertenecientes[i].equals(contacto)){
                listaContactosPertenecientes[i] = null;
                mensaje = "Contacto eliminado exitosamente";
                break;
            }
        }
        System.out.println(mensaje);
    }

    

    //getters  y setters
    /**
     * Obtener nombre  del grupo
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * Cambiar nombre del grupo
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Obtener categoria del grupo
     * @return categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }


    /**
     * Cambiar categoria del grupo
     * @param categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


    /**
     * Obtener lista de contactos pertenecientes del grupo
     * @return listaContactosPertenecientes
     */
    public Contacto[] getListaContactosPertenecientes() {
        return listaContactosPertenecientes;
    }


    /**
     * Cambiar lista de contactos pertenecientes del grupo
     * @param listaContactosPertenecientes
     */
    public void setListaContactosPertenecientes(Contacto[] listaContactosPertenecientes) {
        this.listaContactosPertenecientes = listaContactosPertenecientes;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        result = prime * result
                + ((listaContactosPertenecientes == null) ? 0 : listaContactosPertenecientes.hashCode());
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
        Grupo other = (Grupo) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (categoria != other.categoria)
            return false;
        if (listaContactosPertenecientes == null) {
            if (other.listaContactosPertenecientes != null)
                return false;
        } else if (!listaContactosPertenecientes.equals(other.listaContactosPertenecientes))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + ", categoria=" + categoria + ", listaContactosPertenecientes="
                + Arrays.toString(listaContactosPertenecientes) + ", getClass()=" + getClass() + ", getNombre()="
                + getNombre() + ", getCategoria()=" + getCategoria() + ", getListaContactosPertenecientes()="
                + Arrays.toString(getListaContactosPertenecientes()) + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }



}
