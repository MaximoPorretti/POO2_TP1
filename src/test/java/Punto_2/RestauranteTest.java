package Punto_2;


import Punto_2.algoritmo.Mesa;
import Punto_2.algoritmo.Pedido;
import Punto_2.algoritmo.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RestauranteTest {

    @Test
    public void testPagoConVisa() {
        Mesa mesa = new Mesa(1);
        Pedido pedido = new Pedido();
        pedido.agregarProducto(new Producto("Coca", 100, "bebida"), 2);     // 200
        pedido.agregarProducto(new Producto("Milanesa", 500, "plato"), 1);  // 500
        pedido.confirmar();

        mesa.asignarPedido(pedido);
        mesa.registrarPago("Visa", 0.03);

        double bebidas = 100 * 2;
        double platos = 500;
        double descuento = bebidas * 0.03;
        double subtotal = bebidas + platos - descuento;
        double propina = subtotal * 0.03;
        double esperado = subtotal + propina;

        double total = mesa.totalPagado();
        System.out.println("Esperado: " + esperado + " | Obtenido: " + total);
        assertEquals(esperado, total, 0.01);
    }

    @Test
    public void testPagoConMastercard() {
        Mesa mesa = new Mesa(2);
        Pedido pedido = new Pedido();
        pedido.agregarProducto(new Producto("Agua", 50, "bebida"), 2); // 100
        pedido.agregarProducto(new Producto("Pizza", 600, "plato"), 2); // 1200
        pedido.confirmar();

        mesa.asignarPedido(pedido);
        mesa.registrarPago("Mastercard", 0.05);

        double platos = 600 * 2;
        double bebidas = 50 * 2;
        double descuento = platos * 0.02;
        double subtotal = platos + bebidas - descuento;
        double propina = subtotal * 0.05;
        double esperado = subtotal + propina;

        double total = mesa.totalPagado();
        System.out.println("Esperado: " + esperado + " | Obtenido: " + total);
        assertEquals(esperado, total, 0.01);
    }

    @Test
    public void testPagoConComarcaPlus() {
        Mesa mesa = new Mesa(3);
        Pedido pedido = new Pedido();
        pedido.agregarProducto(new Producto("Ensalada", 300, "plato"), 1);
        pedido.agregarProducto(new Producto("Jugo", 100, "bebida"), 1);
        pedido.confirmar();

        mesa.asignarPedido(pedido);
        mesa.registrarPago("Comarca Plus", 0.02);

        double subtotal = (300 + 100) * 0.98;
        double propina = subtotal * 0.02;
        double esperado = subtotal + propina;

        double total = mesa.totalPagado();
        System.out.println("Esperado: " + esperado + " | Obtenido: " + total);
        assertEquals(esperado, total, 0.01);
    }

    @Test
    public void testPagoConOtraTarjeta() {
        Mesa mesa = new Mesa(4);
        Pedido pedido = new Pedido();
        pedido.agregarProducto(new Producto("Pastas", 400, "plato"), 1);
        pedido.agregarProducto(new Producto("Gaseosa", 80, "bebida"), 1);
        pedido.confirmar();

        mesa.asignarPedido(pedido);
        mesa.registrarPago("Viedma", 0.05);

        double subtotal = 400 + 80;
        double propina = subtotal * 0.05;
        double esperado = subtotal + propina;

        double total = mesa.totalPagado();
        System.out.println("Esperado: " + esperado + " | Obtenido: " + total);
        assertEquals(esperado, total, 0.01);
    }

    @Test
    public void testAsignarPedidoYaConfirmado() {
        Mesa mesa = new Mesa(5);
        Pedido pedido1 = new Pedido();
        pedido1.agregarProducto(new Producto("Plato", 100, "plato"), 1);
        pedido1.confirmar();
        mesa.asignarPedido(pedido1);

        Pedido pedido2 = new Pedido();
        assertThrows(IllegalStateException.class, () -> mesa.asignarPedido(pedido2));
    }

    @Test
    public void testRegistrarPagoSinConfirmarPedido() {
        Mesa mesa = new Mesa(6);
        Pedido pedido = new Pedido();
        mesa.asignarPedido(pedido);

        assertThrows(IllegalStateException.class, () -> mesa.registrarPago("Visa", 0.03));
    }

    @Test
    public void testTotalPagadoSinPago() {
        Mesa mesa = new Mesa(7);
        Pedido pedido = new Pedido();
        pedido.agregarProducto(new Producto("Plato", 100, "plato"), 1);
        pedido.confirmar();
        mesa.asignarPedido(pedido);

        assertThrows(IllegalStateException.class, mesa::totalPagado);
    }
}
