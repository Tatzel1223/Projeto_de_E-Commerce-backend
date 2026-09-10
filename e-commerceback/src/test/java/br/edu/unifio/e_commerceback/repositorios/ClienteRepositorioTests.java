package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.Cliente;

@SpringBootTest 
public class ClienteRepositorioTests {
    @Autowired 

    private ClienteRepositorioTests clienteRepositorioTests;

    @Test 
    public void deveBuscarUmClientePorId () {
        Cliente cliente = clienteRepositorioTests.findById(Integer.parseInt("3")).orElseThrow();
        assertNotNull(cliente);
        assertEquals("João Silva", cliente.getNome());
    }
}
