package com.betacom.jpa.dto.outputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class MotoDTO extends VeicoloDTO{

    private String targa;

    private Integer cc;
}
