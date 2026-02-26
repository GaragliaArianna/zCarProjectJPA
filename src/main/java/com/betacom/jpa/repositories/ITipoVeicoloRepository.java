package com.betacom.jpa.repositories;

import com.betacom.jpa.models.TipoVeicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ITipoVeicoloRepository extends JpaRepository<TipoVeicolo, Integer> {

}
