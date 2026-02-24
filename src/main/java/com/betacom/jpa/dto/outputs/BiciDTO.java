package com.betacom.jpa.dto.outputs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BiciDTO {


    private Integer numeroMarce;

    private String tipoFreno;       
    private String tipoSospensione;

    private Boolean piegevole;
}
