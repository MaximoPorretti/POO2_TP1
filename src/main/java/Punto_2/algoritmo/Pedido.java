package Punto_2.algoritmo;



import java.util.HashMap;
import java.util.Map;

public class Pedido {
    private final Map<Producto, Integer> items = new HashMap<>();
    private boolean confirmado = false;

    public void agregarProducto(Producto producto, int cantidad) {
        if (confirmado) throw new IllegalStateException("El pedido ya fue confirmado");
        items.merge(producto, cantidad, Integer::sum);
    }

    public void confirmar() {
        this.confirmado = true;
    }

    public boolean estaConfirmado() {
        return confirmado;
    }

    public double totalPlatos() {
        return items.entrySet().stream()
                .filter(e -> e.getKey().esPlato())
                .mapToDouble(e -> e.getKey().getPrecio() * e.getValue())
                .sum();
    }

    public double totalBebidas() {
        return items.entrySet().stream()
                .filter(e -> e.getKey().esBebida())
                .mapToDouble(e -> e.getKey().getPrecio() * e.getValue())
                .sum();
    }
}
