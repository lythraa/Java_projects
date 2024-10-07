package co.edu.uniquindio.poo.model;

public class DetallePrestamo {

    private Libro libroPrestamo;
    private double subTotal;
    private int cantidad;

    public DetallePrestamo(Libro libroPrestamo, int cantidad){
        this.libroPrestamo=libroPrestamo;
        this.cantidad = cantidad;
        this.subTotal = calcularSubtotal();
    }

    public double calcularSubtotal(){
        return libroPrestamo.getPrecio()*cantidad;
    }

    public Libro getLibroPrestamo() {
        return libroPrestamo;
    }

    public void setLibroPrestamo(Libro libroPrestamo) {
        this.libroPrestamo = libroPrestamo;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    } 

}