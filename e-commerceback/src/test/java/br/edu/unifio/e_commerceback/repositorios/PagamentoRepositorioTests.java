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

import br.edu.unifio.e_commerceback.entidades.Cliente;
import br.edu.unifio.e_commerceback.entidades.Pagamento;
import br.edu.unifio.e_commerceback.entidades.Pedido;

@SpringBootTest 
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class PagamentoRepositorioTests {
    @Autowired 
    private PagamentoRepositorio pagamentoRepositorio;

    @Autowired 
    private PedidoRepositorio pedidoRepositorio;

    @Test 
    @Order (2)
    private void deveBuscarPagamentoPorId () {
        Pagamento pagamento = pagamentoRepositorio.findById(4).orElseThrow();
        assertNotNull(pagamento);
        assertEquals("Pix", pagamento.getTipo());
    }

    @Test 
    @Order (1)
    public void deveListarTodosOsPagamentos (){
    List <Pagamento> pagamento = pagamentoRepositorio.findAll(Sort.by("id"));

    assertEquals(5, pagamento.size());
    }
    
    @Test 
    public void deveExcluirUmPagamentoPorId (){
    Pagamento pagamento = new Pagamento();
    pagamento.setData(null);
    pagamento.setPedido(null);
    pagamento.setStatus(null);
    pagamento.setTipo(null);
    pagamento.setValor(new BigDecimal(200));
    
    assertTrue(pagamentoRepositorio.existsById(pagamento.getId()));
    pagamentoRepositorio.deleteById(pagamento.getId());
    assertFalse(pagamentoRepositorio.existsById(pagamento.getId()));
    }

@Test 
    public void deveSalvarUmPagamento(){
    Pagamento pagamento = new Pagamento();
    pagamento.setTipo("Pix");
    pagamento.setValor(new BigDecimal(10.00));
    pagamento.setStatus("PAGO");
    pagamento.setData(null);
    pagamento.setPedido(pedidoRepositorio.findById(Integer.parseInt("1")).orElseThrow());
    pagamentoRepositorio.save(pagamento);
    
    assertTrue(pagamentoRepositorio.existsById(pagamento.getId()));
    assertEquals("Pix", pagamentoRepositorio.findById(pagamento.getId()).orElseThrow().getTipo());
    }

    @Test
    public void deveAlterarUmPagamento() {
    Pagamento pagamento = pagamentoRepositorio.findById(1).orElseThrow();
    pagamento.setTipo("Cartão de Crédito");
        
    pagamentoRepositorio.save(pagamento);

    Pagamento pagamentoAtualizado = pagamentoRepositorio.findById(1).orElseThrow();
    assertEquals("Cartão de Crédito", pagamentoAtualizado.getTipo());
    }
}
