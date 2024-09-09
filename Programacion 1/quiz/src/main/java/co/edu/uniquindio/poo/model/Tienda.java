package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Tienda {
    private String nombre;
    private Producto[] listaProductos;
    private int cantidadProductos;

    public Tienda (String nombre, int tamañoMaximo){
        this.nombre=nombre;
        this.listaProductos=new Producto[tamañoMaximo];
        this.cantidadProductos=0;
    }


    /** solo sirve en caso de nunca eliminar algun objeto
     * public void agregarProducto(Producto producto){
        if (cantidadProductos<listaProductos.length) {
            listaProductos[cantidadProductos]=producto;
            cantidadProductos++;
            System.out.println("El siguiente producto ha sido agregado: "+ producto.getNombre());
        } else{
            System.out.println("No hay espacio para mas productos en la tienda.");
        }
    }*/


    public int posDisponibleProducto (Producto[] listaProductos){
        int posDisponible = -1;
        for (int i = 0; i < listaProductos.length; i++) {
            if (listaProductos[i] == null){
                posDisponible =i;
                break;
            }
        }
        return posDisponible;
    }


    public Producto buscarProducto(String string){
        Producto productoEncontrado = null;
        for (Producto productoaux : listaProductos){
            if (productoaux != null && productoaux.getNombre().equals(string)){
                productoEncontrado = productoaux;
            }
        }
        return productoEncontrado;
    }

    public void agregarProducto(Producto producto){
        if (buscarProducto(producto.getNombre()) == null) {
            int i = posDisponibleProducto(listaProductos);
            if (i >= 0) {
                listaProductos[i] = producto;
                cantidadProductos++;
                System.out.println("Producto añadido: " + producto.getNombre());
            } else {
                System.out.println("No hay espacio disponible para añadir el producto");
            }
        } else {
            System.out.println("El producto ya existe en la tienda.");
        }
    }
    
    public void eliminarProducto(Producto producto){
        String mensaje = "No se pudo eliminar el producto por que no se encontró registrado";
        for (int i = 0; i < listaProductos.length; i++) {
            if (listaProductos[i] != null && listaProductos[i].equals(producto)){
                listaProductos[i]=null;
                cantidadProductos--;
                mensaje="Producto eliminado exitosamente";
                break;
            }
        }
        System.out.println(mensaje);
    }


    public String obtenerListaProductos() {
        String resultado = "Productos en la tienda " + nombre + ":\n";
        for (Producto producto : listaProductos) {
            if (producto != null) {
                resultado += producto.toString() + "\n";
            }
        }
        return resultado;
    }
    


    @Override
    public String toString() {
        return "Tienda [nombre=" + nombre + ", listaProductos=" + Arrays.toString(listaProductos)
                + ", cantidadProductos=" + cantidadProductos + "]";
    }

    

}
