package com.betacom.jpa.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class TipoSospensioneDTO {
	
    private Integer id;
    private String sospensione;

}
