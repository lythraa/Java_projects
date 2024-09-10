package co.edu.uniquindio.poo.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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

    // Crea y añade un contacto a la agenda
    public void crearAñadirContacto() {
        String nombres = JOptionPane.showInputDialog("Ingrese el nombre del contacto");
        String alias = JOptionPane.showInputDialog("Ingrese el alias del contacto");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del contacto");
        String telefono = JOptionPane.showInputDialog("Ingrese el telefono del contacto");
        String email = JOptionPane.showInputDialog("Ingrese el email del contacto");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del contacto"));

        Contacto contacto = new Contacto(nombres, alias, direccion, telefono, email, edad);

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

    public void crearAñadirReunion() {
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la reunión");

        String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha de la reunión (formato: yyyy-MM-dd)");
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String horaStr = JOptionPane.showInputDialog("Ingrese la hora de la reunión (formato: HH:mm:ss)");
        Time hora = Time.valueOf(horaStr);

        int numeroAsistentes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de asistentes"));

        Reunion reunion = new Reunion(descripcion, fecha, hora, numeroAsistentes);
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
        String mensaje = "No se encontro la reunion";
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

    // Metodos taller
    // Autor Miguel Ángel Betancourt

    /**
     * 1. Imprimirlos contactos en posiciones impares
     */
    public void imprimirImpares() {
        for (int i = 0; i < listaContactos.length; i += 2) {
            System.out.println(listaContactos[i]);
        }
    }

    /**
     * 2. Obtiene la edad que mas se repite en los contactos
     * 
     * @return
     */
    public int modaEdad() {
        int moda = 0;
        int contador = 0;
        int contadorMasRepetido = 0;

        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] != null) {
                int edadi = listaContactos[i].getEdad();
                contador = 0;
                for (int j = 0; j < listaContactos.length; j++) {
                    if (listaContactos[j] != null) {
                        int edadj = listaContactos[j].getEdad();
                        if (edadi == edadj) {
                            contador++;
                        }
                    }
                }
                if (contador > contadorMasRepetido) {
                    contadorMasRepetido = contador;
                    moda = edadi;
                }
            }
        }
        return moda;
    }

    /**
     * 3. Elimina todos los contactos que tengan en su nombre al menos 3 vocales
     */
    public void eliminarTresVocales() {
        char[] vocales = { 'a', 'e', 'i', 'o', 'u' };
        int contador = 0;
        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] != null) {
                String nombre = listaContactos[i].getNombres();
                nombre = nombre.toLowerCase();
                contador = 0;
                for (int j = 0; j < nombre.length(); j++) {
                    char letra = nombre.charAt(j);
                    for (int k = 0; k < vocales.length; k++) {
                        if (vocales[k] == letra) {
                            contador++;
                            if (contador > 2) {
                                Contacto contactoEncontrado = listaContactos[i];
                                eliminarContacto(contactoEncontrado);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 4. Obtiene el grupo con la mayor cantidad de contactos asociados
     * 
     * @return
     */
    public Grupo obtenerGrupoGrande() {
        Grupo masGrande = null;
        int contador = 0;
        int contadorMas = 0;

        for (int i = 0; i < listaGrupos.length; i++) {
            if (listaGrupos[i] != null) {
                Grupo grupoAux = listaGrupos[i];
                Contacto[] lista = grupoAux.getListaContactosPertenecientes();
                for (int j = 0; j < lista.length; j++) {
                    if (lista[j] != null) {
                        contador++;

                    }
                }
                if (contador > contadorMas) {
                    contadorMas = contador;
                    masGrande = grupoAux;
                    contador = 0;
                }
            }
        }

        return masGrande;
    }

    /**
     * 5. Calcula el promedio de las edades de los contactos y lo retorna
     * 
     * @return
     */
    public double pormedioEdades() {
        double promedio = 0;
        int contador = 0;

        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] != null) {
                int edad = listaContactos[i].getEdad();
                contador++;
                promedio = promedio + edad;
            }
        }
        promedio = promedio / contador;
        return promedio;
    }

    /**
     * Retorna una matriz con las reuniones. Cada fila representa un conjunto de
     * reuniones
     * basado en un rango de fechas específico.
     * 
     * @return Una matriz de LocalDate donde cada fila contiene las fechas de
     *         reuniones en el rango especificado.
     */
    public LocalDate[][] obtenerReuniones() {
        // Crear una matriz de 3 filas
        LocalDate[][] matrizReuniones = new LocalDate[3][];

        // Crear los rangos de fechas
        LocalDate[] fila0 = generarFechas(LocalDate.of(2022, 11, 1), LocalDate.of(2022, 11, 30));
        LocalDate[] fila1 = generarFechas(LocalDate.of(2022, 12, 1), LocalDate.of(2022, 12, 31));
        LocalDate[] fila2 = generarFechas(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 30));

        matrizReuniones[0] = fila0;
        matrizReuniones[1] = fila1;
        matrizReuniones[2] = fila2;

        return matrizReuniones;
    }

    /**
     * Genera un arreglo de fechas entre una fecha de inicio y una fecha de fin.
     * 
     * @param inicio Fecha de inicio del rango.
     * @param fin    Fecha de fin del rango.
     * @return Un arreglo de LocalDate con todas las fechas en el rango dado.
     */
    private LocalDate[] generarFechas(LocalDate inicio, LocalDate fin) {
        // Calcular el tamaño del arreglo en función de los días entre inicio y fin
        long diasEntre = ChronoUnit.DAYS.between(inicio, fin);
        LocalDate[] fechas = new LocalDate[(int) diasEntre + 1]; // +1 para incluir la fecha de fin
        LocalDate actual = inicio;

        // Llenar el arreglo de fechas
        for (int i = 0; i <= diasEntre; i++) {
            fechas[i] = actual;
            actual = actual.plusDays(1);
        }

        return fechas;
    }

    /**
     * 7. Obtener un arreglo con los contactos menores de 18 años
     * 
     * @return
     */
    public Contacto[] contactosMayores18() {
        Contacto[] contenedor = new Contacto[listaContactos.length];
        int index = 0;

        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] != null) {
                int edad = listaContactos[i].getEdad();
                if (edad < 18) {
                    contenedor[index] = listaContactos[i];
                    index++;
                }
            }
        }

        Contacto[] contactosMayores = new Contacto[index];
        for (int i = 0; i < index; i++) {
            contactosMayores[i] = contenedor[i];

        }

        return contactosMayores;
    }

    /**
     * 8. Calcula la desviación estándar de un arreglo de edades.
     * "la raíz cuadrada de la media de los cuadrados de las diferencias para
     * obtener la desviación estándar"
     * 
     * @return La desviación estándar de las edades.
     */
    public double calcularDesviacionEstandar() {
        double media = pormedioEdades();
        double sumaDiferencias = 0;
        int contador = 0;
        for (int i = 0; i < listaContactos.length; i++) {
            if (listaContactos[i] != null) {
                int edad = listaContactos[i].getEdad();
                sumaDiferencias += Math.pow(edad - media, 2);
                contador++;
            }
        }
        double varianza = sumaDiferencias / contador;
        return Math.sqrt(varianza);
    }

    /**
     * 9. Imprimir contactos de atrás hacia adelante
     */
    public void imprimirContactosReversa() {
        for (int i = listaContactos.length - 1; i > -1; i--) {
            if (listaContactos[i] != null) {
                System.out.println(listaContactos[i]);
            }
        }
    }

    /**
     * 10. Genera una edad aleatoria entre 15 y 60 con la formula
     * (int)(Math.random()*(X-Y+1)+Y). Donde X es 60 y Y 15
     * 
     * @return
     */
    public int edadAleatoria1560() {
        int aleatorio = (int) (Math.random() * (60 - 15 + 1) + 15);
        return aleatorio;
    }

    /**
     * 11. Solicita al usuario que ingrese una frase y convierte sus caracteres en
     * un arreglo de caracteres.
     */
    public char[] arregloFrases(String mensaje) {
        String respuesta = JOptionPane.showInputDialog(mensaje);
        char[] arregloFrase = respuesta.toCharArray();
        return arregloFrase;
    }

    /**
     * 12. Asocia un contacto a un grupo dado el nombre del grupo
     * 
     * @param contacto
     * @param nombreGrupo
     */
    public void añadirContactoGrupoConNombre(Contacto contacto, String nombreGrupo) {
        for (int i = 0; i < listaGrupos.length; i++) {
            if (listaGrupos[i] != null) {
                String nombre = listaGrupos[i].getNombre();
                if (nombre.equals(nombreGrupo)) {
                    listaGrupos[i].añadirContactoGrupo(contacto);
                    return;
                }
            }
        }
        System.out.println("Grupo no encontrado" + nombreGrupo);

    }

    /**
     * 13. Ordenar contactos segun la edad con ordenamiento burbuja
     */
    public void ordenarMenorAMayorEdad() {
        boolean intercambio;

        for (int i = 0; i < listaContactos.length - 1; i++) {
            intercambio = false;

            for (int j = 0; j < listaContactos.length - i - 1; j++) {
                if (listaContactos[j] != null && listaContactos[j + 1] != null) {
                    int edadJ = listaContactos[j].getEdad();
                    int edadJ1 = listaContactos[j + 1].getEdad();

                    if (edadJ > edadJ1) {
                        // Intercambiar los contactos con una cosa q se llama temp
                        Contacto temp = listaContactos[j];
                        listaContactos[j] = listaContactos[j + 1];
                        listaContactos[j + 1] = temp;
                        intercambio = true;
                    }
                }
            }

            // Si no hubo intercambios, la lista ya está ordenada
            if (!intercambio) {
                break;
            }
        }
    }

    // Interfaz con JOption

    public void menuPrincipal() {
        boolean repeat = true;
        while (repeat) {
            String opciones[] = { "Contactos", "Reuniones", "Grupos", "Salir" };

            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú Principal",
                    JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null) { // Manejar el caso en que el usuario cancela el diálogo
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            switch (seleccion) {
                case "Contactos":
                    menuContactos();
                    break;
                case "Reuniones":
                    menuReuniones();
                    break;
                case "Grupos":
                    menuGrupos();
                    break;
                case "Salir":
                    repeat = false;
                    break;
                default:
                    repeat = false;
                    break;
            }
        }
    }

    public void menuContactos() {
        boolean repeat = true;
        while (repeat) {
            String opciones[] = { "Crear", "Borrar", "Editar", "Buscar", "Atras", "Salir" };

            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú Contactos",
                    JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null) { // Manejar el caso en que el usuario cancela el diálogo
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            switch (seleccion) {
                case "Crear":
                    crearAñadirContacto();
                    break;
                case "Borrar":
                    Contacto contactoSeleccionado = (Contacto) JOptionPane.showInputDialog(null,
                            "Seleccione un contacto", "Menú Contactos",
                            JOptionPane.PLAIN_MESSAGE, null, listaContactos, listaContactos[0]);
                    if (contactoSeleccionado != null) {
                        eliminarContacto(contactoSeleccionado);
                    }
                    break;
                case "Editar":
                    contactoSeleccionado = (Contacto) JOptionPane.showInputDialog(null, "Seleccione un contacto",
                            "Menú Contactos",
                            JOptionPane.PLAIN_MESSAGE, null, listaContactos, listaContactos[0]);
                    if (contactoSeleccionado != null) {
                        editarContacto(contactoSeleccionado);
                    }
                    break;
                case "Buscar":
                    contactoSeleccionado = (Contacto) JOptionPane.showInputDialog(null, "Seleccione un contacto",
                            "Menú Contactos",
                            JOptionPane.PLAIN_MESSAGE, null, listaContactos, listaContactos[0]);
                    if (contactoSeleccionado != null) {
                        buscarContacto(contactoSeleccionado);
                    }
                    break;
                case "Atras":
                    return; // Regresar al menú principal
                case "Salir":
                    repeat = false;
                    break;
                default:
                    repeat = false;
                    break;
            }
        }
    }

    public void menuGrupos() {
        boolean repeat = true;
        while (repeat) {
            String opciones[] = { "Crear", "Borrar", "Editar", "Buscar", "añadir contacto", "eliminar contacto",
                    "Atras", "Salir" };

            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú Grupos",
                    JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null) { // Manejar el caso en que el usuario cancela el diálogo
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            switch (seleccion) {
                case "Crear":
                    crearAñadirGrupo();
                    break;
                case "Borrar":
                    Grupo grupoSeleccionado = (Grupo) JOptionPane.showInputDialog(null, "Seleccione un grupo",
                            "Menú Grupos",
                            JOptionPane.PLAIN_MESSAGE, null, listaGrupos, listaGrupos[0]);
                    if (grupoSeleccionado != null) {
                        eliminarGrupo(grupoSeleccionado);
                    }
                    break;
                case "Editar":
                    grupoSeleccionado = (Grupo) JOptionPane.showInputDialog(null, "Seleccione un grupo", "Menú Grupos",
                            JOptionPane.PLAIN_MESSAGE, null, listaGrupos, listaGrupos[0]);
                    if (grupoSeleccionado != null) {
                        editarGrupo(grupoSeleccionado);
                    }
                    break;
                case "Buscar":
                    grupoSeleccionado = (Grupo) JOptionPane.showInputDialog(null, "Seleccione un grupo", "Menú Grupos",
                            JOptionPane.PLAIN_MESSAGE, null, listaGrupos, listaGrupos[0]);
                    if (grupoSeleccionado != null) {
                        buscarGrupo(grupoSeleccionado);
                    }
                    break;
                case "Atras":
                    return; // Regresar al menú principal

                case "añadir contacto":
                    grupoSeleccionado = (Grupo) JOptionPane.showInputDialog(null, "Seleccione un grupo", "Menú Grupos",
                            JOptionPane.PLAIN_MESSAGE, null, listaGrupos, listaGrupos[0]);
                    Contacto contactoSeleccionado = (Contacto) JOptionPane.showInputDialog(null,
                            "Seleccione un contacto", "Menú Contactos",
                            JOptionPane.PLAIN_MESSAGE, null, listaContactos, listaContactos[0]);
                    if (contactoSeleccionado != null && grupoSeleccionado != null) {
                        grupoSeleccionado.añadirContactoGrupo(contactoSeleccionado);
                    }
                    break;

                case "eliminar contacto":
                    grupoSeleccionado = (Grupo) JOptionPane.showInputDialog(null, "Seleccione un grupo", "Menú Grupos",
                            JOptionPane.PLAIN_MESSAGE, null, listaGrupos, listaGrupos[0]);
                    contactoSeleccionado = (Contacto) JOptionPane.showInputDialog(null, "Seleccione un contacto",
                            "Menú Contactos",
                            JOptionPane.PLAIN_MESSAGE, null, listaContactos, listaContactos[0]);
                    if (contactoSeleccionado != null && grupoSeleccionado != null) {
                        grupoSeleccionado.eliminarContactoGrupo(contactoSeleccionado);
                    }
                    break;

                case "Salir":
                    repeat = false;
                    break;
                default:
                    repeat = false;
                    break;
            }
        }
    }

    public void menuReuniones() {
        boolean repeat = true;
        while (repeat) {
            String opciones[] = { "Crear", "Borrar", "Editar", "Buscar", "añadir contacto", "eliminar contacto",
                    "Atras", "Salir" };

            String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción", "Menú Reuniones",
                    JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            if (seleccion == null) { // Manejar el caso en que el usuario cancela el diálogo
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                return;
            }

            switch (seleccion) {
                case "Crear":
                    crearAñadirReunion();
                    break;
                case "Borrar":
                    Reunion reunionSeleccionada = (Reunion) JOptionPane.showInputDialog(null, "Seleccione una reunión",
                            "Menú Reuniones",
                            JOptionPane.PLAIN_MESSAGE, null, listaReuniones, listaReuniones[0]);
                    if (reunionSeleccionada != null) {
                        eliminarReunion(reunionSeleccionada);
                    }
                    break;
                case "Editar":
                    reunionSeleccionada = (Reunion) JOptionPane.showInputDialog(null, "Seleccione una reunión",
                            "Menú Reuniones",
                            JOptionPane.PLAIN_MESSAGE, null, listaReuniones, listaReuniones[0]);
                    if (reunionSeleccionada != null) {
                        editarReunion(reunionSeleccionada);
                    }
                    break;
                case "Buscar":
                    reunionSeleccionada = (Reunion) JOptionPane.showInputDialog(null, "Seleccione una reunión",
                            "Menú Reuniones",
                            JOptionPane.PLAIN_MESSAGE, null, listaReuniones, listaReuniones[0]);
                    if (reunionSeleccionada != null) {
                        buscarReunion(reunionSeleccionada);
                    }
                    break;
                case "Atras":
                    return; // Regresar al menú principal

                    case "añadir contacto":
                    reunionSeleccionada = (Reunion) JOptionPane.showInputDialog(null, "Seleccione un grupo", "Menú Grupos",
                            JOptionPane.PLAIN_MESSAGE, null, listaReuniones, listaReuniones[0]);
                    Contacto contactoSeleccionado = (Contacto) JOptionPane.showInputDialog(null,
                            "Seleccione un contacto", "Menú Contactos",
                            JOptionPane.PLAIN_MESSAGE, null, listaContactos, listaContactos[0]);
                    if (contactoSeleccionado != null && reunionSeleccionada != null) {
                        reunionSeleccionada.agregarContactoAsistente(contactoSeleccionado);
                    }
                    break;

                case "eliminar contacto":
                    reunionSeleccionada = (Reunion) JOptionPane.showInputDialog(null, "Seleccione un grupo", "Menú Grupos",
                JOptionPane.PLAIN_MESSAGE, null, listaReuniones, listaReuniones[0]);
                    contactoSeleccionado = (Contacto) JOptionPane.showInputDialog(null, "Seleccione un contacto",
                            "Menú Contactos",
                            JOptionPane.PLAIN_MESSAGE, null, listaContactos, listaContactos[0]);
                    if (contactoSeleccionado != null && reunionSeleccionada != null) {
                        reunionSeleccionada.eliminarContactoAsistente(contactoSeleccionado);
                    }
                    break;
                case "Salir":
                    repeat = false;
                    break;
                default:
                    repeat = false;
                    break;
            }
        }
    }

}
