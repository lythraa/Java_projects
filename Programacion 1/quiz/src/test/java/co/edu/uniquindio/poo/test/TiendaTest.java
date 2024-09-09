package co.edu.uniquindio.poo.test;

import co.edu.uniquindio.poo.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    private Tienda tienda;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private Producto producto4;
    private Producto productoRepetido;

    @BeforeEach
    public void setUp() {
        producto1 = new Producto("Leche", 3500, TipoProducto.PERECEDERO);
        producto2 = new Producto("Kellogs", 10000, TipoProducto.NOPERECEDERO);
        producto3 = new Producto("Queso Ranchero", 6000, TipoProducto.REFRIGERADO);
        producto4 = new Producto("Cajita de jugo", 2000, TipoProducto.NOPERECEDERO);
        productoRepetido = new Producto("Leche", 3500, TipoProducto.PERECEDERO);
        
        tienda = new Tienda("Super inter", 3);
    }

    @Test
    public void testAgregarProducto() {
        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);
        
        // verificar productos añadidos
        assertEquals(producto1, tienda.buscarProducto(producto1.getNombre()));
        assertEquals(producto2, tienda.buscarProducto(producto2.getNombre()));
        assertEquals(producto3, tienda.buscarProducto(producto3.getNombre()));
    }

    @Test
    public void testAgregarProductoAlLimite() {
        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);
        
        tienda.agregarProducto(producto4);
        
        // verificar que no se deja añadir mas del maximo
        assertNull(tienda.buscarProducto(producto4.getNombre()));
    }

    @Test
    public void testAgregarProductoRepetido() {
        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);
        
        tienda.agregarProducto(productoRepetido);
        
        // verificar que no se pueden añadir productos repetidos
        assertEquals(producto1, tienda.buscarProducto(productoRepetido.getNombre()));
    }

    @Test
    public void testEliminarProducto() {
        tienda.agregarProducto(producto1);
        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto3);
        
        tienda.eliminarProducto(producto2);
        
        // verificar producto eliminado
        assertNull(tienda.buscarProducto(producto2.getNombre()));
    }

    @Test
    public void testCalcularPrecioVenta() {
        producto1.calcularPrecioVenta();
        producto2.calcularPrecioVenta();
        producto3.calcularPrecioVenta();
        producto4.calcularPrecioVenta();
        
        assertEquals(3500 + 3500 * 0.15, producto1.getPrecioVenta(), 0.01);
        assertEquals(10000 + 10000 * 0.05, producto2.getPrecioVenta(), 0.01);
        assertEquals(6000 + 6000 * 0.10, producto3.getPrecioVenta(), 0.01);
        assertEquals(2000 + 2000 * 0.05, producto4.getPrecioVenta(), 0.01);
    }
}
