package co.edu.uniquindio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.EmpresaAlimentos;
import co.edu.uniquindio.poo.model.PaisOrigen;
import co.edu.uniquindio.poo.model.Producto;
import co.edu.uniquindio.poo.model.ProductoPerecedero;

public class test {
    private EmpresaAlimentos empresaAlimentos;

    @BeforeEach
    public void setUp(){
        empresaAlimentos =new EmpresaAlimentos("Superinter");
    }
    
    @Test
    public void agregarProducto(){
        Producto arroz = new ProductoPerecedero("P#123", "Arroz", 2000, "proveedor1", PaisOrigen.COLOMBIA, LocalDate.of(2025, 10, 10));
        empresaAlimentos.agregarProducto(arroz);
        assertEquals(empresaAlimentos.buscarProductoPorCodigo("P#123"), arroz);
    }
}
