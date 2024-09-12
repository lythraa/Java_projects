package co.edu.uniquindio.poo;

import java.sql.Time;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Reunion;

import static org.junit.jupiter.api.Assertions.*;

public class ReunionTest {

    @Test
    public void testAgregarContactoAsistente() {
        Reunion reunion = new Reunion("Reunión de equipo", LocalDate.of(2024, 9, 30), Time.valueOf("10:00:00"), 2);
        Contacto contacto = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);
        
        reunion.agregarContactoAsistente(contacto);
        assertEquals(contacto, reunion.getListaContactosAsistentes()[0]);
    }

    @Test
    public void testEliminarContactoAsistente() {
        Reunion reunion = new Reunion("Reunión de equipo", LocalDate.of(2024, 9, 30), Time.valueOf("10:00:00"), 2);
        Contacto contacto = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);
        reunion.agregarContactoAsistente(contacto);

        reunion.eliminarContactoAsistente(contacto);
        assertNull(reunion.getListaContactosAsistentes()[0]);
    }

    @Test
    public void testToString() {
        Reunion reunion = new Reunion("Reunión de equipo", LocalDate.of(2024, 9, 30), Time.valueOf("10:00:00"), 2);
        String expectedString = "Reunion [descripcion=Reunión de equipo, fecha=2024-09-30, hora=10:00:00, listaContactosAsistentes=[null, null], getClass()=class co.edu.uniquindio.poo.model.Reunion, getDescripcion()=Reunión de equipo, getFecha()=2024-09-30, getHora()=10:00:00, hashCode()=" + reunion.hashCode() + ", getListaContactosAsistentes()=[null, null], toString()=" + super.toString() + "]";
        assertEquals(expectedString, reunion.toString());
    }
}
