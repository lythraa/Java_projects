package co.edu.uniquindio.poo.model;

public class MedicamentoFarmacologico implements RefrigerableInterface{
    private String codigo;
    private String nombre;
    private EstadoRefrigeracion estadoRefrigeracionActual;

    public MedicamentoFarmacologico(String codigo, String nombre){
        this.codigo=codigo;
        this.nombre=nombre;
        this.estadoRefrigeracionActual=EstadoRefrigeracion.DESCONOCIDO;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String iniciarProcesoRefrigeracion() {
        estadoRefrigeracionActual= EstadoRefrigeracion.REFRIGERADO;
        return "Se ha iniciado el proceso de refrigeracion para el medicamento"+ nombre;
        
    }

    public EstadoRefrigeracion getEstadoRefrigeracionActual() {
        return estadoRefrigeracionActual;
    }

    public void setEstadoRefrigeracionActual(EstadoRefrigeracion estadoRefrigeracionActual) {
        this.estadoRefrigeracionActual = estadoRefrigeracionActual;
    }

    
}
