package co.edu.uniquindio.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Agenda;
import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.time.LocalDate;

public class AgendaTest {

    private Agenda agenda;
    private Contacto contacto1;
    private Contacto contacto2;
    private Contacto contacto3;
    private Grupo grupo1;
    private Reunion reunion1;

    @BeforeEach
    public void setUp() {
        agenda = new Agenda(5,5,5);
        contacto1 = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);
        contacto2 = new Contacto("Ana Gómez", "anag", "Calle 456", "987654321", "ana@example.com", 25);
        contacto3 = new Contacto("Luis Martínez", "luism", "Calle 789", "555555555", "luis@example.com", 35);
        grupo1 = new Grupo("Amigos", Categoria.AMIGOS);
        reunion1 = new Reunion("Reunión de equipo", LocalDate.of(2024, 9, 30), Time.valueOf("10:00:00"), 2);
    }

    @Test
    public void testPromedioEdadesContactos() {
        agenda.añadirContacto(contacto1);
        agenda.añadirContacto(contacto2);
        agenda.añadirContacto(contacto3);
        
        double expectedPromedio = (30 + 25 + 35) / 3.0;
        assertEquals(expectedPromedio, agenda.promedioEdadesContactos(), 0.01);
    }

    @Test
    public void testPromedioEdadesContactosSinContactos() {
        assertEquals(0.0, agenda.promedioEdadesContactos());
    }

    @Test
    public void testAgregarContacto() {
        agenda.añadirContacto(contacto1);
        assertEquals(contacto1, agenda.buscarContacto(contacto1));
    }

    @Test
    public void testEliminarContacto() {
        agenda.añadirContacto(contacto1);
        agenda.eliminarContacto(contacto1);
        assertNull(agenda.buscarContacto(contacto1));
    }

    @Test
    public void testBuscarContacto() {
        agenda.añadirContacto(contacto1);
        assertEquals(contacto1, agenda.buscarContacto(contacto1));
    }

    @Test
    public void testAgregarGrupo() {
        agenda.añadirGrupo(grupo1);
        assertEquals(grupo1, agenda.buscarGrupo(grupo1));
    }

    @Test
    public void testEliminarGrupo() {
        agenda.añadirGrupo(grupo1);
        agenda.eliminarGrupo(grupo1);
        assertNull(agenda.buscarGrupo(grupo1));
    }

    @Test
    public void testAgregarReunion() {
        agenda.añadirReunion(reunion1);
        assertEquals(reunion1, agenda.buscarReunion(reunion1));
    }

    @Test
    public void testEliminarReunion() {
        agenda.añadirReunion(reunion1);
        agenda.eliminarReunion(reunion1);
        assertNull(agenda.buscarReunion(reunion1));
    }
}
