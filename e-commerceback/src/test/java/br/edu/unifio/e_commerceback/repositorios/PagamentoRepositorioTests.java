package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.Pagamento;
import br.edu.unifio.e_commerceback.entidades.Pedido;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class PagamentoRepositorioTests {
    @Autowired 
    private PagamentoRepositorio pagamentoRepositorio;

    @Autowired 
    private Pedido pedido;

    @Test 
    private void deveBuscarPagamentoPorId () {
        Pagamento pagamento = pagamentoRepositorio.findById(4).orElseThrow();
        assertNotNull(pagamento);
        assertEquals("Pix", pagamento.getTipo());
    }

    @Test 
    public void deveListarTodosOsPagamentos (){
    
    }
    
    @Test 
    public void deveExcluirUmPagamentoPorId (){

    }

    @Test 
    public void deveSalvarUmPagamento (){
        
    }
}
