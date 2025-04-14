package Punto_2.algoritmo;


public class Mesa {
    private final int numero;
    private Pedido pedido;
    private Pago pago;

    public Mesa(int numero) {
        this.numero = numero;
    }

    public void asignarPedido(Pedido pedido) {
        if (this.pedido != null && this.pedido.estaConfirmado()) {
            throw new IllegalStateException("Ya hay un pedido confirmado en esta mesa.");
        }
        this.pedido = pedido;
    }

    public void registrarPago(String tipoTarjeta, double propina) {
        if (pedido == null || !pedido.estaConfirmado()) {
            throw new IllegalStateException("No hay pedido confirmado para pagar.");
        }
        this.pago = new Pago(pedido, tipoTarjeta, propina);
    }

    public double totalPagado() {
        if (pago == null) {
            throw new IllegalStateException("Aún no se ha realizado el pago.");
        }
        return pago.calcularTotal();
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public boolean tienePago() {
        return pago != null;
    }
}
