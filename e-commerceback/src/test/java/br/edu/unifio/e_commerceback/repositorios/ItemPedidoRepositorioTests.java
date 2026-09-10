package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.ItemPedido;

@SpringBootTest 
public class ItemPedidoRepositorioTests {
    @Autowired 
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Test 
    public void deveBuscarUmItemPedidoPorId(){
        ItemPedido itemPedido = itemPedidoRepositorio.findById(3).orElseThrow();
        assertNotNull(itemPedido);
        assertEquals(2, itemPedido.getQuantidade());
    }
}