package com.algoworks.algamoneyapi.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.algoworks.algamoneyapi.demo.model.Categoria;
import com.algoworks.algamoneyapi.demo.model.dtos.CategoriaDTO;

@Component
public class CategoriaConverter {

	public Categoria toDtoToEntity(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();
		categoria.setId(categoriaDTO.getId());
		categoria.setNome(categoriaDTO.getNome());
		return categoria;
	}

	public CategoriaDTO toEntityToDTO(Categoria categoria) {
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setId(categoria.getId());
		categoriaDTO.setNome(categoria.getNome());
		return categoriaDTO;
	}

	public List<CategoriaDTO> tolistEntitytoListDTO(List<Categoria> lista) {
		List<CategoriaDTO> listaDTO = new ArrayList<CategoriaDTO>();
		for (Categoria categoria : lista) {
			listaDTO.add(toEntityToDTO(categoria));
		}
		return listaDTO;
	}

}
