package com.betacom.jpa.dto.input;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MacchinaReq {

	private Integer idVeicolo;
	
	private Integer idMacchina;
	

	private Integer numeroPorte;
	

	private String targa;

	private Integer cc;
}
