/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Camion;
import co.edu.uniquindio.poo.model.Canasta;

public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());


    @Test
    public void agregarCanastaTest() {
        LOG.info("Iniciado test agregarCanastaTest");

        Camion camion = new Camion("ADJ 89JH");
        camion.cargarCamion();
        Canasta canasta = new Canasta("c234", 100, "Frutas");
        boolean resultado = camion.agregarCanasta(canasta);
        assertTrue(resultado);
        LOG.info("Finalizando test agregarCanastaTest");
    }

    @Test
    public void crearCanasta() {
        LOG.info("Iniciado test crearCanastaTest");

        Canasta canasta = new Canasta("c234", 100, "Frutas");
        assertEquals("c234", canasta.getCodigo());
        LOG.info("Finalizando test crearCanastaTest");
    }

    @Test
    public void agregarListaCanastaTest() {
        LOG.info("Iniciado test agregarListaCanastaTest");


        Camion camion = new Camion("ADJ 89JH");
        Canasta canasta = new Canasta("c234", 100, "Frutas");
        camion.agregarCanasta(canasta);
        assertEquals(1 , camion.getListaCanastas().size());


        LOG.info("Finalizando test agregarListaCanastaTest");
    }

    @Test
    public void agregarCamionListaCanastaTest() {
        LOG.info("Iniciado test agregarCamionListaCanastaTest");
        

        Camion camion = new Camion("ADJ 89JH");
        camion.cargarCamion();
        assertEquals(10 , camion.getListaCanastas().size());


        LOG.info("Finalizando test agregarCamionListaCanastaTest");
    }

    @Test
    public void canastasPesoMayor100Test() {
        LOG.info("Iniciado test canastasPesoMayor100Test");
        

        Camion camion = new Camion("ADJ 89JH");
        Canasta canasta = new Canasta("c234", 130, "Frutas");
        Canasta canasta1 = new Canasta("c235", 100, "Frutas");
        Canasta canasta2 = new Canasta("c236", 140, "Frutas");

        camion.agregarCanasta(canasta2);
        camion.agregarCanasta(canasta);
        camion.agregarCanasta(canasta1);

        LinkedList<Canasta> canastaTest = new LinkedList<>();

        canastaTest.add(canasta2);
        canastaTest.add(canasta);

        assertIterableEquals(camion.canastasPesoMayor100(), canastaTest);


        LOG.info("Finalizando test canastasPesoMayor100Test");
    }

}
