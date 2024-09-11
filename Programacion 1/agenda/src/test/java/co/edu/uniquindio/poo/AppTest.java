/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import co.edu.uniquindio.poo.model.Agenda;
import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;
import co.edu.uniquindio.poo.model.Categoria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.time.LocalDate;
/**
 * Pruebas unitarias
 */
public class AppTest {

    private Agenda agenda;
    private Contacto contacto1;
    private Contacto contacto2;
    private Grupo grupo1;
    private Reunion reunion1;

    @BeforeEach
    void setUp() {
        agenda = new Agenda(10, 5, 5);
        contacto1 = new Contacto("Juan", "Alias1", "Calle 1", "111111", "juan@mail.com", 20);
        contacto2 = new Contacto("Maria", "Alias2", "Calle 2", "222222", "maria@mail.com", 16);
        grupo1 = new Grupo("Amigos", Categoria.AMIGOS);
        reunion1 = new Reunion("Reunion1", LocalDate.now(), Time.valueOf("10:00:00"), 5);
    }

    @Test
    void testAñadirContacto() {
        agenda.añadirContacto(contacto1);
        assertNotNull(agenda.buscarContacto(contacto1), "El contacto debería ser encontrado en la agenda.");
    }

    @Test
    void testBuscarContacto() {
        agenda.añadirContacto(contacto1);
        Contacto encontrado = agenda.buscarContacto(contacto1);
        assertEquals(contacto1, encontrado, "El contacto buscado debería coincidir con el contacto añadido");
    }

    @Test
    void testEliminarContacto() {
        agenda.añadirContacto(contacto1);
        agenda.eliminarContacto(contacto1);
        assertNull(agenda.buscarContacto(contacto1), "El contacto debería haberse eliminado correctamente");
    }


    @Test
    void testAñadirGrupo() {
        agenda.añadirGrupo(grupo1);
        assertNotNull(agenda.buscarGrupo(grupo1), "El grupo debería haberse añadido correctamente");
    }

    @Test
    void testBuscarGrupo() {
        agenda.añadirGrupo(grupo1);
        Grupo encontrado = agenda.buscarGrupo(grupo1);
        assertEquals(grupo1, encontrado, "El grupo buscado debería coincidir con el grupo añadido");
    }

    @Test
    void testEliminarGrupo() {
        agenda.añadirGrupo(grupo1);
        agenda.eliminarGrupo(grupo1);
        assertNull(agenda.buscarGrupo(grupo1), "El grupo debería haberse eliminado correctamente");
    }


    @Test
    void testAñadirReunion() {
        agenda.añadirReunion(reunion1);
        assertNotNull(agenda.buscarReunion(reunion1), "La reunión debería haberse añadido correctamente");
    }

    @Test
    void testBuscarReunion() {
        agenda.añadirReunion(reunion1);
        Reunion encontrada = agenda.buscarReunion(reunion1);
        assertEquals(reunion1, encontrada, "La reunión buscada debería coincidir con la reunión añadida");
    }

    @Test
    void testEliminarReunion() {
        agenda.añadirReunion(reunion1);
        agenda.eliminarReunion(reunion1);
        assertNull(agenda.buscarReunion(reunion1), "La reunión debería haberse eliminado correctamente");
    }

}