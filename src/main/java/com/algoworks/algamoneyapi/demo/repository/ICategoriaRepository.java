package com.algoworks.algamoneyapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algoworks.algamoneyapi.demo.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria findByNomeIgnoreCase(String nome);

}
