package com.betacom.jpa.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@ToString

public class MotoDTO extends VeicoloDTO{

	private Integer id;
	
    private String targa;

    private Integer cc;
    
}
