package com.betacom.jpa.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name="bici")
public class Bici extends Veicolo{
	

	
	@Column (
			name="numero_marce",
			nullable = false
			)
    private Integer numeroMarce;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_freno", nullable = false)
	private TipoFreno tipoFreno;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_sospensione", nullable = false)
    private TipoSospensione tipoSospensione; 
	
	@Column (
			name="pieghevole",
			nullable = false
			)
    private Boolean piegevole;


}
