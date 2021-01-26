package com.algoworks.algamoneyapi.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "TB_CATEGORIA")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NO_CATEGORIA")
	private String nome;
}
