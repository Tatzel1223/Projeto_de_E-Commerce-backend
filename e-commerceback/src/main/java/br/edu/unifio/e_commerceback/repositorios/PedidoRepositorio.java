package br.edu.unifio.e_commerceback.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.e_commerceback.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository <Pedido, Integer>{

}
