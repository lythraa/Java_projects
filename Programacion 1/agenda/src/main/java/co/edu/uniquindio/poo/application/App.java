package co.edu.uniquindio.poo.application;
import java.util.Arrays;
import co.edu.uniquindio.poo.model.Agenda;
import co.edu.uniquindio.poo.model.Contacto;

public class App {
    public static void main(String[] args) {
        Contacto contacto1=new Contacto("jenna", "jenna","direcccion","1","f@dc", 10);
        Contacto contacto2=new Contacto("juliana", "juli","direcccion","2","f@dc", 20);
        Contacto contacto3=new Contacto("jas", "jas","direcccion","3","f@dc", 10);

        Agenda agenda = new Agenda(5, 0, 0);
        agenda.añadirContacto(contacto1);
        agenda.añadirContacto(contacto2);
        agenda.añadirContacto(contacto3);
        System.out.println(Arrays.toString(agenda.getListaContactos()));

        //agenda.imprimirContactosImpares();
        /* 
        System.out.println(agenda.conteoXEdad(1));

        int moda = agenda.edadModa();
        System.out.println("la edad que mas se repite es" + moda);

        agenda.eliminarContactos3Vocales_2();
        System.out.println(Arrays.toString(agenda.getListaContactos()));
        
        Grupo grupo_a=new Grupo("amigos", null);
        grupo_a.añadirContactoGrupo(contacto1);
        grupo_a.añadirContactoGrupo(contacto2);
        grupo_a.añadirContactoGrupo(contacto3);
        System.err.println(Arrays.toString(grupo_a.getListaContactosPertenecientes()));
        Grupo grupo_b=new Grupo("colegio", null);
        grupo_b.añadirContactoGrupo(contacto1);
        System.err.println(Arrays.toString(grupo_b.getListaContactosPertenecientes()));
        
        agenda.añadirGrupo(grupo_a);
        agenda.añadirGrupo(grupo_b);
        System.out.println("el grupo con mas contactos es: " +agenda.grupoMayorCantidadContactos());
        System.out.println("Lista de grupos después de añadir: " + Arrays.toString(agenda.getListaGrupos()));
        */

        
        System.err.println("promedio de las edades totales"+agenda.promedioEdadesContactos());


    }



}


