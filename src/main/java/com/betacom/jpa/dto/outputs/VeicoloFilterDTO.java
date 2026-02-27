package com.betacom.jpa.dto.outputs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class VeicoloFilterDTO {
    private Integer id;
    private String modello;
    private Integer annoProduzione;
    private Integer numeroRuote;
    private String categoria;
    private String colore;
    private String marca;
    private String alimentazione;
    private String tipoVeicolo;
    // Macchina
    private String targa;
    private Integer numeroPorte;
    private Integer cilindrataAuto;
    // Moto
    private Integer cilindrataMoto;
    private String targaMoto;
    // Bici
    private Integer numeroMarce;
    private Boolean pieghevole;
    private String sospensione;
    private String freno;
    // getter & setter
}
