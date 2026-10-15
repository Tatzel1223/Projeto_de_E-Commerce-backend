package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.e_commerceback.entidades.Pedido;

@SpringBootTest
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class PedidoRepositorioTests {
    @Autowired 
    private PedidoRepositorio pedidoRepositorio;

    @Autowired 
    private ClienteRepositorios clienteRepositorio;

    @Autowired 
    private Pedido pedido;
    
    @Test 
    @Order (2)
    public void deveBuscarPedidoPorId () {
    Pedido pedido = pedidoRepositorio.findById(4).orElseThrow();
    assertNotNull(pedido);
    assertEquals("PAGO", pedido.getStatus());
    }
    
    @Test 
    @Order (1)
    public void deveListarTodosOsPedidos (){
    List  <Pedido> pedido = pedidoRepositorio.findAll(Sort.by("id"));
    
    assertEquals(5, pedido.size());
    }
    
    @Test 
    public void deveExcluirUmPedidoPorId(){
    Pedido pedido = new Pedido();
    pedido.setCliente(clienteRepositorio.findById(Integer.parseInt("1")).orElseThrow());
    pedido.setData(null);
    pedido.setStatus(null);
    pedido.setValorTotal(new BigDecimal(10));

    assertTrue(pedidoRepositorio.existsById(pedido.getId()));
    pedidoRepositorio.deleteById(pedido.getId());
    assertFalse(pedidoRepositorio.existsById(pedido.getId()));
    }

    @Test 
    public void deveSalvarUmPedido(){
    Pedido pedido = new Pedido();
    pedido.setCliente(clienteRepositorio.findById(Integer.parseInt("1")).orElseThrow());
    pedido.setData(null);
    pedido.setStatus("TESTE");
    pedido.setValorTotal(new BigDecimal(10));
    
    assertTrue(pedidoRepositorio.existsById(pedido.getId()));
    assertEquals("TESTE", pedidoRepositorio.findById(pedido.getId()).orElseThrow().getStatus());
    }
}
