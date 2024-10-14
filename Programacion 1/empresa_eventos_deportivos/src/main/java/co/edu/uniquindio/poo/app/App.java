package co.edu.uniquindio.poo.app;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.edu.uniquindio.poo.model.Atleta;
import co.edu.uniquindio.poo.model.EmpresaEventosDeportivos;
import co.edu.uniquindio.poo.model.Entrenador;
import co.edu.uniquindio.poo.model.EventoDeportivo;
import co.edu.uniquindio.poo.model.TipoEvento;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        EmpresaEventosDeportivos olympicenterprise = new EmpresaEventosDeportivos("supergym");
        Atleta bolt = new Atleta("bolt", "henao", LocalDate.of(1994, 10, 4), "Armenio", 3);
        Entrenador ector = new Entrenador("ector", "castilla", LocalDate.of(1980, 9, 18), "canadience", "corredor");
        olympicenterprise.agregarPersona(bolt);
        olympicenterprise.agregarPersona(ector);
        System.out.println(olympicenterprise.getListaPersonas());
        EventoDeportivo competicion1 = new EventoDeportivo("copa1", LocalDateTime.of(2015, 10, 12, 15, 30),
         "carrera", "canada", "no se", null, null, TipoEvento.COMPETICION);//ARREGLAR LAS LISTAS
        
    }
}
