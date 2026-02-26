package com.betacom.jpa.dto.outputs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class MacchinaDTO extends VeicoloDTO{
    private Integer numeroPorte;

    private String targa;

    private Integer cc;
}
