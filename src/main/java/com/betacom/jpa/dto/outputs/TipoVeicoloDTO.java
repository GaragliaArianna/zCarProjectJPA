package com.betacom.jpa.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class TipoVeicoloDTO {

    private Integer id;
    private String veicolo;
}