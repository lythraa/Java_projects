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
 
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo,
            LinkedList<DetallePrestamo> listaDetallePrestamos, Bibliotecario bibliotecarioPrestamo,
            Estudiante estudiantesPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.codigo = codigo;
        this.listaDetallePrestamos = listaDetallePrestamos;
        this.bibliotecarioPrestamo = bibliotecarioPrestamo;
        this.estudiantesPrestamo = estudiantesPrestamo;
        this.total = calcularTotal();
    }
    
    
    public double calcularTotal(){
        double resultado =0.0;
        for (DetallePrestamo detallePrestamo : listaDetallePrestamos) {
            resultado+= detallePrestamo.getSubTotal();
        }
        return resultado;
    }
    /**
     * Metodo para añadir y crear un detalle a un prestamo
     * @param codigoPrestamo
     * @param 
     * @param subtotal
     * @param cantidad
     * @return Un mensaje indicando que el DetallePrestamo se agrego
     */
    public String crearAñadirDetallePrestamo(Libro libro, int cantidad) {
        DetallePrestamo detalle = new DetallePrestamo(libro, cantidad);
        listaDetallePrestamos.add(detalle);
        return "Detalle del producto añadido correctamente.";
    }

    public String eliminarDetallePrestamo(String codigoPrestamo, String isbn) {
        for (DetallePrestamo detalle : listaDetallePrestamos) {
            if (detalle.getLibroPrestamo().getIsbn().equals(isbn)) {
                listaDetallePrestamos.remove(detalle);
                detalle.getLibroPrestamo().devolverLibro(detalle.getCantidad());
                return "Detalle eliminado correctamente.";
            }
        }
        return "Detalle no encontrado.";
    }

    public String editarDetallePrestamo(String isbn, int nuevaCantidad) {
        for (DetallePrestamo detalle : listaDetallePrestamos) {
            if (detalle.getLibroPrestamo().getIsbn().equals(isbn)) {
                detalle.getLibroPrestamo().devolverLibro(detalle.getCantidad());
                detalle.getLibroPrestamo().prestarLibro(nuevaCantidad);
    
                // Actualiza la cantidad y el subtotal
                detalle.setCantidad(nuevaCantidad);
                detalle.setSubTotal(detalle.calcularSubtotal());
                return "Detalle del producto editado correctamente.";
            }
        }
        return "Detalle no encontrado.";
    }

    public DetallePrestamo buscarDetallePrestamo(String isbn) {
        for (DetallePrestamo detalle : listaDetallePrestamos) {
            if (detalle.getLibroPrestamo().getIsbn().equals(isbn)) {
                return detalle;
            }
        }
        return null;
    }
    

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
