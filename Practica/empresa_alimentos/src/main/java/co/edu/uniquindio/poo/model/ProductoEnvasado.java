package co.edu.uniquindio.poo.model;

import java.util.Date;

public class ProductoEnvasado extends Producto{
    private Date fechaEnvasado;
    private double pesoEnvase;
    
    public ProductoEnvasado(String codigo, String nombre, double precioCompra, String proveedor, PaisOrigen paisOrigen,
            Date fechaEnvasado, double pesoEnvase) {
        super(codigo, nombre, precioCompra, proveedor, paisOrigen);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
    }

    //Los productos envasados se venden con una utilidad de $ 300,oo sobre cada gramo del peso del envase.
    @Override
    public double calcularPrecioVenta() {
        return pesoEnvase*300;
    }

    //para productos envasados, es del 10%. 
    @Override
    public double calcularImpuesto() {
        double precioVenta = calcularPrecioVenta();
        return precioVenta*0.1;
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
