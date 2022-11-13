package br.com.cabidedamoda.controle.caixa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_FLUXO")
public class FluxoModel {
	@Column(name = "id_dono",nullable = false)
	private Integer idDono;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fluxo")
	private Integer idFluxo;
	
	@Column(name = "nome_fluxo",nullable = false, length = 250)
	private String nomeFluxo;
}
