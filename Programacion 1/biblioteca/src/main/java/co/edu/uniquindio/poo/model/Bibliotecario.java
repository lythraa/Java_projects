package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.time.LocalDate;

public class Bibliotecario extends Usuario{

    private double salario;
    private LocalDate añoContratacion;
    private LinkedList<Prestamo> listaPrestamosDeUnBibliotecario;


    public Bibliotecario(String nombre, String id, String telefono, String correo, double salario, LocalDate añoContratacion){
        super(nombre, id, correo);
        this.salario = salario;
        this.añoContratacion = añoContratacion;
        this.listaPrestamosDeUnBibliotecario =  new LinkedList<Prestamo>();
        
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
