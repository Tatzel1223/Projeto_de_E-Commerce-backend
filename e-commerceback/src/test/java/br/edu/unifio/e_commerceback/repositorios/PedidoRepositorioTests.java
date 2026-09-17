package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.Cliente;
import br.edu.unifio.e_commerceback.entidades.Pedido;

@SpringBootTest
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class PedidoRepositorioTests {
    @Autowired 
    private PedidoRepositorio pedidoRepositorio;

    @Autowired 
    private Cliente cliente;

    @Test 
    public void deveBuscarPedidoPorId () {
    Pedido pedido = pedidoRepositorio.findById(4).orElseThrow();
    assertNotNull(pedido);
    assertEquals("PAGO", pedido.getStatus());
    }
    
    @Test 
    public void deveListarTodosOsPedidos (){
    
    }
    
    @Test 
    public void deveExcluirUmPedidoPorId(){

    }

    @Test 
    public void deveSalvarUmPedido(){

    }
}
