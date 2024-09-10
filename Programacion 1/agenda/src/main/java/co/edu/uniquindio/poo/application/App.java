package co.edu.uniquindio.poo.application;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import co.edu.uniquindio.poo.model.Agenda;
import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;

public class App {
    public static void main(String[] args) {
     
        //crear agenda
        JOptionPane.showMessageDialog(null, "Bienvenido, Comenzemos creando la agenda");
        String capacidadesDisponibles[] = {"1", "2", "3", "4","5", "6", "7", "8", "9", "10"};

        String numeroContactos= (String) JOptionPane.showInputDialog(null, "Seleccione una capacidad", "Numero de contactos maximo", JOptionPane.PLAIN_MESSAGE, null, capacidadesDisponibles, capacidadesDisponibles[0]);
        String numeroGrupos= (String) JOptionPane.showInputDialog(null, "Seleccione una capacidad", "Numero maximo de grupos", JOptionPane.PLAIN_MESSAGE, null, capacidadesDisponibles, capacidadesDisponibles[0]);;
        String numeroReuniones=(String) JOptionPane.showInputDialog(null, "Seleccione una capacidad", "Numero maximo de reuniones", JOptionPane.PLAIN_MESSAGE, null, capacidadesDisponibles, capacidadesDisponibles[0]);;

        
        Agenda agenda = new Agenda( Integer.parseInt(numeroContactos), Integer.parseInt(numeroGrupos), Integer.parseInt(numeroReuniones));    
        
        
        //Iniciar menu

        agenda.menuPrincipal();
        

    }



}


