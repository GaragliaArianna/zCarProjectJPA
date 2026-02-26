package com.betacom.jpa.dto.input;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MotoReq extends VeicoloReq{
	
	private Integer id;
	
	private String targa;
	
	private Integer cc;

}
