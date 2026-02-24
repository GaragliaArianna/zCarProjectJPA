package com.betacom.jpa.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BiciReq {

	private Integer idBici;
	
    private Integer numeroMarce;
	
    private String tipoFreno; 

    private String tipoSospensione; 

    private Boolean piegevole;
    
    private Integer idVeicolo;

}
