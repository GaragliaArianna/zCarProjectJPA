package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.*;
import com.betacom.jpa.repositories.*;
import com.betacom.jpa.services.interfaces.IBiciServices;
import com.betacom.jpa.utils.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BiciImpl implements IBiciServices {

    private final IBiciRepository biciR;

    private final ITipoFrenoRepository tipoFrenoR;
    private final ITipoSospensioneRepository sospensioneRepo;
    private final ITipoVeicoloRepository tipoVeicoloRepo;
    private final ICategoriaRepository categoriaRepo;
    private final IAlimentazioneRepository alimentazioneRepo;
    private final IColoreRepository coloreRepo;
    private final IMarcaRepository marcaRepo;

    // =====================================================
    // CREATE
    // =====================================================
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public Integer create(BiciReq req) throws AcademyException {

        log.debug("create {}", req);

        checkNull(req);

        TipoFreno tf = tipoFrenoR.findById(req.getIdTipoFreno())
                .orElseThrow(() -> new AcademyException("Tipo freno non trovato"));

        TipoSospensione ts = sospensioneRepo.findById(req.getIdTipoSospensione())
                .orElseThrow(() -> new AcademyException("Tipo sospensione non trovata"));

        TipoVeicolo tv = tipoVeicoloRepo.findById(req.getIdTipoVeicolo())
                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato"));

        Categoria cat = categoriaRepo.findById(req.getIdCategoria())
                .orElseThrow(() -> new AcademyException("Categoria non trovata"));

        Alimentazione ta = alimentazioneRepo.findById(req.getIdTipoAlimentazione())
                .orElseThrow(() -> new AcademyException("Alimentazione non trovata"));

        Colore col = coloreRepo.findById(req.getIdColore())
                .orElseThrow(() -> new AcademyException("Colore non trovato"));

        Marca marca = marcaRepo.findById(req.getIdMarca())
                .orElseThrow(() -> new AcademyException("Marca non trovata"));

        // ===== CREAZIONE BICI =====
        Bici bici = new Bici();

        // ---- VEICOLO ----
        bici.setNumeroRuote(req.getNumeroRuote());
        bici.setTipoVeicolo(tv);
        bici.setCategoria(cat);
        bici.setAlimentazione(ta);
        bici.setColore(col);
        bici.setMarca(marca);
        bici.setModello(req.getModello());
        bici.setAnnoProduzione(req.getAnnoProduzione());

        // ---- BICI ----
        bici.setNumeroMarce(req.getNumeroMarce());
        bici.setPieghevole(req.getPieghevole());
        bici.setTipoFreno(tf);
        bici.setTipoSospensione(ts);

        return biciR.save(bici).getId();
    }

    // =====================================================
    // UPDATE
    // =====================================================
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void update(Integer id, BiciReq req) throws AcademyException {

        log.debug("update {}", id);

        Bici bici = biciR.findById(id)
                .orElseThrow(() -> new AcademyException("Bici non trovata"));

        if (req.getNumeroMarce() != null)
            bici.setNumeroMarce(req.getNumeroMarce());

        if (req.getPieghevole() != null)
            bici.setPiegevole(req.getPieghevole());

        if (req.getNumeroRuote() != null)
            bici.setNumeroRuote(req.getNumeroRuote());

        if (req.getModello() != null)
            bici.setModello(req.getModello());

        if (req.getAnnoProduzione() != null)
            bici.setAnnoProduzione(req.getAnnoProduzione());

        if (req.getIdTipoFreno() != null)
            bici.setTipoFreno(
                    tipoFrenoR.findById(req.getIdTipoFreno())
                            .orElseThrow(() -> new AcademyException("Tipo freno non trovato"))
            );

        if (req.getIdTipoSospensione() != null)
            bici.setTipoSospensione(
                    sospensioneRepo.findById(req.getIdTipoSospensione())
                            .orElseThrow(() -> new AcademyException("Tipo sospensione non trovata"))
            );

        if (req.getIdTipoVeicolo() != null)
            bici.setTipoVeicolo(
                    tipoVeicoloRepo.findById(req.getIdTipoVeicolo())
                            .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato"))
            );

        if (req.getIdCategoria() != null)
            bici.setCategoria(
                    categoriaRepo.findById(req.getIdCategoria())
                            .orElseThrow(() -> new AcademyException("Categoria non trovata"))
            );

        if (req.getIdTipoAlimentazione() != null)
            bici.setAlimentazione(
                    alimentazioneRepo.findById(req.getIdTipoAlimentazione())
                            .orElseThrow(() -> new AcademyException("Alimentazione non trovata"))
            );

        if (req.getIdColore() != null)
            bici.setColore(
                    coloreRepo.findById(req.getIdColore())
                            .orElseThrow(() -> new AcademyException("Colore non trovato"))
            );

        if (req.getIdMarca() != null)
            bici.setMarca(
                    marcaRepo.findById(req.getIdMarca())
                            .orElseThrow(() -> new AcademyException("Marca non trovata"))
            );

        biciR.save(bici);
    }

    // =====================================================
    // DELETE
    // =====================================================
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void delete(Integer id) throws AcademyException {

        Bici bici = biciR.findById(id)
                .orElseThrow(() -> new AcademyException("Bici non trovata"));

        biciR.delete(bici);
    }

    // ====================================================
    // FIND BY ID
    // ====================================================
    @Override
    public BiciDTO findById(Integer id) throws AcademyException {

        Bici bici = biciR.findById(id)
                .orElseThrow(() -> new AcademyException("Bici non trovata"));

        return Mapper.buildBiciDTO(bici);
    }

    // =====================================================
    // FIND ALL
    // =====================================================
    @Override
    public List<BiciDTO> findAll() throws AcademyException {
        return Mapper.buildBiciDTO(biciR.findAll());
    }

    // =====================================================
    // VALIDAZIONE
    // =====================================================
    private void checkNull(BiciReq req) throws AcademyException {

        if (req.getNumeroMarce() == null)
            throw new AcademyException("Numero marce non caricato");

        if (req.getPieghevole() == null)
            throw new AcademyException("Pieghevole non caricato");

        if (req.getNumeroRuote() == null)
            throw new AcademyException("Numero ruote non caricato");

        if (req.getIdTipoFreno() == null ||
            req.getIdTipoSospensione() == null ||
            req.getIdTipoVeicolo() == null ||
            req.getIdCategoria() == null ||
            req.getIdTipoAlimentazione() == null ||
            req.getIdColore() == null ||
            req.getIdMarca() == null)
            throw new AcademyException("Campi FK mancanti");

        if (req.getModello() == null)
            throw new AcademyException("Modello non caricato");

        if (req.getAnnoProduzione() == null)
            throw new AcademyException("Anno produzione non caricato");
    }
}
