package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Macchina;



@Repository
public interface IMacchinaRepository extends JpaRepository<Macchina, Integer>{

	 boolean existsByTarga(String targa);
	 /*
	 @Query(name = "macchina.selectByFilter")
		List<Macchina> searchByFilter(
		       @Param("id") Integer id,
		       @Param("targa") String targa,
		       @Param("numeroPorte") Integer numeroPorte,
		       @Param("cc") Integer cc,
		       @Param("categoria") String categoria,
		       @Param("colore") String colore,
		       @Param("marca") String marca,
		       @Param("alimentazione") String alimentazione,
		       @Param("tipoVeicolo") String tipoVeicolo
		);*/
	 
}
