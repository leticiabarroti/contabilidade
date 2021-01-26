package com.algoworks.algamoneyapi.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algoworks.algamoneyapi.demo.converter.CategoriaConverter;
import com.algoworks.algamoneyapi.demo.exceptions.NegocioException;
import com.algoworks.algamoneyapi.demo.exceptions.NotFoundException;
import com.algoworks.algamoneyapi.demo.model.Categoria;
import com.algoworks.algamoneyapi.demo.model.dtos.CategoriaDTO;
import com.algoworks.algamoneyapi.demo.repository.ICategoriaRepository;
import com.algoworks.algamoneyapi.demo.util.Mensagens;

@Service
public class CategoriaService {

	@Autowired
	private ICategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaConverter categoriaConverter;

	@Transactional
	public CategoriaDTO inserirOrAlterar(CategoriaDTO categoriaDTO) {
		Categoria categoria = categoriaConverter.toDtoToEntity(categoriaDTO);

		validarCategoriaExistente(categoria.getNome());

		categoriaRepository.save(categoria);

		return categoriaConverter.toEntityToDTO(categoria);
	}

	private void validarCategoriaExistente(String nome) {
		Categoria categoria = categoriaRepository.findByNomeIgnoreCase(nome);

		if (categoria != null) {
			throw new NegocioException(Mensagens.MSG_CATEGORIA_EXISTENTE);
		}
	}

	@Transactional
	public List<CategoriaDTO> recuperarTodos() {
		List<Categoria> lista = categoriaRepository.findAll();

		if (lista.isEmpty()) {
			throw new NotFoundException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO);
		}

		return categoriaConverter.tolistEntitytoListDTO(lista);
	}

	@Transactional
	public CategoriaDTO recuperarCategoria(Long id) {
		Categoria categoria = validarPorID(id);

		return categoriaConverter.toEntityToDTO(categoria);
	}

	private Categoria validarPorID(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (!categoria.isPresent()) {
			throw new NotFoundException(Mensagens.MSG_NENHUM_REGISTRO_ENCONTRADO);
		}
		return categoria.get();
	}

	@Transactional
	public void remover(Long id) {
		validarPorIdInexistente(id);

		categoriaRepository.deleteById(id);
	}

	private void validarPorIdInexistente(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (!categoria.isPresent()) {
			throw new NotFoundException(Mensagens.MSG_DADO_INEXISTENTE);
		}
	}
}
