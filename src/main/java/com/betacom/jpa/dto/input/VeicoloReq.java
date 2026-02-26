package com.betacom.jpa.dto.input;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	private Integer numeroRuote;
	
	
	private Integer idTipoVeicolo;
	

	private Integer idCategoria;
	

	private Integer idTipoAlimentazione;

	private Integer idColore;
	

	private Integer idMarca;
	

	private String  modello;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate annoProduzione;

	
}
