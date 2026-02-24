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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="veicoli")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veicolo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (
			name="numero_ruote",
			nullable = false
			)
	private Integer numeroRuote;
	
    @ManyToOne
    @JoinColumn(name = "id_tipo_veicolo", nullable = false)
	private TipoVeicolo tipoVeicolo;
	
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;
	
    @ManyToOne
    @JoinColumn(name = "id_tipo_alimentazione", nullable = false)
	private Alimentazione alimentazione;
	
    @ManyToOne
    @JoinColumn(name = "id_colore", nullable = false)
	private Colore colore;
	
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;
	
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
