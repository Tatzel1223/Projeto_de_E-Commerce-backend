package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.Categoria;

@SpringBootTest
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class CategoriaRepositoriosTests {
    @Autowired
    //Esse objeto será gerenciado pelo Spring
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void deveBuscarUmaCategoriaPorId () {
        Categoria categoria =categoriaRepositorio.findById(Short.parseShort("2")).orElseThrow();
        assertNotNull(categoria); 
        // garante que algo nao esta vazio
        assertEquals("Livros", categoria.getNome());

    }

    @Test 
    public void deveListarTodasAsCategorias (){
    
    }
    
    @Test 
    public void deveExcluirUmaCategoriaPorId (){

    }

    @Test 
    public void deveSalvarUmaCategoria (){
        
    }
}
