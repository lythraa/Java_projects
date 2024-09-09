package co.edu.uniquindio.poo.model;

public class Producto {
    private String nombre;
    private double precioCompra;
    private double precioVenta=0;
    private TipoProducto tipo;

    public Producto(String nombre, double precioCompra, TipoProducto tipo){
        this.nombre = nombre;
        this.precioCompra= precioCompra;
        this.tipo = tipo;
        calcularPrecioVenta();
    }

    public void calcularPrecioVenta() {
        double incremento = 0.0;
    
        switch (tipo) {
            case PERECEDERO:
                incremento = 0.15;
                break;
            case REFRIGERADO:
                incremento = 0.1;
                break;
            case NOPERECEDERO:
                incremento = 0.05;
                break;
            default:
                System.out.println("El producto no tiene un tipo registrado.");
                incremento = 0.0;
                break;
        }
    
        this.precioVenta = precioCompra + (precioCompra * incremento);
    }
    
    /* codigo con ejecutables redundantes
    public double calcularPrecioVenta(Producto producto){
        if (tipo.equals(TipoProducto.PERECEDERO)){
            precioVenta = precioCompra + (precioCompra*0.15);
        }else if (tipo.equals(TipoProducto.REFRIGERADO)) {
            precioVenta = precioCompra + (precioCompra*0.1);  
        }else if (tipo.equals(TipoProducto.NOPERECEDERO)) {
            precioVenta = precioCompra + (precioCompra*0.05);
        }
        return precioVenta;
    }
    */
    public void mostrarProducto(Producto producto){
        calcularPrecioVenta();
        System.out.println("El producto"+ nombre + ", tiene un precio final de" + precioVenta + ".");
    }

    //getters y setters

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public double getPrecioCompra(){
        return precioCompra;
    }
    public void setPrecioCompra(double precioCompra){
        this.precioCompra=precioCompra;
    }

    public double getPrecioVenta(){
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta){
        this.precioVenta= precioVenta;
    }
    public TipoProducto getTipo(){
        return tipo;
    }
    public void setTipo(TipoProducto tipo){
        this.tipo=tipo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precioCompra);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(precioVenta);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (Double.doubleToLongBits(precioCompra) != Double.doubleToLongBits(other.precioCompra))
            return false;
        if (Double.doubleToLongBits(precioVenta) != Double.doubleToLongBits(other.precioVenta))
            return false;
        if (tipo != other.tipo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta
                + ", tipo=" + tipo + "]";
    }

    
}
