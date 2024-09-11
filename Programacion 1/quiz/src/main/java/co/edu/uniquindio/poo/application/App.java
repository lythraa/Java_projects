package co.edu.uniquindio.poo.application;

import javax.swing.JOptionPane;
import co.edu.uniquindio.poo.model.*;

public class App {
    public static void main(String[] args) {
        Tienda tienda = new Tienda("Tienda de la Abuela Ines", 3);

        while (true) {//mantiene la aplicación en ejecución para permitir al usuario realizar múltiples acciones
            // Muestra un cuadro de diálogo con opciones y obtiene la selección del usuario
            int opcion = JOptionPane.showOptionDialog(null,
                "¿Qué desea hacer?", // Mensaje que se muestra en el cuadro de diálogo
                "Menú", // Título del cuadro de diálogo
                JOptionPane.YES_NO_CANCEL_OPTION, // Opciones disponibles (sí, no, cancelar)
                JOptionPane.QUESTION_MESSAGE, // Icono del cuadro de diálogo (pregunta)
                null, // No se usa un ícono personalizado
                new Object[] {"Agregar Producto", "Mostrar Productos", "Salir"}, // Opciones en el cuadro de diálogo
                "Agregar Producto"); // Opción predeterminada

            switch (opcion) {
                case 0: // Si el usuario selecciona "Agregar Producto"
                    // Solicita datos al usuario para crear un nuevo producto
                    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
                    double precioCompra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio de compra:"));
                    String tipoStr = JOptionPane.showInputDialog("Ingrese el tipo de producto (PERECEDERO, REFRIGERADO, NOPERECEDERO):");
                    TipoProducto tipo = TipoProducto.valueOf(tipoStr.toUpperCase()); // Convierte la cadena en un enum

                    // Crea un nuevo producto con los datos proporcionados
                    Producto producto = new Producto(nombre, precioCompra, tipo);
                    // Agrega el producto a la tienda
                    tienda.agregarProducto(producto);
                    // Muestra un mensaje confirmando que el producto ha sido agregado
                    JOptionPane.showMessageDialog(null, "Producto agregado: " + producto);
                    break;

                case 1: // Si el usuario selecciona "Mostrar Productos"
                    // Obtiene la lista de productos de la tienda
                    String listaProductos = tienda.obtenerListaProductos();
                    // Muestra la lista de productos en un cuadro de diálogo
                    JOptionPane.showMessageDialog(null, listaProductos);
                    break;

                case 2: // Si el usuario selecciona "Salir"
                    // Termina la ejecución de la aplicación
                    System.exit(0);
                    break;

                default:
                JOptionPane.showMessageDialog(null, "la mala");
                break;
            }
        }
    }
}

