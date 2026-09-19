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

import br.edu.unifio.e_commerceback.entidades.Categoria;

@SpringBootTest
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class CategoriaRepositoriosTests {
    @Autowired
    //Esse objeto será gerenciado pelo Spring
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private Categoria categoria;

    @Test
    @Order (2)
    public void deveBuscarUmaCategoriaPorId () {
        Categoria categoria =categoriaRepositorio.findById(Short.parseShort("2")).orElseThrow();
        assertNotNull(categoria); 
        // garante que algo nao esta vazio
        assertEquals("Livros", categoria.getNome());

    }

    @Test 
    @Order (1)
    public void deveListarTodasAsCategorias (){
        List  <Categoria> categoria = categoriaRepositorio.findAll(Sort.by("nome"));

            assertEquals(5, categoria.size());
    }
    
    @Test 
    public void deveExcluirUmaCategoriaPorId (){
        Categoria categoria = new Categoria();
        categoria.setDescricao("null");
        categoria.setNome("null");
        categoriaRepositorio.save(categoria);

        assertTrue(categoriaRepositorio.existsById(categoria.getId()));
        categoriaRepositorio.deleteById(categoria.getId());
        assertFalse(categoriaRepositorio.existsById(categoria.getId()));
    }

    @Test 
    public void deveSalvarUmaCategoria(){
    Categoria categoria = new Categoria();
    categoria.setNome("Eletrônicos");
    categoria.setDescricao("Produtos eletrônicos em geral");
    categoriaRepositorio.save(categoria);
    
    assertTrue(categoriaRepositorio.existsById(categoria.getId()));
    assertEquals("Eletrônicos", categoriaRepositorio.findById(categoria.getId()).orElseThrow().getNome());
    }
    
    @Test
    public void deveAlterarUmaCategoria() {
    Categoria categoria = categoriaRepositorio.findById(Short.parseShort("2")).orElseThrow();
    categoria.setNome("Livros e Revistas");
        
    categoriaRepositorio.save(categoria);

    Categoria categoriaAtualizada = categoriaRepositorio.findById(Short.parseShort("2")).orElseThrow();
    assertEquals("Livros e Revistas", categoriaAtualizada.getNome());
    }

}
