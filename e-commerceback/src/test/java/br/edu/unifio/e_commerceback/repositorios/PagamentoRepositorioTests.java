package br.edu.unifio.e_commerceback.repositorios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.e_commerceback.entidades.Pagamento;

@SpringBootTest 
public class PagamentoRepositorioTests {
    @Autowired 
    private PagamentoRepositorio pagamentoRepositorio;

    @Test 
    private void deveBuscarPagamentoPorId () {
        Pagamento pagamento = pagamentoRepositorio.findById(4).orElseThrow();
        assertNotNull(pagamento);
        assertEquals("Pix", pagamento.getTipo());
    }
}
