package com.betacom.jpa.utils;

import com.betacom.jpa.models.*;
import com.betacom.jpa.repositories.*;
import com.betacom.jpa.dto.input.VeicoloReq;
import com.betacom.jpa.exceptions.AcademyException;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class VeicoloUtils {

    private final ITipoVeicoloRepository tipoVeicoloRepo;
    private final IMarcaRepository marcaRepo;
    private final IAlimentazioneRepository alimentazioneRepo;
    private final IColoreRepository coloreRepo;
    private final ICategoriaRepository categoriaRepo;

    public VeicoloUtils(ITipoVeicoloRepository tipoVeicoloRepo,
                        IMarcaRepository marcaRepo,
                        IAlimentazioneRepository alimentazioneRepo,
                        IColoreRepository coloreRepo,
                        ICategoriaRepository categoriaRepo) {
        this.tipoVeicoloRepo = tipoVeicoloRepo;
        this.marcaRepo = marcaRepo;
        this.alimentazioneRepo = alimentazioneRepo;
        this.coloreRepo = coloreRepo;
        this.categoriaRepo = categoriaRepo;
    }

    @Transactional(rollbackFor = AcademyException.class)
    public Veicolo buildVeicoloFromReq(VeicoloReq req) throws AcademyException {
    	/*
        Veicolo veicolo = new Veicolo();

        if (req.getIdTipoVeicolo() == null)
            throw new AcademyException("Tipo veicolo non caricato");
        veicolo.setTipoVeicolo(tipoVeicoloRepo.findById(req.getIdTipoVeicolo())
                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato")));

        if (req.getIdMarca() == null)
            throw new AcademyException("Marca non caricata");
        veicolo.setMarca(marcaRepo.findById(req.getIdMarca())
                .orElseThrow(() -> new AcademyException("Marca non trovata")));

        if (req.getIdTipoAlimentazione() == null)
            throw new AcademyException("Alimentazione non caricata");
        veicolo.setAlimentazione(alimentazioneRepo.findById(req.getIdTipoAlimentazione())
                .orElseThrow(() -> new AcademyException("Alimentazione non trovata")));

        if (req.getIdColore() == null)
            throw new AcademyException("Colore non caricato");
        veicolo.setColore(coloreRepo.findById(req.getIdColore())
                .orElseThrow(() -> new AcademyException("Colore non trovato")));

        if (req.getIdCategoria() == null)
            throw new AcademyException("Categoria non caricata");
        veicolo.setCategoria(categoriaRepo.findById(req.getIdCategoria())
                .orElseThrow(() -> new AcademyException("Categoria non trovata")));
        
        
        if (req.getAnnoProduzione() == null)
            throw new AcademyException("Anno di produzione non caricato");
        int anno = req.getAnnoProduzione().getYear();
        int annoOggi = java.time.LocalDate.now().getYear();
        if (anno < 1970 || anno > annoOggi)
            throw new AcademyException("Anno di produzione non valido. Deve essere tra 1970 e " + annoOggi);

        if (req.getNumeroRuote() == null)
            throw new AcademyException("Numero ruote non caricato");
        if (req.getNumeroRuote() < 2 || req.getNumeroRuote() > 10)
            throw new AcademyException("Numero ruote non valido. Deve essere tra 2 e 10");

        veicolo.setModello(req.getModello());
   
        checkAnnoProduzione(req.getAnnoProduzione());
        veicolo.setAnnoProduzione(req.getAnnoProduzione());

        checkNumeroRuote(req.getNumeroRuote());
        veicolo.setNumeroRuote(req.getNumeroRuote());

        return veicolo;*/
        return null;
    }
    private void checkNotNull(Object value, String msg) throws AcademyException {
        if (value == null) throw new AcademyException(msg);
    }

    private int checkAnnoProduzione(LocalDate data) throws AcademyException {
        checkNotNull(data, "Anno di produzione non caricato");
        int anno = data.getYear();
        int annoOggi = LocalDate.now().getYear();
        if (anno < 1970 || anno > annoOggi)
            throw new AcademyException("Anno di produzione non valido. Deve essere tra 1970 e " + annoOggi);
        return anno;
    }

    private int checkNumeroRuote(Integer ruote) throws AcademyException {
        checkNotNull(ruote, "Numero ruote non caricato");
        if (ruote < 2 || ruote > 10)
            throw new AcademyException("Numero ruote non valido. Deve essere tra 2 e 10");
        return ruote;
    }
}