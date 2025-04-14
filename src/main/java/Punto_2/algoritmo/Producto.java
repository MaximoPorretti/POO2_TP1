package Punto_2.algoritmo;


public class Producto {
    private final String nombre;
    private final double precio;
    private final String tipo; // "bebida" o "plato"

    public Producto(String nombre, double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean esBebida() {
        return tipo.equalsIgnoreCase("bebida");
    }

    public boolean esPlato() {
        return tipo.equalsIgnoreCase("plato");
    }
}
