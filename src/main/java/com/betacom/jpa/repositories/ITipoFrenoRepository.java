package com.betacom.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.TipoFreno;

@Repository
public interface ITipoFrenoRepository extends JpaRepository<TipoFreno, Integer>{

}
