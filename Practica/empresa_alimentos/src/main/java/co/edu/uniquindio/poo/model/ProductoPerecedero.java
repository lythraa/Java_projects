package co.edu.uniquindio.poo.model;

import java.util.Date;

public class ProductoPerecedero extends ProductoBase{
    private Date fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre, double precioCompra, String proveedor,
            PaisOrigen paisOrigen, Date fechaVencimiento) {
        super(codigo, nombre, precioCompra, proveedor, paisOrigen);
        this.fechaVencimiento = fechaVencimiento;
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

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    

}
