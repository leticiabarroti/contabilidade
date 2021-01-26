package com.algoworks.algamoneyapi.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algoworks.algamoneyapi.demo.converter.LancamentoConverter;
import com.algoworks.algamoneyapi.demo.exceptions.NotFoundException;
import com.algoworks.algamoneyapi.demo.model.Lancamento;
import com.algoworks.algamoneyapi.demo.model.dtos.LancamentoDTO;
import com.algoworks.algamoneyapi.demo.repository.ILancamentoRepository;
import com.algoworks.algamoneyapi.demo.util.Mensagens;

@Service
public class LancamentoService {
	
	@Autowired
	private ILancamentoRepository lancamentoRepository;
	
	@Autowired
	private LancamentoConverter lancamentoConverter;

	public LancamentoDTO inserirOrAlterar(LancamentoDTO lancamentoDTO) {
		Lancamento lancamento = lancamentoConverter.toDtoToEntity(lancamentoDTO);
		
		lancamentoRepository.save(lancamento);	
		
		return lancamentoConverter.toEntityToDto(lancamento);
	}

	public List<LancamentoDTO> recuperarTodos() {
		List<Lancamento> lista = lancamentoRepository.findAll();
		
		if(lista.isEmpty()) {
			throw new NotFoundException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO);
		}
		
		return lancamentoConverter.toListEntityToListDto(lista);
	}

	public LancamentoDTO recuperarLancamentoPorId(Long id) {
		Lancamento lancamento = validarPorIdExistente(id);
		
		return lancamentoConverter.toEntityToDto(lancamento);
		
	}

	
	private Lancamento validarPorIdExistente(Long id) {
		Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
		
		if(lancamento == null) {
			throw new NotFoundException(Mensagens.MSG_DADO_INEXISTENTE);
		}
		
		return lancamento.get();
	}
}
