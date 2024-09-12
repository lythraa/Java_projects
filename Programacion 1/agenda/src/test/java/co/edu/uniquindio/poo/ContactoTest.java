package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Contacto;

import static org.junit.jupiter.api.Assertions.*;

public class ContactoTest {

    @Test
    public void testGettersAndSetters() {
        Contacto contacto = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);

        assertEquals("Juan Pérez", contacto.getNombres());
        contacto.setNombres("Carlos Pérez");
        assertEquals("Carlos Pérez", contacto.getNombres());

        assertEquals("juanp", contacto.getAlias());
        contacto.setAlias("carlosp");
        assertEquals("carlosp", contacto.getAlias());

        assertEquals("Calle 123", contacto.getDireccion());
        contacto.setDireccion("Calle 456");
        assertEquals("Calle 456", contacto.getDireccion());

        assertEquals("123456789", contacto.getTelefono());
        contacto.setTelefono("987654321");
        assertEquals("987654321", contacto.getTelefono());

        assertEquals("juan@example.com", contacto.getEmail());
        contacto.setEmail("carlos@example.com");
        assertEquals("carlos@example.com", contacto.getEmail());

        assertEquals(30, contacto.getEdad());
        contacto.setEdad(35);
        assertEquals(35, contacto.getEdad());
    }

    @Test
    public void testEqualsAndHashCode() {
        Contacto contacto1 = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);
        Contacto contacto2 = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);

        assertEquals(contacto1, contacto2);
        assertEquals(contacto1.hashCode(), contacto2.hashCode());
    }

    @Test
    public void testToString() {
        Contacto contacto = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);
        String expectedString = "Contacto [nombres=Juan Pérez, alias=juanp, direccion=Calle 123, telefono=123456789, email=juan@example.com]";
        assertEquals(expectedString, contacto.toString());
    }
}
