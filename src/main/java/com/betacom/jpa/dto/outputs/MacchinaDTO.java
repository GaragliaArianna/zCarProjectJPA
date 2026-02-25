package com.betacom.jpa.dto.outputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MacchinaDTO extends VeicoloDTO{
    private Integer numeroPorte;

    private String targa;

    private Integer cc;
}
