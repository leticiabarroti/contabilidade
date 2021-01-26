package com.algoworks.algamoneyapi.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algoworks.algamoneyapi.demo.model.Lancamento;
import com.algoworks.algamoneyapi.demo.model.dtos.LancamentoDTO;
import com.algoworks.algamoneyapi.demo.model.dtos.comum.SelectedItemDTO;
import com.algoworks.algamoneyapi.demo.model.enuns.TipoEnum;

@Component
public class LancamentoConverter {
	
	@Autowired
	private PessoaConverter pessoaConverter;
	
	@Autowired
	private CategoriaConverter categoriaConverter;

	public Lancamento toDtoToEntity(LancamentoDTO lancamentoDTO) {
		Lancamento lancamento = new Lancamento();
		
		lancamento.setId(lancamentoDTO.getId());
		lancamento.setDescricao(lancamentoDTO.getDescricao());
		lancamento.setDataPagamento(lancamentoDTO.getDataPagamento());
		lancamento.setDataVencimento(lancamentoDTO.getDataVencimento());
		lancamento.setObservacao(lancamentoDTO.getObservacao());
		lancamento.setValor(lancamentoDTO.getValor());
		lancamento.setTipo(TipoEnum.recuperarEnum(lancamentoDTO.getTipo().getValue()));
		lancamento.setPessoa(pessoaConverter.ToDtoToEntity(lancamentoDTO.getPessoa()));
		lancamento.setCategoria(categoriaConverter.toDtoToEntity(lancamentoDTO.getCategoria()));
		
		return lancamento;	
	}

	public LancamentoDTO toEntityToDto(Lancamento lancamento) {
		LancamentoDTO lancamentoDTO = new LancamentoDTO();
		
		lancamentoDTO.setId(lancamento.getId());
		lancamentoDTO.setDescricao(lancamento.getDescricao());
		lancamentoDTO.setDataPagamento(lancamento.getDataPagamento());
		lancamentoDTO.setDataVencimento(lancamento.getDataVencimento());
		lancamentoDTO.setObservacao(lancamento.getObservacao());
		lancamentoDTO.setValor(lancamento.getValor());
		lancamentoDTO.setTipo(new SelectedItemDTO(lancamento.getTipo().getCodigo(), lancamento.getTipo().getDescricao()));
		lancamentoDTO.setPessoa(pessoaConverter.toEntityToDto(lancamento.getPessoa()));
		lancamentoDTO.setCategoria(categoriaConverter.toEntityToDTO(lancamento.getCategoria()));
		
		return lancamentoDTO;
	}

	public List<LancamentoDTO> toListEntityToListDto(List<Lancamento> lista) {
		List<LancamentoDTO> listaDTO = new ArrayList<LancamentoDTO>();
		
		for (Lancamento lancamento : lista) {
			listaDTO.add(toEntityToDto(lancamento));
		}
		
		return listaDTO;
	}

}
