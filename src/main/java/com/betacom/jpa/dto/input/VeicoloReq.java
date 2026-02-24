package com.betacom.jpa.dto.input;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class VeicoloReq {
	

	private Integer idVeicolo;
	

	private Integer numeroRuote;
	
	
	private Integer idTipoVeicolo;
	

	private String idCategoria;
	

	private String idTipoAlimentazione;

	private Integer idColore;
	

	private Integer idMarca;
	

	private String  modello;
	

	private LocalDate annoProduzione;

	
}
