package com.algoworks.algamoneyapi.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.algoworks.algamoneyapi.demo.model.enuns.TipoEnum;
import com.algoworks.algamoneyapi.demo.model.enuns.TipoEnumConverter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "TB_LANCAMENTO")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Lancamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DS_LANCAMENTO")
	private String descricao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DT_PAGAMENTO")
	private Date dataPagamento;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DT_VENCIMENTO")
	private Date dataVencimento;
	
	@Column(name = "VL_LANCAMENTO")
	private Double valor;
	
	@Column(name = "DS_OBSERVACAO")
	private String observacao;
	
	@Convert(converter = TipoEnumConverter.class)
	@Column(name = "IC_TIPO")
	private TipoEnum tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_PESSOA")
	private Pessoa pessoa;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CO_CATEGORIA")
	private Categoria categoria;
}
