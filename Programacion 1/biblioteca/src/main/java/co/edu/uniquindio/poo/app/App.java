package co.edu.uniquindio.poo.app;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Biblioteca;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        String nombreBiblioteca = JOptionPane.showInputDialog(null, "por favor ingrese el nombre de la biblioteca");
        Biblioteca mibi = new Biblioteca(nombreBiblioteca);
        JOptionPane.showMessageDialog(null,mibi);

    }
}
