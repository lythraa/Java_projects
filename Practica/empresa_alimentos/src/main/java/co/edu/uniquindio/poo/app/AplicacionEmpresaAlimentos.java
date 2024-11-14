package co.edu.uniquindio.poo.app;

import java.time.LocalDate;

import co.edu.uniquindio.poo.model.*;

public class AplicacionEmpresaAlimentos {
    public static void main(String[] args) {
        // Crear una empresa de alimentos
        EmpresaAlimentos empresa = new EmpresaAlimentos("Alimentos S.A.");

        Refrigerador refrigerador1 = new Refrigerador(5, "R001");
        Refrigerador refrigerador2 = new Refrigerador(3, "R002");
        // Crear un par de productos, medicamentos y refrigeradores para probar
        Producto producto1 = new ProductoRefrigerado("P001", "Leche", 1500, "Proveedor A", PaisOrigen.COLOMBIA, "aprobacion1", -10,refrigerador1);
        Producto producto2 = new ProductoPerecedero("P002", "Arroz", 2000, "Proveedor B", PaisOrigen.COLOMBIA, LocalDate.of(2025, 10, 10));

        MedicamentoFarmacologico medicamento1 = new MedicamentoFarmacologico("M001", "Aspirina");
        MedicamentoFarmacologico medicamento2 = new MedicamentoFarmacologico("M002", "Paracetamol");

        

        // Agregar datos a la empresa
        System.out.println(empresa.agregarProducto(producto1));
        System.out.println(empresa.agregarProducto(producto2));
        System.out.println(empresa.agregarMedicamento(medicamento1));
        System.out.println(empresa.agregarMedicamento(medicamento2));
        System.out.println(empresa.agregarRefrigerador(refrigerador1));
        System.out.println(empresa.agregarRefrigerador(refrigerador2));

        // Buscar y mostrar productos
        Producto pBuscado = empresa.buscarProductoPorNombre("Leche");
        if (pBuscado != null) {
            System.out.println("Producto encontrado: " + pBuscado.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }

        // Eliminar un producto
        System.out.println(empresa.eliminarProducto("P001"));

        // Actualizar un medicamento
        MedicamentoFarmacologico medicamentoActualizado = new MedicamentoFarmacologico("M001", "Aspirina");
        System.out.println(empresa.actualizarMedicamento("M001", medicamentoActualizado));

        // Buscar refrigerador
        Refrigerador rBuscado = empresa.obtenerRefrigerador("R001");
        if (rBuscado != null) {
            System.out.println("Refrigerador encontrado con ID: " + rBuscado.getId());
        } else {
            System.out.println("Refrigerador no encontrado.");
        }

        // Actualizar un refrigerador
        Refrigerador rActualizado = new Refrigerador(4, "R001");
        System.out.println(empresa.actualizarRefrigerador("R001", rActualizado));

        // Eliminar refrigerador
        System.out.println(empresa.eliminarRefrigerador("R002"));
    }
}
