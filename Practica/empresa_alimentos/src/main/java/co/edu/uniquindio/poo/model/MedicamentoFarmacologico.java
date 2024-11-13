package co.edu.uniquindio.poo.model;

public class MedicamentoFarmacologico implements Refrigerable{
    private String codigo;
    private String nombre;

    public MedicamentoFarmacologico(String codigo, String nombre){
        this.codigo=codigo;
        this.nombre=nombre;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciarProcesoRefrigeracion'");
    }

    
}
