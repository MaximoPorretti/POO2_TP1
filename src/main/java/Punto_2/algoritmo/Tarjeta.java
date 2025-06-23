package Punto_2.algoritmo;

interface Tarjeta {
    double calcularDescuento(Pedido pedido);


    class Visa implements Tarjeta {
        @Override
        public double calcularDescuento(Pedido pedido) {
            return pedido.totalBebidas() * 0.03;
        }
    }

}
