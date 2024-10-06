/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.Libro;

/**
 * Unit test for simple App.
 */
public class ClasesTest {

    private static final Logger LOG = Logger.getLogger(ClasesTest.class.getName());
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp(){
        biblioteca = new Biblioteca("biblioteca");
    }
    
    //──────────────────────── ≪TEST BIBLIOTECA []≫ ────────────────────────//
    @Test
    public void añadirLibroTest() {
        LOG.info("Iniciado test anadirLibroTest");

        Libro libro = new Libro(null, "123", null, null, null, null, 0);

        //─────────────── ≪test por mensaje≫ ───────────────
        String mensajeActual = biblioteca.añadirLibro(libro);
        String mensajeEsperado ="Libro añadido correctamente"; 
        assertEquals(mensajeEsperado, mensajeActual);

        //─────────────── ≪test revisando en la lista de mensajes≫ ───────────────
        boolean estaLibro = biblioteca.getListaLibros().get("123").equals(libro);// asi busca en la lista el libro por la llave del map
        assertTrue(estaLibro);

        LOG.info("Finalizando test anadirLibroTest");
    }

    @Test
    public void añadirLibroNulo(){
        LOG.info("Iniciado test anadirLibroNulo");

        Exception   exception = assertThrows(IllegalArgumentException.class, ()-> biblioteca.añadirLibro(null));
                                                //"Voy a intentar hacer algo mal a propósito y quiero asegurarme 
                                                    //     de que el programa reacciona correctamente lanzando un error."

        String mensajeEsperado = "El libro no puede ser nulo";
        String mensajeActual = exception.getMessage();
        
        assertEquals(mensajeEsperado, mensajeActual);
        LOG.info("Finalizando test anadirLibroNulo");


    }
    


    //──────────────────────── ≪TEST BIBLIOTECARIO []≫ ────────────────────────//

    //──────────────────────── ≪TEST ESTUDIANTE []≫ ────────────────────────//

    //──────────────────────── ≪TEST LIBRO []≫ ────────────────────────//

    //──────────────────────── ≪TEST PRESTAMO []≫ ────────────────────────//

    //──────────────────────── ≪TEST DESTALLEPRESTAMO []≫ ────────────────────────//

    //──────────────────────── ≪TEST USUARIO []≫ ────────────────────────//
}
