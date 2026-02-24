package com.betacom.jpa.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="veicolo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veicolo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer idVeicolo;
	
	@Column (
			name="numero_ruote",
			nullable = false
			)
	private Integer numeroRuote;
	
	@Column (
			name="tipo_veicolo"
			)
	private Integer idTipoVeicolo;
	
	@Column (
			name="categoria",
			nullable = false
			)
	private String idCategoria;
	
	@Column (
			name="tipo_alimentazione",
			nullable = false
			)
	private String idTipoAlimentazione;
	
	@Column (
			name="colore",
			nullable = false
			)
	private Integer idColore;
	
	@Column (
			name="marca",
			nullable = false
			)
	private Integer idMarca;
	
	@Column (
			name="modello",
			nullable = false
			)
	private String  modello;
	
	@Column (
			name="anno_produzione",
			nullable = false
			)
	private LocalDate annoProduzione;

}
