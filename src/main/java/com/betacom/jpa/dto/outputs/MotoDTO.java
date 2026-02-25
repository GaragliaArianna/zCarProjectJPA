package com.betacom.jpa.dto.outputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MotoDTO extends VeicoloDTO{

    private String targa;

    private Integer cc;
}
