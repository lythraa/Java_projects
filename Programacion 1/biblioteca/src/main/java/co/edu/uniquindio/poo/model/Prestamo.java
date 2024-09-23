package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.HashMap;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private String codigo;
    private double total;
    private HashMap<String, DetallePrestamo> listaDetallePrestamos;
    private Bibliotecario bibliotecarioPrestamo;
    private Estudiante estudiantesPrestamo;
 
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaEntrega, String codigo, double total,
            HashMap<String, DetallePrestamo> listaDetallePrestamos, Bibliotecario bibliotecarioPrestamo,
            Estudiante estudiantesPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaEntrega = fechaEntrega;
        this.codigo = codigo;
        this.total = total;
        this.listaDetallePrestamos = listaDetallePrestamos;
        this.bibliotecarioPrestamo = bibliotecarioPrestamo;
        this.estudiantesPrestamo = estudiantesPrestamo;
    }

    
    // Setters & Getters :D


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

    public HashMap<String, DetallePrestamo> getListaDetallePrestamos() {
        return listaDetallePrestamos;
    }

    public void setListaDetallePrestamos(HashMap<String, DetallePrestamo> listaDetallePrestamos) {
        this.listaDetallePrestamos = listaDetallePrestamos;
    }
}
