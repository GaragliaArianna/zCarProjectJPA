package com.betacom.jpa.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoReq extends VeicoloReq{
	
	private String targa;
	
	private Integer cc;

}
