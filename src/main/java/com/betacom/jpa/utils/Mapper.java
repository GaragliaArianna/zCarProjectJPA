package com.betacom.jpa.utils;

import java.util.List;

import java.util.stream.Collectors;


import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.models.Bici;


import com.betacom.jpa.dto.outputs.AlimentazioneDTO;
import com.betacom.jpa.dto.outputs.CategoriaDTO;
import com.betacom.jpa.dto.outputs.ColoreDTO;
import com.betacom.jpa.dto.outputs.MarcaDTO;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Marca;

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
                .pieghevole(bici.getPiegevole())
                .build();
    }

    // Converte lista di Bici in lista di DTO
    public static List<BiciDTO> buildBiciDTO(List<Bici> biciList) {
        return biciList.stream()
                .map(Mapper::buildBiciDTO)
                .collect(Collectors.toList());
    }
}


