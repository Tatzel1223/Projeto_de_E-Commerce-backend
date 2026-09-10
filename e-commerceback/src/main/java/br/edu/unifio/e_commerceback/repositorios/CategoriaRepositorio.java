package br.edu.unifio.e_commerceback.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unifio.e_commerceback.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository <Categoria, Short> {

}
