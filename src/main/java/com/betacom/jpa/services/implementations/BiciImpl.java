package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.dto.outputs.TipoFrenoDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.Marca;
import com.betacom.jpa.models.TipoFreno;
import com.betacom.jpa.models.TipoSospensione;
import com.betacom.jpa.models.TipoVeicolo;
import com.betacom.jpa.services.interfaces.IBiciServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;
import com.betacom.jpa.utils.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.betacom.jpa.repositories.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class BiciImpl implements IBiciServices{
	
	private final IBiciRepository biciR;
	private final IMessaggioServices msgS;
	private final ITipoFrenoRepository tipoFrenoR;
	
    private final ITipoVeicoloRepository tipoVeicoloRepo;
    private final IMarcaRepository marcaRepo;
    private final IAlimentazioneRepository alimentazioneRepo;
    private final IColoreRepository coloreRepo;
    private final ICategoriaRepository categoriaRepo;
    
    private final ITipoSospensioneRepository sospensioneRepo;
	//private final ITipoSospensioneRepository tipoSospensioneR;

	@Transactional (rollbackFor = AcademyException.class)
	@Override
	public Integer create(BiciReq req) throws AcademyException {

		log.debug("create {}", req);
			if (req.getNumeroMarce()== null)
				throw new AcademyException("Numero marce non caricato");
			if (req.getIdTipoFreno ()== null)
				throw new AcademyException("Id tipo freno non caricato");
			if (req.getIdTipoSospensione()== null)
				throw new AcademyException("Id tipo sospensione non caricato");
			if (req.getPiegevole()== null)
				throw new AcademyException("Attributo pieghevole non caricato");
			if (req.getNumeroRuote()== null)
				throw new AcademyException("Numero ruote non caricato");			
			if (req.getIdTipoVeicolo()== null)
				throw new AcademyException("Id tipo veicolo non caricato");
			if (req.getIdCategoria()== null)
				throw new AcademyException("Id categoria non caricato");
			if (req.getIdTipoAlimentazione()== null)
				throw new AcademyException("Id tipo alimentazione non caricato");
			if (req.getIdTipoAlimentazione()== null)
				throw new AcademyException("Id tipo alimentazione non caricato");
			if (req.getIdColore()== null)
				throw new AcademyException("Id colore non caricato");
			if (req.getIdMarca()== null)
				throw new AcademyException("Id marca non caricato");
			if (req.getModello()== null)
				throw new AcademyException("Modello non caricato");
			if (req.getAnnoProduzione()== null)
				throw new AcademyException("Anno di produzione non caricato");
			
			
			TipoFreno tf = tipoFrenoR.findById(req.getIdTipoFreno())
		            .orElseThrow(() -> new AcademyException("Tipo freno non trovato"));

		    TipoSospensione ts = sospensioneRepo.findById(req.getIdTipoSospensione())
		            .orElseThrow(() -> new AcademyException("Tipo sospensione non trovata"));

		    TipoVeicolo tv = tipoVeicoloRepo.findById(req.getIdTipoVeicolo())
		            .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato"));

		    Categoria cat = categoriaRepo.findById(req.getIdCategoria())
		            .orElseThrow(() -> new AcademyException("Categoria non trovata"));

		    Alimentazione ta = alimentazioneRepo.findById(req.getIdTipoAlimentazione())
		            .orElseThrow(() -> new AcademyException("Tipo alimentazione non trovato"));

		    Colore col = coloreRepo.findById(req.getIdColore())
		            .orElseThrow(() -> new AcademyException("Colore non trovato"));

		    Marca marca = marcaRepo.findById(req.getIdMarca())
		            .orElseThrow(() -> new AcademyException("Marca non trovata"));
		    
		    
			
			
			Bici bici = new Bici();
			
			
		    // ---- campi Bici ----
		    bici.setNumeroMarce(req.getNumeroMarce());
		    bici.setTipoFreno(tf);
		    bici.setTipoSospensione(ts);
		    bici.setPiegevole(req.getPiegevole());
		    
		    
		    // ---- campi Veicolo ----
		    bici.setNumeroRuote(req.getNumeroRuote());
		    bici.setTipoVeicolo(tv);
		    bici.setCategoria(cat);
		  //  bici.setTipoAlimentazione(ta);
		    bici.setColore(col);
		    bici.setMarca(marca);
		    bici.setModello(req.getModello());
		    bici.setAnnoProduzione(req.getAnnoProduzione());
			
			return biciR.save(bici).getId();
			
		}

	

	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void update(Integer id, BiciReq req) throws AcademyException {
	    log.debug("update {}", req);

	    Bici bici = biciR.findById(id)
	            .orElseThrow(() -> new AcademyException("Bici non trovata: " + id));

	    // ===== CAMPI BICI =====
	    if (req.getNumeroMarce() != null)
	        bici.setNumeroMarce(req.getNumeroMarce());

	    if (req.getPiegevole() != null)
	        bici.setPiegevole(req.getPiegevole());

	    if (req.getIdTipoFreno() != null) {
	        TipoFreno tf = tipoFrenoR.findById(req.getIdTipoFreno())
	                .orElseThrow(() -> new AcademyException("Tipo freno non trovato"));
	        bici.setTipoFreno(tf);
	    }

	    if (req.getIdTipoSospensione() != null) {
	        TipoSospensione ts = sospensioneRepo.findById(req.getIdTipoSospensione())
	                .orElseThrow(() -> new AcademyException("Tipo sospensione non trovata"));
	        bici.setTipoSospensione(ts);
	    }

	    // ===== CAMPI VEICOLO (EREDITATI) =====
	    if (req.getNumeroRuote() != null)
	        bici.setNumeroRuote(req.getNumeroRuote());

	    if (req.getIdTipoVeicolo() != null) {
	        TipoVeicolo tv = tipoVeicoloRepo.findById(req.getIdTipoVeicolo())
	                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato"));
	        bici.setTipoVeicolo(tv);
	    }

	    if (req.getIdCategoria() != null) {
	        Categoria cat = categoriaRepo.findById(req.getIdCategoria())
	                .orElseThrow(() -> new AcademyException("Categoria non trovata"));
	        bici.setCategoria(cat);
	    }

	    if (req.getIdTipoAlimentazione() != null) {
	        Alimentazione ta = alimentazioneRepo.findById(req.getIdTipoAlimentazione())
	                .orElseThrow(() -> new AcademyException("Tipo alimentazione non trovata"));
	        bici.setAlimentazione(ta);
	    }

	    if (req.getIdColore() != null) {
	        Colore col = coloreRepo.findById(req.getIdColore())
	                .orElseThrow(() -> new AcademyException("Colore non trovato"));
	        bici.setColore(col);
	    }

	    if (req.getIdMarca() != null) {
	        Marca marca = marcaRepo.findById(req.getIdMarca())
	                .orElseThrow(() -> new AcademyException("Marca non trovata"));
	        bici.setMarca(marca);
	    }

	    if (req.getModello() != null)
	        bici.setModello(req.getModello());

	    if (req.getAnnoProduzione() != null)
	        bici.setAnnoProduzione(req.getAnnoProduzione());

	    // ===== SAVE =====
	    biciR.save(bici);
	}
	
	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void delete(Integer id) throws AcademyException {
		   log.debug("delete bici {}", id);

		    // Recupero la bici dal DB
		    Bici bici = biciR.findById(id)
		            .orElseThrow(() -> new AcademyException("Bici non trovata"));

		    // Elimino la bici
		    biciR.delete(bici);

		    log.debug("bici {} eliminata correttamente", id);
		}

	@Override
	public BiciDTO findById(Integer id) throws AcademyException {
	    log.debug("findById {}", id);

	    Bici b = biciR.findById(id)
	            .orElseThrow(() -> new AcademyException("Bici non trovata: " + id));

	    return Mapper.buildBiciDTO(b); // qui usi il mapper
	}
	

	@Override
	public List<BiciDTO> findAll() throws AcademyException {
	    log.debug("findAll");

	    List<Bici> lB = biciR.findAll();

	    return Mapper.buildBiciDTO(lB); // mapper trasforma automaticamente la lista
	}
}

