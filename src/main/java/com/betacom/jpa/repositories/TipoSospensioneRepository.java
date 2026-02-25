package com.betacom.jpa.repositories.lookup;

import com.betacom.jpa.models.lookup.TipoSospensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TipoSospensioneRepository extends JpaRepository<TipoSospensione, Integer> {
    Optional<TipoSospensione> findByDescrizione(String descrizione);
    boolean existsByDescrizione(String descrizione);
}
