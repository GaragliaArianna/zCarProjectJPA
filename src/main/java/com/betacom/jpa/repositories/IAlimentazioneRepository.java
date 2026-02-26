package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Alimentazione;

@Repository
public interface IAlimentazioneRepository extends JpaRepository<Alimentazione, Integer>{
	
}
