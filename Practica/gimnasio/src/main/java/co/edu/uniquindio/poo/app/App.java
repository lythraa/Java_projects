package co.edu.uniquindio.poo.app;

import javax.swing.JOptionPane;
import co.edu.uniquindio.poo.model.Entrenador;
import co.edu.uniquindio.poo.model.Miembro;
import co.edu.uniquindio.poo.model.Membresia;


public class App {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del entrenador");

        // Crear una instancia de Entrenador. Aquí debes usar el constructor adecuado
        // Asegúrate de proporcionar los valores adecuados para todos los parámetros
        Entrenador entrenador1 = new Entrenador(nombre, "Especialidad", "Telefono", "Correo", new Miembro[10], 10);

        // Mostrar el entrenador usando toString
        System.out.println(entrenador1);
        
        // Obtener datos del nuevo miembro
        String nombreMiembro = JOptionPane.showInputDialog(null, "Ingrese el nombre del miembro");
        String edadMiembro = JOptionPane.showInputDialog(null, "Ingrese la edad del miembro");
        String generoMiembro = JOptionPane.showInputDialog(null, "Ingrese el género del miembro");
        String cedulaMiembro = JOptionPane.showInputDialog(null, "Ingrese la cédula del miembro");
        String membresiaMiembroString = JOptionPane.showInputDialog(null, "Ingrese la membresía del miembro: (MENSUAL,TRIMESTRAL, ANUAL)");
        Membresia membresiaMiembro = Membresia.valueOf(membresiaMiembroString.toUpperCase()); // Convierte la cadena en un enum
    
        // Crear una instancia de Miembro
        Miembro nuevoMiembro = new Miembro(nombreMiembro, edadMiembro, generoMiembro, cedulaMiembro, membresiaMiembro);

        // Añadir el nuevo miembro al entrenador
        entrenador1.asignarMiembroEntrenador(nuevoMiembro);

        // Mostrar el entrenador con el nuevo miembro añadido
        System.out.println(entrenador1);

        // No se necesita cerrar el Scanner en este caso ya que no lo estamos utilizando
    }
}