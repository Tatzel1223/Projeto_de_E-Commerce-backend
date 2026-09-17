package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.ItemPedido;
import br.edu.unifio.e_commerceback.entidades.Pedido;
import br.edu.unifio.e_commerceback.entidades.Produto;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class ItemPedidoRepositorioTests {
    @Autowired 
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Autowired
    private Pedido pedido;

    @Autowired
    private Produto produto;

    @Test 
    public void deveBuscarUmItemPedidoPorId(){
        ItemPedido itemPedido = itemPedidoRepositorio.findById(3).orElseThrow();
        assertNotNull(itemPedido);
        assertEquals(2, itemPedido.getQuantidade());
    }

    @Test 
    public void deveListarTodosOsItemPedido (){
    
    }
    
    @Test 
    public void deveExcluirUmItemPedidoPorId (){

    }

    @Test 
    public void deveSalvarUmItemPedido (){
        
    }
}