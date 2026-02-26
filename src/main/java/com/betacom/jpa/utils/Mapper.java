package com.betacom.jpa.utils;

import java.util.List;

import java.util.stream.Collectors;


import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.models.Bici;


import com.betacom.jpa.dto.outputs.AlimentazioneDTO;
import com.betacom.jpa.dto.outputs.CategoriaDTO;
import com.betacom.jpa.dto.outputs.ColoreDTO;
import com.betacom.jpa.dto.outputs.MacchinaDTO;
import com.betacom.jpa.dto.outputs.MarcaDTO;
import com.betacom.jpa.dto.outputs.TipoSospensioneDTO;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Marca;
import com.betacom.jpa.models.TipoSospensione;

public class Mapper {
	public static AlimentazioneDTO buildAlimentazioneDTO(Alimentazione alim) {
		return AlimentazioneDTO.builder()
				.idAlimentazione(alim.getId())
				.tipoAlimentazione(alim.getAlimentazione())
				.build();
	}
	public static List<AlimentazioneDTO> buildAlimentazioneDTO(List<Alimentazione> alim) {
		return alim.stream().map( a-> AlimentazioneDTO.builder()
				.idAlimentazione(a.getId())
				.tipoAlimentazione(a.getAlimentazione())
				.build()).collect(Collectors.toList());
	}
	public static CategoriaDTO buildCategoriaDTO(Categoria cat) {
		return CategoriaDTO.builder()
				.categoria(cat.getCategoria())
				.idCategoria(cat.getId())
				.build();
	}
	public static List<CategoriaDTO> buildCategoriaDTO(List<Categoria> cat) {
		return cat.stream().map( c -> CategoriaDTO.builder()
				.categoria(c.getCategoria())
				.idCategoria(c.getId())
				.build()).collect(Collectors.toList());
	}
	public static ColoreDTO buildColoreDTO(Colore col) {
		return ColoreDTO.builder()
				.colore(col.getColore())
				.idColore(col.getIdColore())
				.build();
	}
	public static List<ColoreDTO> buildColoreDTO(List<Colore> col) {
		return col.stream().map( c -> ColoreDTO.builder()
				.colore(c.getColore())
				.idColore(c.getIdColore())
				.build()).collect(Collectors.toList());
	}
	public static MarcaDTO buildMarcaDTO(Marca mar) {
		return MarcaDTO.builder()
				.idMarca(mar.getIdMarca())
				.marca(mar.getMarca())
				.build();
	}
	public static List<MarcaDTO> buildMarcaDTO(List<Marca> mar) {
		return mar.stream().map(m -> MarcaDTO.builder()
				.idMarca(m.getIdMarca())
				.marca(m.getMarca())
				.build()).collect(Collectors.toList());
	}
	
	public static TipoSospensioneDTO buildTipoSospensioneDTO(TipoSospensione ts) {
	    if (ts == null) return null;

	    return TipoSospensioneDTO.builder()
	            .id(ts.getIdSospensione())
	            .sospensione(ts.getSospensione())
	            .build();
	}
	
	public static List<TipoSospensioneDTO> buildTipoSospensioneDTO(List<TipoSospensione> list) {
	    return list.stream()
	            .map(Mapper::buildTipoSospensioneDTO)
	            .collect(Collectors.toList());
	}
	
	
	// Converte singola Bici in DTO.
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
                .pieghevole(bici.getPiegevole())
                .build();
    }

    // Converte lista di Bici in lista di DTO.
    public static List<BiciDTO> buildBiciDTO(List<Bici> biciList) {
        return biciList.stream()
                .map(Mapper::buildBiciDTO)
                .collect(Collectors.toList());
    }
    public static MacchinaDTO buildMacchinaDTO(Macchina macchina) {
 		if (macchina == null) return null;

 		return MacchinaDTO.builder()
 				.idVeicolo(macchina.getId())
 				.numeroRuote(macchina.getNumeroRuote())
 				.tipoVeicolo(macchina.getTipoVeicolo() != null ? macchina.getTipoVeicolo().getVeicolo() : null)
 				.categoria(macchina.getCategoria() != null ? macchina.getCategoria().getCategoria() : null)
 				.tipoAlimentazione(macchina.getAlimentazione() != null ? macchina.getAlimentazione().getAlimentazione() : null)
 				.colore(macchina.getColore() != null ? macchina.getColore().getColore() : null)
 				.marca(macchina.getMarca() != null ? macchina.getMarca().getMarca() : null)
 				.modello(macchina.getModello())
 				.annoProduzione(macchina.getAnnoProduzione())
 				.numeroPorte(macchina.getNumeroPorte())
 				.targa(macchina.getTarga())
 				.cc(macchina.getCc())
 				.build();
 	}

 	public static List<MacchinaDTO> buildMacchinaDTO(List<Macchina> macchinaList) {
 		return macchinaList.stream()
 				.map(Mapper::buildMacchinaDTO)
 				.collect(Collectors.toList());
 	}
}


