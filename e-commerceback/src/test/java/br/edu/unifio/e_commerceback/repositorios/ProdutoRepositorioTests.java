package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.Produto;

@SpringBootTest
public class ProdutoRepositorioTests {
    @Autowired 
    private ProdutoRepositorio produtoRepositorio;

    @Test
    public void deveBuscarProdutoPorId() {
        Produto produto = produtoRepositorio.findById(3).orElseThrow();
        assertNotNull(produto);
        assertEquals("Chave Inglesa", produto.getDescricao());
    }
}
