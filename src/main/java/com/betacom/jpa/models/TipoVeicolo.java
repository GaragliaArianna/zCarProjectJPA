package com.betacom.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tipi_veicolo")
public class TipoVeicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_veicolo")
    private Integer id;

    @Column(name = "veicolo", nullable = false, length = 50)
    private String veicolo;
}
