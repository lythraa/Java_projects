package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;

import static org.junit.jupiter.api.Assertions.*;

public class Grupotest {

    @Test   
    public void testAñadirContactoGrupo() {
        Grupo grupo = new Grupo("Amigos", Categoria.AMIGOS);
        Contacto contacto = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);
        
        grupo.añadirContactoGrupo(contacto);
        assertTrue(grupo.getListaContactosPertenecientes()[0] != null);
        assertEquals(contacto, grupo.getListaContactosPertenecientes()[0]);
    }

    @Test
    public void testEliminarContactoGrupo() {
        Grupo grupo = new Grupo("Amigos", Categoria.AMIGOS);
        Contacto contacto = new Contacto("Juan Pérez", "juanp", "Calle 123", "123456789", "juan@example.com", 30);
        grupo.añadirContactoGrupo(contacto);

        grupo.eliminarContactoGrupo(contacto);
        assertNull(grupo.getListaContactosPertenecientes()[0]);
    }

    @Test
    public void testToString() {
        Grupo grupo = new Grupo("Amigos", Categoria.AMIGOS);
        String expectedString = "Grupo [nombre=Amigos, categoria=AMIGOS, listaContactosPertenecientes=[null, null, null, null, null], getClass()=class co.edu.uniquindio.poo.model.Grupo, getNombre()=Amigos, getCategoria()=AMIGOS, getListaContactosPertenecientes()=[null, null, null, null, null], hashCode()=" + grupo.hashCode() + ", toString()=" + super.toString() + "]";
        assertEquals(expectedString, grupo.toString());
    }
}
