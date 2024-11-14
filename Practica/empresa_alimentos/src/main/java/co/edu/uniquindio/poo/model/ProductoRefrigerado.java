package co.edu.uniquindio.poo.model;

public class ProductoRefrigerado extends Producto implements RefrigerableInterface{
    private String codigoAprobacion;
    private double temperaturaRefrigeracion;
    private Refrigerador refrigerador;
    private EstadoRefrigeracion estadoRefrigeracionActual;

    public ProductoRefrigerado(String codigo, String nombre, double precioCompra, String proveedor,
            PaisOrigen paisOrigen, String codigoAprobacion, double temperaturaRefrigeracion, Refrigerador refrigerador) {
        super(codigo, nombre, precioCompra, proveedor, paisOrigen);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRefrigeracion = temperaturaRefrigeracion;
        this.refrigerador = refrigerador;
        this.estadoRefrigeracionActual = EstadoRefrigeracion.DESCONOCIDO;
    }

    //Los productos refrigerados se venden con una utilidad de $ 500,oo sobre cada grado de temperatura de refrigeración
    @Override
    public double calcularPrecioVenta() {
        return temperaturaRefrigeracion * 500;
    }

    //para productos refrigerados, el impuesto es del 5%
    @Override
    public double calcularImpuesto() {
        double precioVenta = calcularPrecioVenta();
        return precioVenta * 0.05;
    }

    @Override
    public String iniciarProcesoRefrigeracion() {
        String mensaje;
        if (temperaturaRefrigeracion == refrigerador.getTemperatura()) {
            refrigerador.agregarProducto(this);
            estadoRefrigeracionActual = EstadoRefrigeracion.REFRIGERADO;
            mensaje = getNombre() + " ha sido refrigerado exitosamente a " + temperaturaRefrigeracion
                    + " grados en el refrigerador con ID: " + refrigerador.getId();
        } else {
            estadoRefrigeracionActual = EstadoRefrigeracion.NO_REFRIGERADO;
            mensaje = "La temperatura del refrigerador no es la adecuada para el producto. " +
                      "Cambie el refrigerador o ajuste la temperatura del refrigerador.";
        }
        return mensaje;
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

    public EstadoRefrigeracion getEstadoRefrigeracion() {
        return estadoRefrigeracionActual;
    }

    public void setEstadoRefrigeracion(EstadoRefrigeracion estadoRefrigeracion) {
        this.estadoRefrigeracionActual = estadoRefrigeracion;
    }
    
    

}
