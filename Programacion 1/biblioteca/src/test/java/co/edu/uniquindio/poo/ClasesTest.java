/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Biblioteca;
import co.edu.uniquindio.poo.model.Bibliotecario;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Libro;
import co.edu.uniquindio.poo.model.Prestamo;
import co.edu.uniquindio.poo.model.DetallePrestamo;
import co.edu.uniquindio.poo.model.Usuario;

/**
 * Unit test for simple App.
 */
public class ClasesTest {

    private static final Logger LOG = Logger.getLogger(ClasesTest.class.getName());
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp(){
        biblioteca = new Biblioteca("Biblioteca Central");
    }
    
    //──────────────────────── ≪TEST BIBLIOTECA [3]≫ ────────────────────────//
    @Test
    public void añadirLibroTest() {
        LOG.info("Iniciado test anadirLibroTest");

        Libro libro = new Libro("001", "123", "Autor", "Titulo", "Editorial", LocalDate.now(), 50000, 5);

        //─────────────── ≪test por mensaje≫ ───────────────
        String mensajeActual = biblioteca.añadirLibro(libro);
        String mensajeEsperado = "Libro añadido correctamente"; 
        assertEquals(mensajeEsperado, mensajeActual);

        //─────────────── ≪test revisando en la lista de libros≫ ───────────────
        boolean estaLibro = biblioteca.getListaLibros().get("123").equals(libro);
        assertTrue(estaLibro);

        LOG.info("Finalizando test anadirLibroTest");
    }

    @Test
    public void añadirLibroNulo(){
        LOG.info("Iniciado test anadirLibroNulo");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> biblioteca.añadirLibro(null));

        String mensajeEsperado = "El libro no puede ser nulo";
        String mensajeActual = exception.getMessage();
        
        assertEquals(mensajeEsperado, mensajeActual);
        LOG.info("Finalizando test anadirLibroNulo");
    }

    //──────────────────────── ≪TEST BIBLIOTECARIO [2]≫ ────────────────────────//
    @Test
    public void testSalarioBibliotecario() {
        LOG.info("Iniciado test testSalarioBibliotecario");

        Bibliotecario bibliotecario = new Bibliotecario("Ana", "001", "3120000000", "ana@correo.com", 2000.0, LocalDate.of(2020, 1, 1));
        double salarioEsperado = 2000.0;
        assertEquals(salarioEsperado, bibliotecario.getSalario());

        LOG.info("Finalizando test testSalarioBibliotecario");
    }

    @Test
    public void testAñadirPrestamoBibliotecario() {
        LOG.info("Iniciado test testAñadirPrestamoBibliotecario");

        Bibliotecario bibliotecario = new Bibliotecario("Ana", "001", "3120000000", "ana@correo.com", 2000.0, LocalDate.of(2020, 1, 1));
        Prestamo prestamo = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), "001", new LinkedList<>(), bibliotecario, new Estudiante("Carlos", "002", "3100000000", "carlos@correo.com"));
        bibliotecario.getListaPrestamosDeUnBibliotecario().add(prestamo);
        assertTrue(bibliotecario.getListaPrestamosDeUnBibliotecario().contains(prestamo));

        LOG.info("Finalizando test testAñadirPrestamoBibliotecario");
    }

    //──────────────────────── ≪TEST ESTUDIANTE [2]≫ ────────────────────────//
    @Test
    public void testAñadirPrestamoEstudiante() {
        LOG.info("Iniciado test testAñadirPrestamoEstudiante");

        Estudiante estudiante = new Estudiante("Carlos", "002", "3100000000", "carlos@correo.com");
        Prestamo prestamo = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), "001", new LinkedList<>(), new Bibliotecario("Ana", "001", "3120000000", "ana@correo.com", 2000.0, LocalDate.of(2020, 1, 1)), estudiante);
        estudiante.getListaPrestamosDeUnEstudiante().add(prestamo);
        assertTrue(estudiante.getListaPrestamosDeUnEstudiante().contains(prestamo));

        LOG.info("Finalizando test testAñadirPrestamoEstudiante");
    }

    @Test
    public void testEstudianteSinPrestamos() {
        LOG.info("Iniciado test testEstudianteSinPrestamos");

        Estudiante estudiante = new Estudiante("Carlos", "002", "3100000000", "carlos@correo.com");
        assertEquals(0, estudiante.getListaPrestamosDeUnEstudiante().size());

        LOG.info("Finalizando test testEstudianteSinPrestamos");
    }

    //──────────────────────── ≪TEST LIBRO [2]≫ ────────────────────────//
    @Test
    public void testPrestarLibro() {
        LOG.info("Iniciado test testPrestarLibro");

        Libro libro = new Libro("001", "123456789", "Autor", "Título", "Editorial", LocalDate.now(), 50000, 10);
        boolean prestado = libro.prestarLibro(2);
        assertTrue(prestado);
        assertEquals(8, libro.getUnidadesDisponibles());

        LOG.info("Finalizando test testPrestarLibro");
    }

    @Test
    public void testDevolverLibro() {
        LOG.info("Iniciado test testDevolverLibro");

        Libro libro = new Libro("001", "123456789", "Autor", "Título", "Editorial", LocalDate.now(), 50000, 10);
        libro.prestarLibro(2);
        libro.devolverLibro(2);
        assertEquals(10, libro.getUnidadesDisponibles());

        LOG.info("Finalizando test testDevolverLibro");
    }

    //──────────────────────── ≪TEST PRESTAMO [2]≫ ────────────────────────//
    @Test
    public void testCalcularTotalPrestamo() {
        LOG.info("Iniciado test testCalcularTotalPrestamo");

        Libro libro = new Libro("001", "123456789", "Autor", "Título", "Editorial", LocalDate.now(), 50000, 10);
        DetallePrestamo detalle = new DetallePrestamo(libro, 2);
        LinkedList<DetallePrestamo> listaDetalles = new LinkedList<>();
        listaDetalles.add(detalle);
        Prestamo prestamo = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), "001", listaDetalles, null, null);
        assertEquals(100000, prestamo.getTotal());

        LOG.info("Finalizando test testCalcularTotalPrestamo");
    }

    @Test
    public void testAñadirDetallePrestamo() {
        LOG.info("Iniciado test testAñadirDetallePrestamo");

        Prestamo prestamo = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), "001", new LinkedList<>(), null, null);
        Libro libro = new Libro("001", "123456789", "Autor", "Título", "Editorial", LocalDate.now(), 50000, 10);
        String mensaje = prestamo.crearAñadirDetallePrestamo(libro, 2);
        assertEquals("Detalle del producto añadido correctamente.", mensaje);
        assertEquals(1, prestamo.getListaDetallePrestamos().size());

        LOG.info("Finalizando test testAñadirDetallePrestamo");
    }

    //──────────────────────── ≪TEST DETALLEPRESTAMO [2]≫ ────────────────────────//
    @Test
    public void testCalcularSubtotal() {
        LOG.info("Iniciado test testCalcularSubtotal");

        Libro libro = new Libro("001", "123456789", "Autor", "Título", "Editorial", LocalDate.now(), 50000, 10);
        DetallePrestamo detalle = new DetallePrestamo(libro, 2);
        assertEquals(100000, detalle.getSubTotal());

        LOG.info("Finalizando test testCalcularSubtotal");
    }

    @Test
    public void testSetCantidad() {
        LOG.info("Iniciado test testSetCantidad");

        Libro libro = new Libro("001", "123456789", "Autor", "Título", "Editorial", LocalDate.now(), 50000, 10);
        DetallePrestamo detalle = new DetallePrestamo(libro, 2);
        detalle.setCantidad(3);
        assertEquals(3, detalle.getCantidad());

        LOG.info("Finalizando test testSetCantidad");
    }

    //──────────────────────── ≪TEST USUARIO [2]≫ ────────────────────────//
    @Test
    public void testCrearUsuario() {
        LOG.info("Iniciado test testCrearUsuario");

        Usuario usuario = new Usuario("Pedro", "003", "pedro@correo.com");
        assertEquals("Pedro", usuario.getNombre());
        assertEquals("003", usuario.getId());
        assertEquals("pedro@correo.com", usuario.getCorreo());

        LOG.info("Finalizando test testCrearUsuario");
    }

    @Test
    public void testSetCorreo() {
        LOG.info("Iniciado test testSetCorreo");

        Usuario usuario = new Usuario("Pedro", "003", "pedro@correo.com");
        usuario.setCorreo("nuevo@correo.com");
        assertEquals("nuevo@correo.com", usuario.getCorreo());

        LOG.info("Finalizando test testSetCorreo");
    }
}
