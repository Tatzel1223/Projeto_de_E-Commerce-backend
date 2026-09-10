package br.edu.unifio.e_commerceback.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.e_commerceback.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository <Produto, Integer>{

}
