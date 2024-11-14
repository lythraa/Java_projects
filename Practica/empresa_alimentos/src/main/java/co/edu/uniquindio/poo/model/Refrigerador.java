package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Refrigerador {
    private double temperatura;
    private String id;
    private Collection<Producto> productosRefrigerador;
    private Collection<MedicamentoFarmacologico> medicamentos;

    public Refrigerador(double temperatura, String id) {
        this.temperatura = temperatura;
        this.id = id;
        productosRefrigerador = new LinkedList<>();
        medicamentos = new LinkedList<>();
    }

    public void agregarProducto(Producto producto){
        productosRefrigerador.add(producto);
    }
    //aun sin excepcion para cuando el producto no existe!!
    public void quitarProducto(ProductoInterface producto){
        productosRefrigerador.remove(producto);
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Collection<Producto> getProductosRefrigerador() {
        return productosRefrigerador;
    }

    public void setProductosRefrigerador(Collection<Producto> productosRefrigerador) {
        this.productosRefrigerador = productosRefrigerador;
    }

    public Collection<MedicamentoFarmacologico> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Collection<MedicamentoFarmacologico> medicamentos) {
        this.medicamentos = medicamentos;
    }

}
