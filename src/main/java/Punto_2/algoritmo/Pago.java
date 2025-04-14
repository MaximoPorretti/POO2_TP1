package Punto_2.algoritmo;



public class Pago {
    private final Pedido pedido;
    private final String tipoTarjeta;
    private final double propina;

    public Pago(Pedido pedido, String tipoTarjeta, double propina) {
        this.pedido = pedido;
        this.tipoTarjeta = tipoTarjeta;
        this.propina = propina;
    }

    public double calcularTotal() {
        double platos = pedido.totalPlatos();
        double bebidas = pedido.totalBebidas();
        double total = platos + bebidas;

        switch (tipoTarjeta.toLowerCase()) {
            case "visa" -> total -= bebidas * 0.03;
            case "mastercard" -> total -= platos * 0.02;
            case "comarca plus" -> total *= 0.98;
        }

        return total + total * propina;
    }
}


