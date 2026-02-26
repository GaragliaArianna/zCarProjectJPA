package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.betacom.jpa.models.Veicolo;

public interface IVeicoloRepository extends JpaRepository<Veicolo, Integer>{
	@Query(name = "veicolo.selectByFilter")
	List<Veicolo> searchByFilter(

	        @Param("id") Integer id,
	        @Param("modello") String modello,
	        @Param("annoProduzione") Integer annoProduzione,
	        @Param("numeroRuote") Integer numeroRuote,
	        @Param("categoria") String categoria,
	        @Param("colore") String colore,
	        @Param("marca") String marca,
	        @Param("alimentazione") String alimentazione,
	        @Param("tipoVeicolo") String tipoVeicolo,

	        // Macchina
	        @Param("targa") String targa,
	        @Param("numeroPorte") Integer numeroPorte,
	        @Param("cilindrataAuto") Integer cilindrataAuto,

	        // Moto
	        @Param("cilindrataMoto") Integer cilindrataMoto,
	        @Param("targaMoto") String targaMoto,

	        // Bici
	        @Param("numeroMarce") Integer numeroMarce,
	        @Param("pieghevole") Boolean pieghevole,
	        @Param("sospensione") String sospensione,
	        @Param("freno") String freno
	);
}
