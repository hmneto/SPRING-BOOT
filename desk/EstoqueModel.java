package br.com.cabidedamoda.controle.caixa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estoque")
public class EstoqueModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estoque")
	private Integer idEstoque;
		
	@Column(name = "nome_da_peca",nullable = false, length = 250)
	private String nomePeca;
	
	@Column(name = "porcentagem",nullable = false,precision=5, scale=2)
	private BigDecimal porcentagem;
	
	@Column(name = "preco",nullable = false,precision=6, scale=2)
	private BigDecimal preco;
	
	@Column(name = "quantidade",nullable = false)
	private Integer quantidade;
	
	@Column(name = "tamanho",nullable = false, length = 6)
	private String tamanho;
}
