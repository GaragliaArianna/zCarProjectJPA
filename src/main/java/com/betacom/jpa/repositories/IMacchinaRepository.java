package com.betacom.jpa.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Macchina;



@Repository
public interface IMacchinaRepository extends JpaRepository<Macchina, Integer>{

	 boolean existsByTarga(String targa);
	 /*
	 @Query("""
		       select m
		       from Macchina m
		       left join m.categoria c
		       left join m.colore col
		       left join m.marca mar
		       left join m.alimentazione ali
		       left join m.tipoVeicolo tv
		       where (:id is null or m.id = :id)
		       and (:targa is null or m.targa like concat(:targa, '%'))
		       and (:numeroPorte is null or m.numeroPorte = :numeroPorte)
		       and (:cc is null or m.cc = :cc)
		       and (:categoria is null or c.id = :categoria)
		       and (:colore is null or col.id = :colore)
		       and (:marca is null or mar.id = :marca)
		       and (:alimentazione is null or ali.id = :alimentazione)
		       and (:tipoVeicolo is null or tv.id = :tipoVeicolo)
		       """)
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
