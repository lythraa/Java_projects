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

     // 1. Test para imprimir contactos en posiciones impares
     @Test
     void testImprimirImpares() {
         agenda.añadirContacto(contacto1);
         agenda.añadirContacto(contacto2);
         agenda.imprimirImpares();
         // Validación visual o uso de captura de consola.
     }
 
     // 2. Test para calcular la moda de las edades de los contactos
     @Test
     void testModaEdad() {
         agenda.añadirContacto(contacto1);  // edad 20
         agenda.añadirContacto(contacto2);  // edad 16
         int moda = agenda.modaEdad();
         assertEquals(20, moda);
     }
 
     // 3. Test para eliminar contactos con más de 3 vocales
     @Test
     void testEliminarTresVocales() {
         Contacto contacto3 = new Contacto("Alberto", "Alias3", "Calle 3", "333333", "alberto@mail.com", 30);
         agenda.añadirContacto(contacto1);  // Juan, no se elimina
         agenda.añadirContacto(contacto3);  // Alberto, se elimina
         agenda.eliminarTresVocales();
         assertNull(agenda.buscarContacto(contacto3), "El contacto con 3 vocales en el nombre debería haberse eliminado");
     }
 
     // 4. Test para obtener el grupo más grande
     @Test
     void testObtenerGrupoGrande() {
         grupo1.añadirContactoGrupo(contacto1);
         grupo1.añadirContactoGrupo(contacto2);
         Grupo grupo2 = new Grupo("Trabajo", Categoria.OFICINA);
         agenda.añadirGrupo(grupo1);
         agenda.añadirGrupo(grupo2);
         Grupo mayorGrupo = agenda.obtenerGrupoGrande();
         assertEquals(grupo1, mayorGrupo, "El grupo con más contactos debería ser 'Amigos'");
     }
 
     // 5. Test para el promedio de edades
     @Test
     void testPromedioEdades() {
         agenda.añadirContacto(contacto1);  // edad 20
         agenda.añadirContacto(contacto2);  // edad 16
         double promedio = agenda.pormedioEdades();
         assertEquals(18.0, promedio, 0.01, "El promedio de las edades debería ser 18");
     }
 
     // 6. Test para obtener matriz de reuniones
 
     // 7. Test para obtener contactos menores de 18 años
     @Test
     void testContactosMayores18() {
         agenda.añadirContacto(contacto1);  // edad 20
         agenda.añadirContacto(contacto2);  // edad 16
         Contacto[] menoresDe18 = agenda.contactosMayores18();
         assertEquals(1, menoresDe18.length, "Debería haber 1 contacto menor de 18 años");
     }
 
     // 8. Test para calcular la desviación estándar de las edades
     @Test
     void testCalcularDesviacionEstandar() {
         agenda.añadirContacto(contacto1);  // edad 20
         agenda.añadirContacto(contacto2);  // edad 16
         double desviacion = agenda.calcularDesviacionEstandar();
         assertEquals(2.0, desviacion, 0.01, "La desviación estándar debería ser 2");
     }
 
     // 9. Test para imprimir contactos en orden inverso
     @Test
     void testImprimirContactosReversa() {
         agenda.añadirContacto(contacto1);
         agenda.añadirContacto(contacto2);
         agenda.imprimirContactosReversa();
         // Validación visual o uso de captura de consola.
     }
 
     // 10. Test para generar edad aleatoria entre 15 y 60
     @Test
     void testEdadAleatoria1560() {
         int edadAleatoria = agenda.edadAleatoria1560();
         assertTrue(edadAleatoria >= 15 && edadAleatoria <= 60, "La edad aleatoria debería estar entre 15 y 60");
     }
 

     // 13. Test para ordenar contactos por edad usando burbuja
     @Test
     void testOrdenarMenorAMayorEdad() {
         agenda.añadirContacto(contacto1);  // edad 20
         agenda.añadirContacto(contacto2);  // edad 16
         agenda.ordenarMenorAMayorEdad();
         Contacto[] contactos = agenda.getListaContactos();
         assertEquals(contacto2, contactos[0], "El contacto más joven debería estar primero");
         assertEquals(contacto1, contactos[1], "El contacto mayor debería estar segundo");
     }
 }



