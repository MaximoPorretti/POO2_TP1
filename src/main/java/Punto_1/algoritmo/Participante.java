package Punto_1.algoritmo;

public class Participante {
    private String nombre;
    private int puntos;

    public Participante(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }
}
