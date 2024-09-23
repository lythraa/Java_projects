package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.time.LocalDate;

public class Bibliotecario {

    private String nombre;
    private String id;
    private String telefono;
    private String correo;
    private double salario;
    private LocalDate añoContratacion;
    private LinkedList<Prestamo> listaPrestamosDeUnBibliotecario;


    public Bibliotecario(String nombre, String id, String telefono, String correo, double salario, LocalDate añoContratacion){
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.correo = correo;
        this.salario = salario;
        this.añoContratacion = añoContratacion;
        this.listaPrestamosDeUnBibliotecario =  new LinkedList<Prestamo>();
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public LinkedList<Prestamo> getListaPrestamosDeUnBibliotecario() {
        return listaPrestamosDeUnBibliotecario;
    }

    public void setListaPrestamosDeUnBibliotecario(LinkedList<Prestamo> listaPrestamosDeUnBibliotecario) {
        this.listaPrestamosDeUnBibliotecario = listaPrestamosDeUnBibliotecario;
    }

    public LocalDate getAñoContratacion() {
        return añoContratacion;
    }

    public void setAñoContratacion(LocalDate añoContratacion) {
        this.añoContratacion = añoContratacion;
    }
    
}
