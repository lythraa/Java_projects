package co.edu.uniquindio.poo.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Agenda {
    private Contacto[] listaContactos;
    private Reunion[] listaReuniones;
    private Grupo[] listaGrupos;

    /**
     * Constructor agenda
     * 
     * @param numeroContactos
     * @param numeroGrupos
     * @param numeroReuniones
     */

    public Agenda(int numeroContactos, int numeroGrupos, int numeroReuniones) {
        this.listaContactos = new Contacto[numeroContactos];
        this.listaReuniones = new Reunion[numeroReuniones];
        this.listaGrupos = new Grupo[numeroGrupos];
    }

    

    /**
     * Añade un contacto a la agenda
     * 
     * @param contacto
     */
    public void añadirContacto(Contacto contacto) {
        String mensaje = "No se pudo añadir el contacto, es posible que no haya posicion o que ya exista el contacto";
        Contacto contactoEncontrado = buscarContacto(contacto);
        int i = posDisponibleContacto(listaContactos);
        if (contactoEncontrado == null && i >= 0) {
            listaContactos[i] = contacto;
            mensaje = "Contacto añadido exitosamente";
        }
        System.out.println(mensaje);
    }

    /**
     * Busca la posicion disponible en el arreglo listaContactos
     * 
     * @param listaContactos
     * @return posicion disponible
     */
    public int posDisponibleContacto(Contacto[] listaContactos) {
        int posDisponible = -1;

        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] == null) {
                posDisponible = i;
                break; // Salir del bucle cuando se encuentra la primera posición disponible
            }
        }

        return posDisponible;
    }

    /**
     * Buscar contacto en la lista de contactos
     * 
     * @param grupo
     */
    public Contacto buscarContacto(Contacto contacto) {
        Contacto contactoEncontrado = null;
        for (int index = 0; index < listaContactos.length; index++) {
            if (listaContactos[index] != null) {
                if (listaContactos[index].equals(contacto)) {
                    contactoEncontrado = contacto;
                }
            }
        }
        return contactoEncontrado;
    }

    /**
     * Elimina un contacto de la lista de contactos
     * 
     * @param contacto
     */
    public void eliminarContacto(Contacto contacto) {
        String mensaje = "No se pudo eliminar el contacto porque no se encontró en la lista";
        for (int index = 0; index < listaContactos.length; index++) {
            if (listaContactos[index] != null) {
                if (listaContactos[index].equals(contacto)) {
                    listaContactos[index] = null;
                    mensaje = "Contacto eliminado exitosamente";
                }
            }
        }
        System.out.println(mensaje);
    }

    /**
     * Editar un contacto de la lista de contactos
     * 
     * @param contacto
     * @param nombres
     * @param alias
     * @param direccion
     * @param telefono
     * @param email
     */
    public void editarContacto(Contacto contacto) {
        String mensaje = "Contacto no encontrado";
        Contacto contactoEncontrado = buscarContacto(contacto);
        if (contactoEncontrado != null) {
            contacto.setNombres(JOptionPane.showInputDialog("Ingrese el nuevo nombre"));
            contacto.setAlias(JOptionPane.showInputDialog("Ingrese el nuevo alias"));
            contacto.setDireccion(JOptionPane.showInputDialog("Ingrese la nueva direccion "));
            contacto.setTelefono(JOptionPane.showInputDialog("Ingrese el nuevo telefono"));
            contacto.setEmail(JOptionPane.showInputDialog("Ingrese el nuevo email"));
            mensaje = "Contacto editado exitosamente";
            System.out.println(mensaje);
        }

    }

    // Crea y añade el grupo a la agenda
    public void crearAñadirGrupo() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del grupo: ");
        Categoria[] categoriasDisponibles = Categoria.values();
        Categoria categoria = (Categoria) JOptionPane.showInputDialog(null, "Seleccione una categoría",
                "Categoría del Grupo", JOptionPane.PLAIN_MESSAGE,
                null, categoriasDisponibles, categoriasDisponibles[0]);

        Grupo grupo = new Grupo(nombre, categoria);
        String mensaje = "No se pudo crear el grupo, es posible que no haya  o que ya exista el contacto";
        Grupo grupoEncontrado = buscarGrupo(grupo);
        int i = posDisponibleGrupo(listaGrupos);
        if (grupoEncontrado == null && i >= 0) {
            listaGrupos[i] = grupo;
            mensaje = "Grupo añadido exitosamente";
        }
        System.out.println(mensaje);
    }

    /**
     * añade un grupo al arreglo de grupos
     * 
     * @param grupo
     */

    public void añadirGrupo(Grupo grupo) {
        String mensaje = "No se pudo crear el grupo, es posible que no haya  o que ya exista el contacto";
        Grupo grupoEncontrado = buscarGrupo(grupo);
        int i = posDisponibleGrupo(listaGrupos);
        if (grupoEncontrado == null && i >= 0) {
            listaGrupos[i] = grupo;
            mensaje = "Grupo añadido exitosamente";
        }
        System.out.println(mensaje);
    }

    /**
     * Busca un grupo en el arreglo de grupos
     * 
     * @param grupo
     * @return grupo encontrado
     */
    public Grupo buscarGrupo(Grupo grupo) {
        Grupo grupoEncontrado = null;
        for (int index = 0; index < listaGrupos.length; index++) {
            if (listaGrupos[index] != null) {
                if (listaGrupos[index].equals(grupo)) {
                    grupoEncontrado = grupo;
                }
            }
        }
        return grupoEncontrado;
    }

    /**
     * Busca posicion disponible en el arreglo de grupos
     * 
     * @param listaGrupos
     * @return
     */
    public int posDisponibleGrupo(Grupo[] listaGrupos) {
        int posDisponible = -1;
        for (int i = 0; i < listaGrupos.length; i++) {
            if (listaGrupos[i] == null) {
                posDisponible = i;
                break; // Salir del bucle cuando se encuentra la primera posición disponible
            }
        }

        return posDisponible;
    }

    /**
     * Elimina un grupo de la lista de grupos
     * 
     * @param grupo
     */
    public void eliminarGrupo(Grupo grupo) {
        String mensaje = "No se encontró el grupo";
        for (int index = 0; index < listaGrupos.length; index++) {
            if (listaGrupos[index] != (null)) {
                if (listaGrupos[index].equals(grupo)) {
                    listaGrupos[index] = null;
                    mensaje = "Se ha eliminado el grupo exitosamente";
                }
            }
        }
        System.out.println(mensaje);
    }

    /**
     * Edita un grupo, recibe el grupo que se desea editar y la informacion nueva en
     * forma de Grupo que se desea actualizar
     * 
     * @param Grupo
     * @param informacionGrupoNuevo
     * 
     */
    public void editarGrupo(Grupo grupo) {
        String mensaje = "No se ha encontrado el grupo";
        Grupo grupoEncontrado = buscarGrupo(grupo);
        if (grupoEncontrado != null) {
            grupo.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre: "));
            mensaje = "Grupo actualizado con exito";
        }
        System.out.println(mensaje);
    }

    /**
     * Busca posicion disponible en el arreglo de reuniones
     * 
     * @param listaReuniones
     * @return
     */
    public int posDisponibleReunion(Reunion[] listaReuniones) {
        int posDisponible = -1;
        for (int i = 0; i < listaReuniones.length; i++) {
            if (listaReuniones[i] == null) {
                posDisponible = i;
                break; // Salir del bucle cuando se encuentra la primera posición disponible
            }
        }

        return posDisponible;
    }

    /**
     * Busca la reunion en el arreglo de reuniones
     * 
     * @param reunion
     * @return
     */
    public Reunion buscarReunion(Reunion reunion) {
        Reunion reunionEncontrada = null;
        for (int index = 0; index < listaReuniones.length; index++) {
            if (listaReuniones[index] != null) {
                if (listaReuniones[index].equals(reunion)) {
                    reunionEncontrada = reunion;
                }
            }
        }
        return reunionEncontrada;
    }


    /**
     * Añade la reunion al arreglo de reuniones
     * 
     * @param reunion
     */
    public void añadirReunion(Reunion reunion) {
        String mensaje = "No se pudo crear la reunion, es posible que ya exista";
        Reunion reunionEncontrada = buscarReunion(reunion);
        int i = posDisponibleReunion(listaReuniones);
        if (reunionEncontrada == null && i >= 0) {
            listaReuniones[i] = reunion;
            mensaje = "Reunion creada exitosamente";
        }
        System.out.println(mensaje);
    }

    /**
     * Elimina la reunion del arreglo
     * 
     * @param reunion
     */
    public void eliminarReunion(Reunion reunion) {
        String mensaje = "No se encontró la reunion";
        for (int index = 0; index < listaReuniones.length; index++) {
            if (listaReuniones[index] != null) {
                if (listaReuniones[index].equals(reunion)) {
                    listaReuniones[index] = null;
                    mensaje = "Se ha eliminado la reunión exitosamente";
                }
            }
        }
        System.out.println(mensaje);
    }

    /**
     * Edita una reunion
     * 
     * @param reunion
     */
    public void editarReunion(Reunion reunion) {
        String mensaje = "No se encontró la reunion";
        Reunion reunionEncontrado = buscarReunion(reunion);
        if (reunionEncontrado != null) {
            reunion.setDescripcion(JOptionPane.showInputDialog("Ingrese la nueva descripcion"));
            String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha de la reunión (formato: yyyy-MM-dd)");
            LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            String horaStr = JOptionPane.showInputDialog("Ingrese la hora de la reunión (formato: HH:mm:ss)");
            Time hora = Time.valueOf(horaStr);
            reunion.setFecha(fecha);
            reunion.setHora(hora);
            mensaje = "Reunion actualizada correctamente";
        }

        System.out.println(mensaje);

    }

    // Setters and Getters

    public Contacto[] getListaContactos() {
        return listaContactos;
    }

    @Override
    public String toString() {
        return "Agenda [listaContactos=" + Arrays.toString(listaContactos) + ", listaReuniones="
                + Arrays.toString(listaReuniones) + ", listaGrupos=" + Arrays.toString(listaGrupos) + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", getListaContactos()="
                + Arrays.toString(getListaContactos()) + ", getListaReuniones()=" + Arrays.toString(getListaReuniones())
                + ", getListaGrupos()=" + Arrays.toString(getListaGrupos()) + ", toString()=" + super.toString() + "]";
    }

    public void setListaContactos(Contacto[] listaContactos) {
        this.listaContactos = listaContactos;
    }

    public Reunion[] getListaReuniones() {
        return listaReuniones;
    }

    public void setListaReuniones(Reunion[] listaReuniones) {
        this.listaReuniones = listaReuniones;
    }

    public Grupo[] getListaGrupos() {
        return listaGrupos;
    }

    public void setListaGrupos(Grupo[] listaGrupos) {
        this.listaGrupos = listaGrupos;
    }

    //
    /**
     * 6. Retorna una matriz con las reuniones. Cada fila representa un conjunto de
     * reuniones
     * basado en un rango de fechas específico.
     * fila 0   1-11-22 al 30-11-22
     * fila 1   1-12-22 al 31-12-22
     * fila 2   1-1-22  al 30-12-22
     * 
     * @return Una matriz de LocalDate donde cada fila contiene las fechas de
     *         reuniones en el rango especificado.
     */
    

}