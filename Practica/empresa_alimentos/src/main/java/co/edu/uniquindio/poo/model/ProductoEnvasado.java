package co.edu.uniquindio.poo.model;

import java.util.Date;

public class ProductoEnvasado extends ProductoBase{
    private Date fechaEnvasado;
    private double pesoEnvase;
    
    public ProductoEnvasado(String codigo, String nombre, double precioCompra, String proveedor, PaisOrigen paisOrigen,
            Date fechaEnvasado, double pesoEnvase) {
        super(codigo, nombre, precioCompra, proveedor, paisOrigen);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
    }

    @Override
    public double calcularPrecioVenta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrecioVenta'");
    }

    @Override
    public double calcularImpuesto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularImpuesto'");
    }

    public Date getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(Date fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public double getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(double pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }
    
    

}
