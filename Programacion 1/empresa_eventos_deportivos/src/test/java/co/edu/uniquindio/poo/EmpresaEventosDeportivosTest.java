package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import co.edu.uniquindio.poo.model.Atleta;
import co.edu.uniquindio.poo.model.EmpresaEventosDeportivos;
import co.edu.uniquindio.poo.model.Entrenador;
import co.edu.uniquindio.poo.model.Participante;


public class EmpresaEventosDeportivosTest {
    private static final Logger LOG = Logger.getLogger(EmpresaEventosDeportivosTest.class.getName());
    private EmpresaEventosDeportivos empresaEventosDeportivos;
    
    @BeforeEach
    public void setUp(){
        empresaEventosDeportivos = new EmpresaEventosDeportivos("Los Olympicos");
    }

    @Test
    public void testAgregarParticipante() {
        LOG.info("Iniciado test testAgregarParticipante");
        Atleta participante1 = new Atleta("roberto", "alvarez", LocalDate.of(1950, 10, 20), "colombiano", 30, "colombia", 4);
        empresaEventosDeportivos.agregarParticipante(participante1);
        assertTrue(empresaEventosDeportivos.getListaParticipantes().contains(participante1));
        LOG.info("Finalizando test testAgregarParticipante");
    }

    


}