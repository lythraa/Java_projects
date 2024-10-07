package co.edu.uniquindio.poo.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.time.LocalDate;

public class Biblioteca {

    private String nombre;
    
    private HashMap<String, Libro> listaLibros;
    private LinkedList<Bibliotecario> listaBibliotecarios;
    private HashMap<String, Estudiante> listaEstudiantes;
    private HashMap<String, Prestamo> listaPrestamos;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.listaLibros = new HashMap<String, Libro>();
        this.listaBibliotecarios = new LinkedList<Bibliotecario>();
        this.listaEstudiantes = new HashMap<String, Estudiante>();
        this.listaPrestamos = new HashMap<String, Prestamo>();

    }

    //añadir eliminar y actualizar reciben objetos
    //mientras que buscar solo la llave y retorna un objeto

    //manejar la excepcion de colocar vacias las claves
    //──────────────────────── ≪CRUD LIBRO≫ ────────────────────────//
    
    /**
     * AÑADE un libro a la lista de libros si no existe ya por su key (ISBN)
     * 
     * @param libro El libro a añadir.
     * @return Un mensaje indicando si el libro fue añadido correctamente o si ya existía.
     * @throws IllegalArgumentException si el libro es  nulo
     */
    public String añadirLibro(Libro libro) throws IllegalArgumentException{
        if (libro==null){
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        if (listaLibros.containsKey(libro.getIsbn())) {
            return "El libro ya existe";
        }
        listaLibros.put(libro.getIsbn(), libro);
        return "Libro añadido correctamente";
    }

    /**
     * ELIMINA un libro de la lista de libros si existe.
     * 
     * @param libroEliminar El libro a eliminar.
     * @return Un mensaje indicando si el libro fue eliminado correctamente o si
     *         no existe en la lista.
     * @throws IllegalArgumentException si el libro es nulo
     */
    public String eliminarLibro(Libro libroEliminar) throws IllegalArgumentException{ 
        if (libroEliminar==null){
            throw new IllegalArgumentException("El libro no puede ser nulo");
        }
        if (!listaLibros.containsKey(libroEliminar.getIsbn())){
            return "El libro no existe";
        }
        listaLibros.remove(libroEliminar.getIsbn());
        return "Libro eliminado correctamente";
    }

    /**
     * BUSCA un libro por su isbn
     * 
     * @param isbn
     * @return devuelve el libro encontrado
     * @throws IllegalArgumentException si el isbn es nulo o vacio
     */
    public Libro buscarLibroPorIsbn(String isbn) throws IllegalArgumentException{
        if (isbn==null||isbn.isEmpty()){
            throw new IllegalArgumentException("El isbn no puede ser nulo");
        }
    
        Libro libroEncontrado = listaLibros.get(isbn);
        return libroEncontrado;
    }


    /**
     * ACTUALIZA un libro existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param isbn El isbn del libro a buscar
     * @param libroActualizado El nuevo libro con la información actualizada.
     * @return Un mensaje indicando si el libro fue encontrado y editado o no.
     * @throws IllegalArgumentException si el isbn es nulo o el libro es nulo
     */
    public String actualizarLibro(String isbn, Libro libroActualizado) throws IllegalArgumentException{
        if (isbn==null || libroActualizado==null){
            throw new IllegalArgumentException("El isbn o el libro no puede ser nulo");
        }
        if (buscarLibroPorIsbn(isbn)==null){
            return "No se encontró el libro a editar";
        }
        listaLibros.put(isbn, libroActualizado);
        return "Libro editado correctamente";
    }
    

    //──────────────────────── ≪CRUD BIBLIOTECARIO≫ ────────────────────────//

    /**
     * AÑADE un bibliotecario a la lista si no existe ya.
     * 
     * @param bibliotecario El bibliotecario a añadir.
     * @return Un mensaje indicando si el bibliotecario fue añadido correctamente o
     *         si ya existía.
     * @throws IllegalArgumentException
     */
    public String añadirBibliotecario(Bibliotecario bibliotecario) throws IllegalArgumentException{
        if (bibliotecario==null){
            throw new IllegalArgumentException("El bibliotecario no puede ser nulo");
        }
        if (listaBibliotecarios.contains(bibliotecario)){
            return "El bibliotecario ya existe";
        }
        listaBibliotecarios.add(bibliotecario);
        return "Bibliotecario añadido correctamente";

    }

    /**
     * ELIMINA un bibliotecario de la lista si existe.
     * 
     * @param bibliotecario El bibliotecario a eliminar.
     * @return Un mensaje indicando si el bibliotecario fue eliminado correctamente
     *         o si no existía.
     * @throws IllegalArgumentException
     */
    public String eliminarBibliotecario(Bibliotecario bibliotecario) throws IllegalArgumentException{
        if (bibliotecario==null){
            throw new IllegalArgumentException("El Bibliotecario no puede ser nulo");
        }
        if(!listaBibliotecarios.contains(bibliotecario)){
            return "El Bibliotecario no existe";
        }
        listaBibliotecarios.remove(bibliotecario);
            return "Bibliotecario eliminado correctamente";
    }

    
    /**
     * BUSCA un bibliotecario en la lista por su id.
     * 
     * @param idBuscar la id del bibliotecario que se quiere buscar
     * @return El bibliotecario encontrado o null si no se encuentra en la lista
     * @throws IllegalArgumentException si la id es nula o vacia
     */
    public Bibliotecario buscarBibliotecarioId(String idBuscar) throws IllegalArgumentException{
        if (idBuscar==null||idBuscar.isEmpty()){
            throw new IllegalArgumentException("La id no puede ser nula");
        }
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            if(bibliotecario.getId().equals(idBuscar))
            return bibliotecario;
        }
        return null;
    }

    /**
     * ACTUALIZA un bibliotecario existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param id la id del bibliotecario que se desea actualizar
     * @param nuevoBibliotecario El nuevo bibliotecario con la información actualizada
     * @return Un mensaje indicando si el bibliotecario fue editado o no se encontró
     * @throws IllegalArgumentException si la id es nula o vacía, o si el nuevo bibliotecario es nulo
     */
    public String actualizarBibliotecario(String id, Bibliotecario nuevoBibliotecario) throws IllegalArgumentException{
        if(id==null||id.isEmpty()){
            throw new IllegalArgumentException("la id no puede ser nula o vacía");
        }
        if(nuevoBibliotecario==null){
            throw new IllegalArgumentException("El bibliotecario no puede ser nulo");
        }
        if (buscarBibliotecarioId(id) == null) {
            return "No se encontró el bibliotecario";
        }
        Bibliotecario oldBibl = buscarBibliotecarioId(id);
        listaBibliotecarios.set(listaBibliotecarios.indexOf(oldBibl), nuevoBibliotecario);
        return "Bibliotecario editado con éxito";

    }

    //──────────────────────── ≪CRUD ESTUDIANTE≫ ────────────────────────//

    /**
     * AÑADE un estudiante a la lista si no existe ya por si id (id)
     * 
     * @param estudiante El estudiante a añadir.
     * @return Un mensaje indicando si el estudiante fue añadido correctamente o si
     *         ya existía.
     * @throws IllegalArgumentException si el estudiante es nulo
     */
    public String añadirEstudiante(Estudiante estudiante) throws IllegalArgumentException{
        if (estudiante==null){
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        if (listaEstudiantes.containsKey(estudiante.getId())){
            return "El estudiante ya existe o su id ya esta registrada";
        }
        listaEstudiantes.put(estudiante.getId(), estudiante);
        return  "Estudiante añadido exitosamente";
    }

    /**
     * ELIMINA un estudiante de la lista si existe.
     * 
     * @param estudianteEliminar estudiante a eliminar
     * @return Un mensaje indicando si el estudiante fue eliminado correctamente o
     *         si no existía.
     * @throws IllegalArgumentException si el estudiante es nulo
     */
    public String eliminarEstudiante(Estudiante estudianteEliminar) throws IllegalArgumentException{
        if(estudianteEliminar==null){
            throw new IllegalArgumentException("El estudiante no puede ser nulo");
        }
        if(!listaEstudiantes.containsKey(estudianteEliminar.getId())){
            return "El estudiante no existe";
        }
        listaEstudiantes.remove(estudianteEliminar.getId());
        return "Estudiante eliminado correctamente";
    }

    /**
     * BUSCA un estudiante en la lista por su ID.
     * 
     * @param id El ID del estudiante a buscar.
     * @return El estudiante encontrado o null si no se encuentra en la lista.
     * @throws IllegalArgumentException si la id es nula o vacia
     */
    public Estudiante buscarEstudianteId(String id) throws IllegalArgumentException{
        if(id==null || id.isEmpty()){
            throw new IllegalArgumentException("La id no puede ser nula");
        }
        Estudiante estudianteEncontrado = listaEstudiantes.get(id);
        return estudianteEncontrado;
    }

    /**
     * ACTUALIZA un estudiante existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param id              El ID del estudiante actual que se desea editar.
     * @param estudianteActualizado El nuevo estudiante con la información actualizada.
     * @return Un mensaje indicando si el estudiante fue encontrado y editado o no.
     * @throws IllegalArgumentException si la id o el estudiante a actualizar es nulo
     */
    public String actualizarEstudiante(String id, Estudiante estudianteActualizado) throws IllegalArgumentException{
        if (id==null || estudianteActualizado==null){
            throw new IllegalArgumentException("La id o el estudiante no pueden ser nulos");
        }
        if (buscarEstudianteId(id)==null) {
            return "No se encontró el estudiante a editar";
        }
        listaEstudiantes.put(id, estudianteActualizado);
        return "Estudiante actualizado exitosamente";
    }

    //──────────────────────── ≪CRUD PRESTAMO + crear prestamo≫ ────────────────────────

    /**
     * CREA Y AÑADE un prestamo a la lista de prestamos
     * 
     * @param fechaPrestamo
     * @param codigo
     * @param bibliotecarioPrestamo
     * @param estudiantesPrestamo
     * @param listaLibrosPedidos
     * @return un mensaje con lo que ocurrio con cada libro pedido.
     */
    public String crearAñadirPrestamo(LocalDate fechaPrestamo, String codigo, Bibliotecario bibliotecarioPrestamo,
                              Estudiante estudiantesPrestamo, HashMap<String, Integer> listaLibrosPedidos){
        String resultado = "";
        LinkedList<DetallePrestamo> listaDetallePrestamos = new LinkedList<>();
        Prestamo prestamo = new Prestamo(fechaPrestamo, null, codigo,listaDetallePrestamos, bibliotecarioPrestamo, estudiantesPrestamo);

        for (String isbn : listaLibrosPedidos.keySet()) {
            Libro libroPedido = buscarLibroPorIsbn(isbn);
            int cantidad = listaLibrosPedidos.get(isbn);

            if (libroPedido==null){
                resultado += "El libro con el código "+ isbn +" no existe\n";
            }
            else if (!libroPedido.prestarLibro(cantidad)) {
                resultado += "No hay suficientes unidades disponibles del libro "+libroPedido.getTitulo()+" para ser prestadas\n";

            }else{
                prestamo.crearAñadirDetallePrestamo(libroPedido, cantidad);
                resultado +="Se han prestado "+cantidad+" de copias del libro: " +libroPedido.getTitulo()+"\n";
            }
            
        }
        return resultado;
    }

    /**
     * Elimina un préstamo de la lista si existe.
     * 
     * @param codigo El código del préstamo a eliminar.
     * @return Un mensaje indicando si el préstamo fue eliminado correctamente o si
     *         no existía.
     */
    public String eliminarPrestamo(String codigo, Bibliotecario bibliotecario, Estudiante estudiante) {
        String mensaje = "Prestamo no existe";
        if (listaPrestamos.get(codigo) == null) {
            listaPrestamos.remove(codigo);
            bibliotecario.getListaPrestamosDeUnBibliotecario().remove(listaPrestamos.get(codigo));
            estudiante.getListaPrestamosDeUnEstudiante().remove(listaPrestamos.get(codigo));
            
            mensaje = "Prestamo eliminado correctamente";
        }

        return mensaje;
    }

    /**
     * Busca un préstamo en la lista por su código.
     * 
     * @param codigo El código del préstamo a buscar.
     * @return El préstamo encontrado o null si no se encuentra en la lista.
     */
    public Prestamo buscarPrestamoCodigo(String codigo) {
        return listaPrestamos.get(codigo);
    }

    /**
     * Edita un préstamo existente en la lista reemplazándolo por uno nuevo.
     * 
     * @param codigo        El código del préstamo actual que se desea editar.
     * @param prestamoNuevo El nuevo préstamo con la información actualizada.
     * @return Un mensaje indicando si el préstamo fue encontrado y editado o no.
     */

    public String editarPrestamo(String codigo, Prestamo prestamoNuevo) {
        String mensaje = "No se encontró";
        if (buscarEstudianteId(codigo) != null) {
            listaPrestamos.put(codigo, prestamoNuevo);
            mensaje = "Elemento editado correctamente";
        }
        return mensaje;
    }

    

    //──────────────────────── ≪OTROS METODOS≫ ────────────────────────
    
    


    /**
     * busca un libro por su codigo
     * @param codigo
     * @return
     *
    public Libro buscarLibroCodigo(String codigo){
        for (int index = 0; index < listaLibros.size(); index++) {
            String codigoaux = listaLibros.get(index).getCodigo();
            if (codigo.equals(codigoaux)) {
                return listaLibros.get(index);
            }
        }
        return null;
    }/
    

    /**
     * busca un libro por su nombre
     * @param nombre
     * @return el libro c:
     */
    public Libro buscarLibroNombre(String nombre){
    
        return null;
    }
    
    /**Consultar dado el nombre del Libro la cantidad de préstamos en el cual está incluido, es decir si un Libro está incluido en dos préstamos la respuesta sería 2).
     * 3.3
     * @param nombre
     * @return
     */
    public int cantidadPrestamosLibro(String isbn){
        return buscarLibroPorIsbn(isbn).getListaPrestamos().size();
    }
        
    
    //3.4 = editarLibro.

    //4.3 Entregar Prestamo

    public void entregarPrestamo(){
        
    }

    /**
     * 4.4 Consultar datos de un prestamo dado su codigo
     * @param codigoPrestamo
     * @return
     */
    public String datosPrestamoSegunCodigo(String codigoPrestamo){
        Prestamo prestamo = listaPrestamos.get(codigoPrestamo);
        return prestamo.toString();
    }

    /**
     * 4.5 Mostrar la cantidad de prestamos realizados por cada empleado
     */
    public void mostrarCantidadPrestamosCdaBibliotecarios(){
        String mensaje="Bibliotecarios con su respectivo numero de prestamos: \n";
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            int numeroPrestamos = bibliotecario.getListaPrestamosDeUnBibliotecario().size();
            String nombreBibliotecario = bibliotecario.getNombre();
            mensaje+= nombreBibliotecario +": "+ numeroPrestamos + "\n";
        }

        System.out.println(mensaje);
    }


    /**
     * 5.1 datos del estudiante con mas prestamos(sin importar que libro)
     * @return String con los datos del estudiante con mas prestamos
     */
    public String estudianteMasPrestamos(){
        Estudiante estudianteMasPrestamos = null;
        int numeroMasPrestamos = 0;
        for (Estudiante estudiante : listaEstudiantes.values()) {
            int numeroPrestamos = estudiante.getListaPrestamosDeUnEstudiante().size();
            if (numeroPrestamos>numeroMasPrestamos){
                numeroMasPrestamos = numeroPrestamos;
                estudianteMasPrestamos = estudiante;
            }
        }
        if (estudianteMasPrestamos==null){
            return "No existen prestamos";
        }else{
            return (estudianteMasPrestamos.toString());
        }
        
    }

    /**
     * 
     * @param codigoPrestamo
     * @return Total de un prestamo
     *
    public double calcularTotalPrestamo(String codigoPrestamo){
        double total = 0;
        Prestamo prestamoaux = listaPrestamos.get(codigoPrestamo);
        HashMap <String, DetallePrestamo>listaDetalles = prestamoaux.getListaDetallePrestamos();

        for (DetallePrestamo detalle : listaDetalles.values()) {
            double n = detalle.getSubTotal();
            total+= n;
            //me ayudas a revisar si el return anterior esta bueno? vale 
        }
        return total;
    }
        /
    
    /**
     * 5.2 total de dinero recaudado por la empresa
     * @return double total de dinero recaudado por la empresa
     */
    public double dinero(){
        double totalDinero = 0;
        for (Prestamo prestamo : listaPrestamos.values()) {
            double n = prestamo.getTotal();
            totalDinero += n;
        }
        
        return totalDinero;
    }


    /**
     * 5.3 dinero a pagar salarios
     * @return Salario total de todos los bibliotecarios.
     */
    public double pagarSalarios(){
        double salarios= 0;
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            salarios += pagarBibliotecario(bibliotecario);
        }
        return salarios;
    }
 
    /**
     * 
     * @param bibliotecario
     * @return Sueldo de un bibliotecario.
     */
    public double pagarBibliotecario(Bibliotecario bibliotecario){
        int añosAntiguedad = LocalDate.now().getYear() - bibliotecario.getAñoContratacion().getYear();
        double sueldoEmpleado=0;
        for (Prestamo prestamo : bibliotecario.getListaPrestamosDeUnBibliotecario()) {
            double valorPrestamo = prestamo.getTotal();
            double porcentajeEdadAumento = añosAntiguedad*0.02;
            sueldoEmpleado += (valorPrestamo*0.2)+(valorPrestamo*(porcentajeEdadAumento));
            
        }
        return sueldoEmpleado;
    }



    // **Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(LinkedList<Bibliotecario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    public HashMap<String, Libro> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(HashMap<String, Libro> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public HashMap<String, Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(HashMap<String, Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public HashMap<String, Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(HashMap<String, Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}
