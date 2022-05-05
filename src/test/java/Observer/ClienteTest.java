package Observer;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ClienteTest {
    @Test
    void deveNotificarCliente() {
        Celular celular = new Celular("IPhone 11", "vermelho");
        Cliente cliente = new Cliente("Pedro");
        cliente.listaDesejados(celular);
        celular.atualizarEstoque();
        assertEquals("Olá Pedro, o celular IPhone 11, cor vermelho, está disponível!", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Celular celular = new Celular("MotoG 5G", "azul");
        Cliente clientePedro = new Cliente("Pedro");
        clientePedro.listaDesejados(celular);
        Cliente clienteJose = new Cliente("José");
        clienteJose.listaDesejados(celular);
        celular.atualizarEstoque();
        assertEquals("Olá Pedro, o celular MotoG 5G, cor azul, está disponível!", clientePedro.getUltimaNotificacao());
        assertEquals("Olá José, o celular MotoG 5G, cor azul, está disponível!", clienteJose.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Celular celular = new Celular("IPhone 12 Pro Max", "dourado");
        Cliente cliente = new Cliente("Max");
        celular.atualizarEstoque();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasUmCliente() {
        Celular iphone13 = new Celular("IPhone 13", "prata");
        Cliente clientePedro = new Cliente("Pedro");
        clientePedro.listaDesejados(iphone13);
        Celular motoG5 = new Celular("MotoG 5", "azul");
        Cliente clienteJose = new Cliente("José");
        clienteJose.listaDesejados(motoG5);
        iphone13.atualizarEstoque();
        assertEquals("Olá Pedro, o celular IPhone 13, cor prata, está disponível!", clientePedro.getUltimaNotificacao());
        assertEquals(null, clienteJose.getUltimaNotificacao());
    }
}
