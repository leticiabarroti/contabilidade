package com.algoworks.algamoneyapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algoworks.algamoneyapi.demo.model.Pessoa;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {

	Pessoa findByCpf(String cpf);

	@Query("SELECT p FROM Pessoa p WHERE p.cpf = :cpf AND p.id != :id ")
	Pessoa findByCpfAlteracao(String cpf, Long id);
}
