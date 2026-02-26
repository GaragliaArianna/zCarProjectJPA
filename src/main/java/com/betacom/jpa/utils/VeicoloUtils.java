package com.betacom.jpa.utils;

import com.betacom.jpa.models.*;
import com.betacom.jpa.repositories.*;
import com.betacom.jpa.dto.input.VeicoloReq;
import com.betacom.jpa.exceptions.AcademyException;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class VeicoloUtils {

    private final ITipoVeicoloRepository tipoVeicoloRepo;
    private final IMarcaRepository marcaRepo;
    private final IAlimentazioneRepository alimentazioneRepo;
    private final IColoreRepository coloreRepo;
    private final ICategoriaRepository categoriaRepo;
    
    private static final int MIN_NUM_RUOTE=2;
    private static final int MAX_NUM_RUOTE=6;
    
    private static final int MIN_ANNO=1970;

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

    private void checkNotNull(Object value, String msg) throws AcademyException {
        if (value == null) throw new AcademyException(msg);
    }

    private int checkAnnoProduzione(LocalDate data) throws AcademyException {
        checkNotNull(data, "Anno di produzione non caricato");
        int anno = data.getYear();
        int annoOggi = LocalDate.now().getYear();
        if (anno < MIN_ANNO || anno > annoOggi)
            throw new AcademyException("Anno di produzione non valido. Deve essere tra "+ MIN_ANNO + " e " + annoOggi);
        return anno;
    }

    private int checkNumeroRuote(Integer ruote) throws AcademyException {
        checkNotNull(ruote, "Numero ruote non caricato");
        if (ruote < MIN_NUM_RUOTE || ruote > MAX_NUM_RUOTE)
        	throw new AcademyException("Numero porte non valido. Deve essere tra "+ MIN_NUM_RUOTE+ " e "+  MAX_NUM_RUOTE);
        return ruote;
    }

    @Transactional(rollbackFor = AcademyException.class)
    public <T extends Veicolo> T buildVeicoloFromReq(T veicolo, VeicoloReq req) throws AcademyException {


        veicolo.setTipoVeicolo(tipoVeicoloRepo.findById(
                checkNotNullReturn(req.getIdTipoVeicolo(), "Tipo veicolo non caricato"))
                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato")));

        veicolo.setMarca(marcaRepo.findById(
                checkNotNullReturn(req.getIdMarca(), "Marca non caricata"))
                .orElseThrow(() -> new AcademyException("Marca non trovata")));

        veicolo.setAlimentazione(alimentazioneRepo.findById(
                checkNotNullReturn(req.getIdTipoAlimentazione(), "Alimentazione non caricata"))
                .orElseThrow(() -> new AcademyException("Alimentazione non trovata")));

        veicolo.setColore(coloreRepo.findById(
                checkNotNullReturn(req.getIdColore(), "Colore non caricato"))
                .orElseThrow(() -> new AcademyException("Colore non trovato")));

        veicolo.setCategoria(categoriaRepo.findById(
                checkNotNullReturn(req.getIdCategoria(), "Categoria non caricata"))
                .orElseThrow(() -> new AcademyException("Categoria non trovata")));

        // controlli su anno, numero ruote e modello
        veicolo.setAnnoProduzione(req.getAnnoProduzione());
        checkAnnoProduzione(req.getAnnoProduzione());

        veicolo.setNumeroRuote(req.getNumeroRuote());
        checkNumeroRuote(req.getNumeroRuote());

        checkNotNull(req.getModello(), "Modello non caricato");
        veicolo.setModello(req.getModello());

        return veicolo;
    }

    // metodo helper per usare checkNotNull sui Long/Integer ID
    private Integer checkNotNullReturn(Integer value, String msg) throws AcademyException {
        checkNotNull(value, msg);
        return value;
    }
    
    @Transactional(rollbackFor = AcademyException.class)
    public <T extends Veicolo> void updateVeicoloFromReq(T veicolo, VeicoloReq req) 
            throws AcademyException {


        if (req.getAnnoProduzione() != null) {
            checkAnnoProduzione(req.getAnnoProduzione());  // controlla validità anno
            veicolo.setAnnoProduzione(req.getAnnoProduzione());
        }

      
        if (req.getNumeroRuote() != null) {
            checkNumeroRuote(req.getNumeroRuote());  // controlla validità numero ruote
            veicolo.setNumeroRuote(req.getNumeroRuote());
        }


        if (req.getModello() != null) {
            checkNotNull(req.getModello(), "Modello non valido");
            veicolo.setModello(req.getModello());
        }

 
        if (req.getIdMarca() != null) {
            veicolo.setMarca(
                    marcaRepo.findById(req.getIdMarca())
                            .orElseThrow(() -> new AcademyException("Marca non trovata"))
            );
        }

        if (req.getIdTipoAlimentazione() != null) {
            veicolo.setAlimentazione(
                    alimentazioneRepo.findById(req.getIdTipoAlimentazione())
                            .orElseThrow(() -> new AcademyException("Alimentazione non trovata"))
            );
        }

        if (req.getIdColore() != null) {
            veicolo.setColore(
                    coloreRepo.findById(req.getIdColore())
                            .orElseThrow(() -> new AcademyException("Colore non trovato"))
            );
        }

        if (req.getIdCategoria() != null) {
            veicolo.setCategoria(
                    categoriaRepo.findById(req.getIdCategoria())
                            .orElseThrow(() -> new AcademyException("Categoria non trovata"))
            );
        }

    }
    

}


