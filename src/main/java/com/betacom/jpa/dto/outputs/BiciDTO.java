package com.betacom.jpa.dto.outputs;

import com.betacom.jpa.dto.input.VeicoloReq;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
public class BiciDTO extends VeicoloDTO{
    private Integer numeroMarce;
    private String tipoFreno;       
    private String tipoSospensione;
    private Boolean piegevole;
}
