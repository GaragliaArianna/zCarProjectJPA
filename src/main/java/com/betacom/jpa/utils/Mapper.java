package com.betacom.jpa.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.models.Bici;
public class Mapper {

    // Converte singola Bici in DTO
    public static BiciDTO buildBiciDTO(Bici bici) {
        if (bici == null) return null;

        return BiciDTO.builder()
                .idVeicolo(bici.getId())
                .numeroRuote(bici.getNumeroRuote())
                .tipoVeicolo(bici.getTipoVeicolo() != null ? bici.getTipoVeicolo().getVeicolo() : null)
                .categoria(bici.getCategoria() != null ? bici.getCategoria().getCategoria() : null)
                .tipoAlimentazione(bici.getAlimentazione() != null ? bici.getAlimentazione().getAlimentazione() : null)
                .colore(bici.getColore() != null ? bici.getColore().getColore() : null)
                .marca(bici.getMarca() != null ? bici.getMarca().getMarca() : null)
                .modello(bici.getModello())
                .annoProduzione(bici.getAnnoProduzione())
                .numeroMarce(bici.getNumeroMarce())
                .tipoFreno(bici.getTipoFreno() != null ? bici.getTipoFreno().getTipo() : null)
                .tipoSospensione(bici.getTipoSospensione() != null ? bici.getTipoSospensione().getSospensione() : null)
                .piegevole(bici.getPiegevole())
                .build();
    }

    // Converte lista di Bici in lista di DTO
    public static List<BiciDTO> buildBiciDTO(List<Bici> biciList) {
        return biciList.stream()
                .map(Mapper::buildBiciDTO)
                .collect(Collectors.toList());
    }
}

