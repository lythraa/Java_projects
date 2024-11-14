package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class EmpresaAlimentos {
    private String nombre;
    private Collection<Producto> productos;
    private Collection<MedicamentoFarmacologico> medicamentos;
    private Collection<Refrigerador> refrigeradores;

    public EmpresaAlimentos(String nombre) {
        this.nombre = nombre;
        this.productos = new LinkedList<>();
        this.medicamentos = new LinkedList<>();
        this.refrigeradores = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //======================= CRUD para productos =======================

    public String agregarProducto(Producto producto) {
        productos.add(producto);
        return "Producto '" + producto.getNombre() + "' agregado exitosamente.";
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public String actualizarProducto(String codigo, Producto productoActualizado) {
        Producto producto = buscarProductoPorCodigo(codigo);
        if (producto != null) {
            productos.remove(producto);
            productos.add(productoActualizado);
            return "Producto con código '" + codigo + "' actualizado exitosamente.";
        }
        return "Producto con código '" + codigo + "' no encontrado.";
    }

    public String eliminarProducto(String codigo) {
        Producto producto = buscarProductoPorCodigo(codigo);
        if (producto != null) {
            productos.remove(producto);
            return "Producto con código '" + codigo + "' eliminado exitosamente.";
        }
        return "Producto con código '" + codigo + "' no encontrado.";
    }

    //======================= CRUD para medicamentos =======================

    public String agregarMedicamento(MedicamentoFarmacologico medicamento) {
        medicamentos.add(medicamento);
        return "Medicamento '" + medicamento.getNombre() + "' agregado exitosamente.";
    }

    public MedicamentoFarmacologico buscarMedicamentoPorCodigo(String codigo) {
        for (MedicamentoFarmacologico medicamento : medicamentos) {
            if (medicamento.getCodigo().equals(codigo)) {
                return medicamento;
            }
        }
        return null;
    }

    public String actualizarMedicamento(String codigo, MedicamentoFarmacologico medicamentoActualizado) {
        MedicamentoFarmacologico medicamento = buscarMedicamentoPorCodigo(codigo);
        if (medicamento != null) {
            medicamentos.remove(medicamento);
            medicamentos.add(medicamentoActualizado);
            return "Medicamento con código '" + codigo + "' actualizado exitosamente.";
        }
        return "Medicamento con código '" + codigo + "' no encontrado.";
    }

    public String eliminarMedicamento(String codigo) {
        MedicamentoFarmacologico medicamento = buscarMedicamentoPorCodigo(codigo);
        if (medicamento != null) {
            medicamentos.remove(medicamento);
            return "Medicamento con código '" + codigo + "' eliminado exitosamente.";
        }
        return "Medicamento con código '" + codigo + "' no encontrado.";
    }

    //======================= CRUD para refrigeradores =======================

    public String agregarRefrigerador(Refrigerador refrigerador) {
        refrigeradores.add(refrigerador);
        return "Refrigerador con ID '" + refrigerador.getId() + "' agregado exitosamente.";
    }

    public Refrigerador obtenerRefrigerador(String id) {
        for (Refrigerador refrigerador : refrigeradores) {
            if (refrigerador.getId().equals(id)) {
                return refrigerador;
            }
        }
        return null;
    }

    public String actualizarRefrigerador(String id, Refrigerador refrigeradorActualizado) {
        Refrigerador refrigerador = obtenerRefrigerador(id);
        if (refrigerador != null) {
            refrigeradores.remove(refrigerador);
            refrigeradores.add(refrigeradorActualizado);
            return "Refrigerador con ID '" + id + "' actualizado exitosamente.";
        }
        return "Refrigerador con ID '" + id + "' no encontrado.";
    }

    public String eliminarRefrigerador(String id) {
        Refrigerador refrigerador = obtenerRefrigerador(id);
        if (refrigerador != null) {
            refrigeradores.remove(refrigerador);
            return "Refrigerador con ID '" + id + "' eliminado exitosamente.";
        }
        return "Refrigerador con ID '" + id + "' no encontrado.";
    }

    //======================= getters and setters =======================

    public Collection<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Collection<Producto> productos) {
        this.productos = productos;
    }

    public Collection<MedicamentoFarmacologico> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Collection<MedicamentoFarmacologico> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Collection<Refrigerador> getRefrigeradores() {
        return refrigeradores;
    }

    public void setRefrigeradores(Collection<Refrigerador> refrigeradores) {
        this.refrigeradores = refrigeradores;
    }
}
