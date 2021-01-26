package com.algoworks.algamoneyapi.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algoworks.algamoneyapi.demo.model.Pessoa;
import com.algoworks.algamoneyapi.demo.model.dtos.PessoaDTO;
import com.algoworks.algamoneyapi.demo.model.dtos.comum.SelectedItemDTO;
import com.algoworks.algamoneyapi.demo.model.enuns.AtivoEnum;

@Component
public class PessoaConverter {
	
	@Autowired
	private EnderecoConverter enderecoConverter;

	public Pessoa ToDtoToEntity(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(pessoaDTO.getId());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setEndereco(enderecoConverter.ToDtoToEntity(pessoaDTO.getEndereco()));
		pessoa.setAtivo(AtivoEnum.recuperarEnum(pessoaDTO.getAtivo().getValue()));
		return pessoa;
	}

	public PessoaDTO toEntityToDto(Pessoa pessoa) {
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setId(pessoa.getId());
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setCpf(pessoa.getCpf());
		pessoaDTO.setEndereco(enderecoConverter.toEntityToDto(pessoa.getEndereco()));
		pessoaDTO.setAtivo(new SelectedItemDTO(pessoa.getAtivo().getCodigo(), pessoa.getAtivo().getDescricao()));
		return pessoaDTO;
	}

	public List<PessoaDTO> toListEntityToListDto(List<Pessoa> lista) {
		List<PessoaDTO> listaDTO = new ArrayList<PessoaDTO>();
		
		for (Pessoa pessoa : lista) {
			listaDTO.add(toEntityToDto(pessoa));
		}
		
		return listaDTO;
	}

}
