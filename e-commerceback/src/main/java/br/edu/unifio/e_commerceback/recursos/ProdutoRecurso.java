package br.edu.unifio.e_commerceback.recursos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifio.e_commerceback.entidades.Produto;
import br.edu.unifio.e_commerceback.repositorios.ProdutoRepositorio;

@RestController 
@RequestMapping ("produtos")
public class ProdutoRecurso {
    private final ProdutoRepositorio produtoRepositorio;
    public ProdutoRecurso(ProdutoRepositorio produtoRepositorio){
        this.produtoRepositorio = produtoRepositorio;
    }

    @GetMapping
    public List<Produto> listar (){
        return produtoRepositorio.findAll(Sort.by("nome"));
        
    }   
    
    @GetMapping ("{id}")
    public Produto BuscarPorId (@PathVariable Integer id){
        return produtoRepositorio.findById(id).orElseThrow();
    }
}