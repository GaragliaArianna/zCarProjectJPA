package com.betacom.jpa.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class AlimentazioneDTO {
	
	 private Integer idAlimentazione;  

	private String tipoAlimentazione;
}
