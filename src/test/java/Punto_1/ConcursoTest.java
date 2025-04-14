package Punto_1;


import Punto_1.algoritmo.Concurso;
import Punto_1.algoritmo.Participante;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {

    @Test
    void participanteSeInscribeCorrectamente() {
        Concurso concurso = new Concurso("Maratón", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 10));
        Participante p = new Participante("Ana");

        concurso.inscribir(p, LocalDate.of(2025, 4, 2));

        assertEquals(0, p.getPuntos());
        assertTrue(concurso.getInscriptos().contains(p));
    }

    @Test
    void participanteSeInscribeYGanaPuntos() {
        Concurso concurso = new Concurso("Maratón", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 10));
        Participante p = new Participante("Luis");

        concurso.inscribir(p, LocalDate.of(2025, 4, 1));

        assertEquals(10, p.getPuntos());
    }

    @Test
    void participanteSeInscribeFueraDeRangoYLanzaExcepcion() {
        Concurso concurso = new Concurso("Maratón", LocalDate.of(2025, 4, 1), LocalDate.of(2025, 4, 10));
        Participante p = new Participante("Sofi");

        Exception e = assertThrows(RuntimeException.class, () ->
                concurso.inscribir(p, LocalDate.of(2025, 3, 31)));

        assertEquals("Inscripción fuera del rango permitido", e.getMessage());
    }
}
