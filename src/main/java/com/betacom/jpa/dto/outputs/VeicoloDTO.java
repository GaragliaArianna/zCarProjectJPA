package com.betacom.jpa.dto.outputs;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
public class VeicoloDTO {
    private Integer idVeicolo;

    private Integer numeroRuote;

    private String tipoVeicolo;       
    private String categoria;         
    private String tipoAlimentazione; 
    private String colore;           
    private String marca;            

    private String modello;

    private LocalDate annoProduzione;

}
