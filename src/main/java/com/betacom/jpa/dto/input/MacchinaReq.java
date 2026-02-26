package com.betacom.jpa.dto.input;


import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MacchinaReq extends VeicoloReq{

	private Integer numeroPorte;
	
	@Pattern(
		    regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$"
		)
	private String targa;

	private Integer cc;
}
