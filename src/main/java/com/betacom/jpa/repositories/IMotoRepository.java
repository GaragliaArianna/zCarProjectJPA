package com.betacom.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import com.betacom.jpa.models.Moto;

@Repository
public interface IMotoRepository extends JpaRepository<Moto, Integer>{

	Optional<Moto> findByTarga(String targa);

	@Query(name="moto.selectByFilter")
	List<Moto> searchByFilter(
		       @Param("id") Integer id,
		       @Param("targa") String targa,
		       @Param("cc") Integer cc,
		       @Param("categoria") String categoria,
		       @Param("colore") String colore,
		       @Param("marca") String marca,
		       @Param("alimentazione") String alimentazione,
		       @Param("tipoVeicolo") String tipoVeicolo
		);
	
}
  