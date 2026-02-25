package com.betacom.jpa.repositories.lookup;

import com.betacom.jpa.models.lookup.TipoVeicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipoVeicoloRepository extends JpaRepository<TipoVeicolo, Integer> {
    Optional<TipoVeicolo> findByDescrizione(String descrizione);
    boolean existsByDescrizione(String descrizione);
}
