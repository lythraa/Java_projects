package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto{
    private LocalDate fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre, double precioCompra, String proveedor,
            PaisOrigen paisOrigen, LocalDate fechaVencimiento) {
        super(codigo, nombre, precioCompra, proveedor, paisOrigen);
        this.fechaVencimiento = fechaVencimiento;
    }

    //Los productos perecederos se venden con una utilidad del 35% sobre el precio de compra
    @Override
    public double calcularPrecioVenta() {
        return getPrecioCompra() * 1.35;
    }

    //si se trata de un producto perecedero, se aplica un impuesto del 8% 
    @Override
    public double calcularImpuesto() {
        double precioVenta = calcularPrecioVenta();
        return precioVenta*0.08;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    

}
