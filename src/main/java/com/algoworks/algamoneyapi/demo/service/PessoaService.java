package com.algoworks.algamoneyapi.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algoworks.algamoneyapi.demo.converter.PessoaConverter;
import com.algoworks.algamoneyapi.demo.exceptions.NegocioException;
import com.algoworks.algamoneyapi.demo.exceptions.NotFoundException;
import com.algoworks.algamoneyapi.demo.model.Pessoa;
import com.algoworks.algamoneyapi.demo.model.dtos.PessoaDTO;
import com.algoworks.algamoneyapi.demo.repository.IPessoaRepository;
import com.algoworks.algamoneyapi.demo.util.Mensagens;

@Service
public class PessoaService {

	@Autowired
	private IPessoaRepository pessoaRepository;

	@Autowired
	private PessoaConverter pessoaConverter;

	@Transactional
	public PessoaDTO incluir(PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaConverter.ToDtoToEntity(pessoaDTO);
		validarPorCPF(pessoa.getCpf(), pessoa.getId());

		pessoaRepository.save(pessoa);

		return pessoaConverter.toEntityToDto(pessoa);
	}
	
	@Transactional
	public PessoaDTO alterar(PessoaDTO pessoaDTO) {
		Pessoa pessoa = pessoaConverter.ToDtoToEntity(pessoaDTO);
		validarPorCPF(pessoa.getCpf(), pessoa.getId());
		
		pessoaRepository.save(pessoa);

		return pessoaConverter.toEntityToDto(pessoa);
	}

	private Pessoa validarPorCPF(String cpf, Long id) {
		Pessoa pessoa = null;
		
		if(id == null) {
			pessoa = pessoaRepository.findByCpf(cpf);			
		}else {
			pessoa = pessoaRepository.findByCpfAlteracao(cpf, id);
		}

		if (pessoa != null) {
			throw new NegocioException(Mensagens.MSG_CPF_EXISTENTE);
		}
		return pessoa;
	}

	@Transactional
	public List<PessoaDTO> recuperarTodos() {
		List<Pessoa> pessoas = pessoaRepository.findAll();

		if (pessoas.isEmpty()) {
			throw new NotFoundException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO);
		}
		return pessoaConverter.toListEntityToListDto(pessoas);
	}

	public PessoaDTO recuperarPorId(Long id) {
		Pessoa pessoa = validarPorId(id);

		return pessoaConverter.toEntityToDto(pessoa);
	}

	@Transactional
	private Pessoa validarPorId(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);

		if (!pessoa.isPresent()) {
			throw new NegocioException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO);
		}
		return pessoa.get();
	}

	@Transactional
	public void remover(Long id) {
		validarPorIdInexistente(id);

		pessoaRepository.deleteById(id);
	}
	private void validarPorIdInexistente(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);

		if (!pessoa.isPresent()) {
			throw new NotFoundException(Mensagens.MSG_DADO_INEXISTENTE);
		}
	}

}
