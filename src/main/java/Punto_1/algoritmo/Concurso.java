package Punto_1.algoritmo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private String nombre;
    private LocalDate fechaInicioInscripcion;
    private LocalDate fechaFinInscripcion;
    private List<Participante> inscriptos;

    public Concurso(String nombre, LocalDate inicio, LocalDate fin) {
        this.nombre = nombre;
        this.fechaInicioInscripcion = inicio;
        this.fechaFinInscripcion = fin;
        this.inscriptos = new ArrayList<>();
    }

    public void inscribir(Participante participante, LocalDate fechaInscripcion) {
        if (fechaInscripcion.isBefore(fechaInicioInscripcion) || fechaInscripcion.isAfter(fechaFinInscripcion)) {
            throw new RuntimeException("Inscripción fuera del rango permitido");
        }
        if (fechaInscripcion.equals(fechaInicioInscripcion)) {
            participante.agregarPuntos(10);
        }
        inscriptos.add(participante);
    }

    public List<Participante> getInscriptos() {
        return inscriptos;
    }
}
