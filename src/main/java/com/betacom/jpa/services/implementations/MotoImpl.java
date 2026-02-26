package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.outputs.MotoDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Marca;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.models.TipoVeicolo;
import com.betacom.jpa.repositories.IAlimentazioneRepository;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.repositories.IMarcaRepository;
import com.betacom.jpa.repositories.IMotoRepository;
import com.betacom.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.jpa.services.interfaces.IMessaggioServices;
import com.betacom.jpa.services.interfaces.IMotoServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MotoImpl implements IMotoServices {

    private final ITipoVeicoloRepository tipoVeicoloR;
    private final ICategoriaRepository categoriaR;
    private final IAlimentazioneRepository alimentazioneR;
    private final IColoreRepository coloreR;
    private final IMarcaRepository marcaR;
    private final IMotoRepository motoR;
    final IMessaggioServices msgS;

    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public Integer create(MotoReq req) throws AcademyException {
        log.debug("create {}", req);
        if (req.getTarga() == null)
            throw new AcademyException("Targa moto non caricata!");
        if (req.getCc() == null)
            throw new AcademyException("Cilindrata non specificata!");

        Optional<Moto> m = motoR.findByTarga(req.getTarga());
        if (m.isPresent())
            throw new AcademyException("Targa " + req.getTarga() + " già presente!");

        Marca marca = marcaR.findById(req.getIdMarca())
                .orElseThrow(() -> new AcademyException("Marca non trovata!"));
        Colore colore = coloreR.findById(req.getIdColore())
                .orElseThrow(() -> new AcademyException("Colore non trovato!"));
        Alimentazione alimentazione = alimentazioneR.findById(req.getIdTipoAlimentazione())
                .orElseThrow(() -> new AcademyException("Alimentazione non trovata!"));
        Categoria categoria = categoriaR.findById(req.getIdCategoria())
                .orElseThrow(() -> new AcademyException("Categoria non trovata!"));
        TipoVeicolo tipoVeicolo = tipoVeicoloR.findById(req.getIdTipoVeicolo())
                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato!"));

<<<<<<< HEAD
        Moto mot = new Moto();
        mot.setCc(req.getCc());
        mot.setTarga(req.getTarga());
        mot.setMarca(marca);
        mot.setColore(colore);
        mot.setAlimentazione(alimentazione);
        mot.setCategoria(categoria);
        mot.setTipoVeicolo(tipoVeicolo);
        mot.setModello(req.getModello());
        mot.setNumeroRuote(req.getNumeroRuote());
        mot.setAnnoProduzione(req.getAnnoProduzione());

        return motoR.save(mot).getId();
    }

    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void update(MotoReq req) throws AcademyException {
        log.debug("update {}", req);
        Moto m = motoR.findById(req.getId())
                .orElseThrow(() -> new AcademyException("Moto non trovata!"));

        if (req.getCc() != null)
            m.setCc(req.getCc());

        if (req.getTarga() != null) {
            Optional<Moto> targaEsistente = motoR.findByTarga(req.getTarga());
            if (targaEsistente.isPresent() && !targaEsistente.get().getId().equals(m.getId()))
                throw new AcademyException("Targa " + req.getTarga() + " già presente!");
            m.setTarga(req.getTarga());
        }

        if (req.getIdMarca() != null)
            m.setMarca(marcaR.findById(req.getIdMarca())
                    .orElseThrow(() -> new AcademyException("Marca non trovata!")));

        if (req.getIdColore() != null)
            m.setColore(coloreR.findById(req.getIdColore())
                    .orElseThrow(() -> new AcademyException("Colore non trovato!")));

        if (req.getIdTipoAlimentazione() != null)
            m.setAlimentazione(alimentazioneR.findById(req.getIdTipoAlimentazione())
                    .orElseThrow(() -> new AcademyException("Alimentazione non trovata!")));

        if (req.getIdCategoria() != null)
            m.setCategoria(categoriaR.findById(req.getIdCategoria())
                    .orElseThrow(() -> new AcademyException("Categoria non trovata!")));

        if (req.getIdTipoVeicolo() != null)
            m.setTipoVeicolo(tipoVeicoloR.findById(req.getIdTipoVeicolo())
                    .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato!")));

        if (req.getModello() != null)
            m.setModello(req.getModello());

        if (req.getNumeroRuote() != null)
            m.setNumeroRuote(req.getNumeroRuote());

        if (req.getAnnoProduzione() != null)
            m.setAnnoProduzione(req.getAnnoProduzione());

        motoR.save(m);
    }

    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void delete(Integer id) throws AcademyException {
        log.debug("delete {}", id);
        Moto m = motoR.findById(id)
                .orElseThrow(() -> new AcademyException("Moto non trovata!"));
        motoR.delete(m);
    }

    @Override
    public MotoDTO findById(Integer id) throws Exception {
        log.debug("findById: {}", id);
        Moto m = motoR.findById(id)
                .orElseThrow(() -> new AcademyException("Moto con id: " + id + " non trovata!"));
        return buildMotoDTO(m);
    }

    @Override
    public List<MotoDTO> findAll() throws AcademyException {
        log.debug("findAll");
        return motoR.findAll().stream()
                .map(this::buildMotoDTO)
                .toList();
    }

    private MotoDTO buildMotoDTO(Moto m) {
        return MotoDTO.builder()
                .id(m.getId())
                .targa(m.getTarga())
                .cc(m.getCc())
                .idVeicolo(m.getId())
                .numeroRuote(m.getNumeroRuote())
                .tipoVeicolo(m.getTipoVeicolo() != null ? m.getTipoVeicolo().getVeicolo() : null)
                .categoria(m.getCategoria() != null ? m.getCategoria().getCategoria() : null)
                .tipoAlimentazione(m.getAlimentazione() != null ? m.getAlimentazione().getAlimentazione() : null)
                .colore(m.getColore() != null ? m.getColore().getColore() : null)
                .marca(m.getMarca() != null ? m.getMarca().getMarca() : null)
                .modello(m.getModello())
                .annoProduzione(m.getAnnoProduzione())
                .build();
    }
}
=======
	    return lM.stream()
	            .map(m -> (MotoDTO) MotoDTO.builder()
	                    .id(m.getId())
	                    .targa(m.getTarga())
	                    .cc(m.getCc())
	                    .build()
	            )
	            .toList();
	}

		@Override
	public List<MotoDTO> find(Integer id, String targa, Integer cc, String categoria, String colore, String marca,
			String alimentazione, String tipoVeicolo) throws AcademyException {
		List<Moto> lM = motoR.searchByFilter(id, targa, cc, categoria, 
				colore, marca, alimentazione, tipoVeicolo);
		return lM.stream()
		        .map(m -> MotoDTO.builder()
		                .idVeicolo(m.getId())
		                .annoProduzione(m.getAnnoProduzione())
		                .categoria(m.getCategoria() != null ? m.getCategoria().getCategoria() : null)
		                .cc(m.getCc())
		                .colore(m.getColore() != null ? m.getColore().getColore() : null)
		                .marca(m.getMarca() != null ? m.getMarca().getMarca() : null)
		                .modello(m.getModello())
		                .numeroRuote(m.getNumeroRuote())
		                .targa(m.getTarga())
		                .tipoAlimentazione(m.getAlimentazione() != null ? m.getAlimentazione().getAlimentazione() : null)
		                .tipoVeicolo(m.getTipoVeicolo() != null ? m.getTipoVeicolo().getVeicolo() : null)
		                .build())
		        .collect(Collectors.toList());
		
	}
}
>>>>>>> acfc9c566269455062750664fedf876e9d360807
