package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Atleta;
import co.edu.uniquindio.poo.model.EmpresaEventosDeportivos;
import co.edu.uniquindio.poo.model.Entrenador;

/**
 * Unit test for simple App.
 */
public class EmpresaEventosDeportivosTest {
    private static final Logger LOG = Logger.getLogger(EmpresaEventosDeportivosTest.class.getName());

    @Test
    public void shouldAnswerWithTrue() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        assertTrue(true);
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }

    @Test
    public void bases(){
        EmpresaEventosDeportivos supergym = new EmpresaEventosDeportivos("supergym");
        Atleta bolt = new Atleta("bolt", "henao", LocalDate.of(1994, 10, 4), "Armenio", 3);
        Entrenador ector = new Entrenador("ector", "castilla", LocalDate.of(1980, 9, 18), "canadience", "corredor");
        
    }
}
