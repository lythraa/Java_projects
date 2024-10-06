package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private String codigo;
    private double total;
    private LinkedList<DetallePrestamo> listaDetallePrestamos;
    private Bibliotecario bibliotecarioPrestamo;
    private Estudiante estudiantesPrestamo;
 
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo, double total,
            LinkedList<DetallePrestamo> listaDetallePrestamos, Bibliotecario bibliotecarioPrestamo,
            Estudiante estudiantesPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.codigo = codigo;
        this.total = total;
        this.listaDetallePrestamos = listaDetallePrestamos;
        this.bibliotecarioPrestamo = bibliotecarioPrestamo;
        this.estudiantesPrestamo = estudiantesPrestamo;
    }


    /**
     * Metodo para añadir un detalle a un prestamo
     * @param codigoPrestamo
     * @param isbn
     * @param subtotal
     * @param cantidad
     * @return Un mensaje indicando que el DetallePrestamo se agrego, no existía el prestamo o no habían suficientes unidades disponibles para realizarlo.
     *
    public String añadirDetallePrestamo(String codigoPrestamo, String isbn, double subtotal, int cantidad) {
        Prestamo prestamo = listaPrestamos.get(codigoPrestamo);
        Libro libro = buscarLibroPorIsbn(isbn);

        if (prestamo == null){
            return "Prestamo no encontrado.";
        }
        if (libro == null || libro.getUnidadesDisponibles()<cantidad){
            return "No hay suficientes unidades disponibles.";
        }

        libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - cantidad);//actualizacion de cantidad ded libros
        prestamo.getListaDetallePrestamos().put(isbn, new DetallePrestamo(isbn, subtotal, cantidad));

        return "Detalle del producto añadido correctamente.";
    }


    /**
     * Elimina un detalle de préstamo asociado a un producto por su nombre.
     * @param codigoPrestamo
     * @param isbn
     * @return Un mensaje indicando si el detalle fue eliminado correctamente o si
     *         no se encontró el producto.
     *
    public String eliminarDetalleProducto(String codigoPrestamo,String isbn) {
        Prestamo prestamo = listaPrestamos.get(codigoPrestamo);
        if  (prestamo == null){
            return "Prestamo no encontrado";
        }

        DetallePrestamo detalle = prestamo.getListaDetallePrestamos().get(isbn);
        if (detalle == null){
            return "Detalle no encontrado en el prestamo";
        }

        Libro libro = buscarLibroPorIsbn(isbn);
        
        if (libro != null) {
            libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() + detalle.getCantidad());
        }
        prestamo.getListaDetallePrestamos().remove(isbn);

        return "Detalle eliminado correctamente.";
    }

    /**
     * Busca un detalle de préstamo por el nombre del producto.
     * @param codigoPrestamo
     * @param isbn
     * @return El detalle de préstamo encontrado o null si no se encuentra en la
     *         lista.
     *
    public DetallePrestamo buscarDetallePrestamo(String codigoPrestamo,String isbn) {
        Prestamo prestamo = listaPrestamos.get(codigoPrestamo);
        return prestamo.getListaDetallePrestamos().get(isbn);
    }

    
     /**
      * Edita el detalle de un producto en el préstamo.
      * @param codigoPrestamo
      * @param isbn
      * @param nuevaCantidad  La nueva cantidad del producto.
      * @param nuevoSubtotal  El nuevo subtotal del producto.
      * @return Un mensaje indicando si el detalle fue editado correctamente o si no
     *         se encontró el producto.
      *
    public String editarDetallePrestamo(String codigoPrestamo, String isbn, int nuevaCantidad, double nuevoSubtotal) {
        Prestamo prestamo = listaPrestamos.get(codigoPrestamo);
        if (prestamo ==null){
            return "Prestamo no encontrado.";
        }
        
        DetallePrestamo detalle = prestamo.getListaDetallePrestamos().get(isbn);
        if (detalle ==null) {
            return "Detalle no encontrado.";
        }
        detalle.setIsbn(isbn);
        detalle.setCantidad(nuevaCantidad);
        detalle.setSubTotal(nuevoSubtotal);

        return "Detalle del producto editado correctamente";
         
    }
            */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public Bibliotecario getBibliotecarioPrestamo() {
        return bibliotecarioPrestamo;
    }


    public void setBibliotecarioPrestamo(Bibliotecario bibliotecarioPrestamo) {
        this.bibliotecarioPrestamo = bibliotecarioPrestamo;
    }


    public Estudiante getEstudiantesPrestamo() {
        return estudiantesPrestamo;
    }


    public void setEstudiantesPrestamo(Estudiante estudiantesPrestamo) {
        this.estudiantesPrestamo = estudiantesPrestamo;
    }

    public LinkedList<DetallePrestamo> getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }

    public void setListaDetallePrestamos(LinkedList<DetallePrestamo> listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }
}
