package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.Cliente;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class ClienteRepositorioTests {
    @Autowired 
    private ClienteRepositorios clienteRepositorio;

    @Test 
    public void deveBuscarUmClientePorId () {
        Cliente cliente = clienteRepositorio.findById(1).orElseThrow();
        assertNotNull(cliente);
        assertEquals("João Silva", cliente.getNome());
    }

    @Test 
    public void deveListarTodosOsClientes (){
    
    }
    
    @Test 
    public void deveExcluirUmClientePorId (){

    }

    @Test 
    public void deveSalvarUmCliente (){
        
    }
}
