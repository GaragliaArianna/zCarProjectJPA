package com.betacom.jpa.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BiciReq extends VeicoloReq{

    private Integer numeroMarce;

    private Integer idTipoFreno;       
    private Integer idTipoSospensione; 

    private Boolean pieghevole;
    
    

}
