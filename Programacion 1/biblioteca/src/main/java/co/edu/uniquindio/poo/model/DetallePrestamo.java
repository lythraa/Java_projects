package co.edu.uniquindio.poo.model;

public class DetallePrestamo {

    private String isbn;
    private double subTotal;
    private int cantidad;

    public DetallePrestamo(String isbn ,double subTotal, int cantidad){
        this.isbn = isbn;
        this.subTotal = subTotal;
        this.cantidad = cantidad;

    }


    public String getIsbn() {
        return isbn;
    }

    
    public void setIsbn(String nombre) {
        this.isbn = nombre;
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
