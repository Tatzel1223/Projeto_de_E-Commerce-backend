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


import br.edu.unifio.e_commerceback.entidades.ItemPedido;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class ItemPedidoRepositorioTests {
    @Autowired 
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Autowired
    private ItemPedido itemPedido;

    @Test 
    @Order (2)
    public void deveBuscarUmItemPedidoPorId(){
        ItemPedido itemPedido = itemPedidoRepositorio.findById(3).orElseThrow();
        assertNotNull(itemPedido);
        assertEquals(2, itemPedido.getQuantidade());
    }

    @Test 
    @Order (1)
    public void deveListarTodosOsItemPedido (){
    List  <ItemPedido> itemPedido = itemPedidoRepositorio.findAll(Sort.by("id"));

    assertEquals(5, itemPedido.size());
    }
    
    @Test 
    public void deveExcluirUmItemPedidoPorId (){
    ItemPedido itemPedido = new ItemPedido();
    itemPedido.setPedido(pedidoRepositorio.findById(1).orElseThrow());
    itemPedido.setProduto(produtoRepositorio.findById(1).orElseThrow());
    itemPedido.setQuantidade(null);
    itemPedido.setValorUnitario(new BigDecimal(200));

    assertTrue(itemPedidoRepositorio.existsById(itemPedido.getId()));
    itemPedidoRepositorio.deleteById(itemPedido.getId());
    assertFalse(itemPedidoRepositorio.existsById(itemPedido.getId()));
    }

    @Test 
    public void deveSalvarUmItemPedido(){
    ItemPedido itemPedido = new ItemPedido();
    itemPedido.setQuantidade(2);
    itemPedido.setValorUnitario(new BigDecimal(200));
    itemPedido.setPedido(pedidoRepositorio.findById(1).orElseThrow());
    itemPedido.setProduto(produtoRepositorio.findById(1).orElseThrow());
    itemPedidoRepositorio.save(itemPedido);
    
    assertTrue(itemPedidoRepositorio.existsById(itemPedido.getId()));
    assertEquals(2, itemPedidoRepositorio.findById(itemPedido.getId()).orElseThrow().getQuantidade());
    }
}