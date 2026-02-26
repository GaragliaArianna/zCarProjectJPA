package com.betacom.jpa.repositories;

import com.betacom.jpa.models.TipoSospensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ITipoSospensioneRepository extends JpaRepository<TipoSospensione, Integer> {

}
