package com.algoworks.algamoneyapi.demo.converter;

import org.springframework.stereotype.Component;

import com.algoworks.algamoneyapi.demo.model.Endereco;
import com.algoworks.algamoneyapi.demo.model.dtos.EnderecoDTO;
import com.algoworks.algamoneyapi.demo.model.dtos.comum.SelectedItemDTO;
import com.algoworks.algamoneyapi.demo.model.enuns.EstadoEnum;

@Component
public class EnderecoConverter {

	public Endereco ToDtoToEntity(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCep(enderecoDTO.getCep());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setEstado(EstadoEnum.recuperarEnum(enderecoDTO.getEstado().getValue()));
		endereco.setLogradouro(enderecoDTO.getLogradouro());
		endereco.setNumero(enderecoDTO.getNumero());
		return endereco;
	}

	public EnderecoDTO toEntityToDto(Endereco endereco) {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setComplemento(endereco.getComplemento());
		enderecoDTO.setEstado(new SelectedItemDTO(endereco.getEstado().getCodigo(), endereco.getEstado().getDescricao()));
		enderecoDTO.setLogradouro(endereco.getLogradouro());
		enderecoDTO.setNumero(endereco.getNumero());
		return enderecoDTO;
	}

}
