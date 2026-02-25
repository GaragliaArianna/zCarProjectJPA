package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Abbonamento;
import com.betacom.jpa.models.Bici;

@Repository
public interface IBiciRepository extends JpaRepository<Bici, Integer>{

}
