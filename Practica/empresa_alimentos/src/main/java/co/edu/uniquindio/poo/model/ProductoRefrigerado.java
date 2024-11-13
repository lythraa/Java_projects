package co.edu.uniquindio.poo.model;

public class ProductoRefrigerado extends ProductoBase implements Refrigerable{
    private String codigoAprobacion;
    private double temperaturaRefrigeracion;
    private Refrigerador refrigerador;

    
    public ProductoRefrigerado(String codigo, String nombre, double precioCompra, String proveedor,
            PaisOrigen paisOrigen, String codigoAprobacion, double temperaturaRefrigeracion,
            Refrigerador refrigerador) {
        super(codigo, nombre, precioCompra, proveedor, paisOrigen);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRefrigeracion = temperaturaRefrigeracion;
        this.refrigerador = refrigerador;
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

    @Override
    public String iniciarProcesoRefrigeracion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciarProcesoRefrigeracion'");
    }

    public String getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(String codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public double getTemperaturaRefrigeracion() {
        return temperaturaRefrigeracion;
    }

    public void setTemperaturaRefrigeracion(double temperaturaRefrigeracion) {
        this.temperaturaRefrigeracion = temperaturaRefrigeracion;
    }

    public Refrigerador getRefrigerador() {
        return refrigerador;
    }

    public void setRefrigerador(Refrigerador refrigerador) {
        this.refrigerador = refrigerador;
    }
    
    

}
