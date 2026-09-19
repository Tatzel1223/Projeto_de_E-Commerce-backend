package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import br.edu.unifio.e_commerceback.entidades.Cliente;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class ClienteRepositorioTests {
    @Autowired 
    private ClienteRepositorios clienteRepositorio;

    @Test 
    @Order (2)
    public void deveBuscarUmClientePorId () {
        Cliente cliente = clienteRepositorio.findById(1).orElseThrow();
        assertNotNull(cliente);
        assertEquals("João Silva", cliente.getNome());
    }

    @Test 
    @Order (1)
    public void deveListarTodosOsClientes (){
    List  <Cliente> cliente = clienteRepositorio.findAll(Sort.by("nome"));

    assertEquals(5, cliente.size());
    }
    
    @Test 
    public void deveExcluirUmClientePorId (){
    Cliente cliente = new Cliente();
    cliente.setEmail("null");
    cliente.setNome("null");
    cliente.setTelefone("null");

    assertTrue(clienteRepositorio.existsById(cliente.getId()));
    clienteRepositorio.deleteById(cliente.getId());
    assertFalse(clienteRepositorio.existsById(cliente.getId()));
    }

    @Test 
    public void deveSalvarUmCliente(){
    Cliente cliente = new Cliente();
    cliente.setNome("Maria Silva");
    cliente.setEmail("maria@email.com");
    cliente.setTelefone("11999999999");
    clienteRepositorio.save(cliente);
    
    assertTrue(clienteRepositorio.existsById(cliente.getId()));
    assertEquals("Maria Silva", clienteRepositorio.findById(cliente.getId()).orElseThrow().getNome());
    }

    @Test
    public void deveAlterarUmCliente() {
    Cliente cliente = clienteRepositorio.findById(1).orElseThrow();
    cliente.setNome("João Silva Alter");
        
    clienteRepositorio.save(cliente);

    Cliente clienteAtualizado = clienteRepositorio.findById(1).orElseThrow();
    assertEquals("João Silva Alter", clienteAtualizado.getNome());
    }
}
