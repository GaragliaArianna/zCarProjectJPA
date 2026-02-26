package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.controllers.AlimentazioneController;
import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.outputs.ColoreDTO;
import com.betacom.jpa.dto.outputs.MacchinaDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.TipoVeicolo;
import com.betacom.jpa.repositories.IMacchinaRepository;

import com.betacom.jpa.services.interfaces.IMacchinaServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;
import com.betacom.jpa.utils.Mapper;
import com.betacom.jpa.utils.VeicoloUtils;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MacchinaImpl implements IMacchinaServices{

    private final AlimentazioneController alimentazioneController;
	private final IMacchinaRepository macchinaR;

	private final IMessaggioServices msgS;
	
	private final VeicoloUtils veicoloUtils;

    private static final int MIN_NUM_PORTE=2;
    private static final int MAX_NUM_PORTE=4;
    
	
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public Integer create(MacchinaReq req) throws AcademyException {

        log.debug("create Macchina {}", req);
   
        if (req.getTarga() == null || req.getTarga().isBlank())
            throw new AcademyException("Targa non caricata");

        if (macchinaR.existsByTarga(req.getTarga()))
            throw new AcademyException("Targa già presente: " + req.getTarga());

 
        Macchina macchina = new Macchina();
        try {
            veicoloUtils.buildVeicoloFromReq(macchina, req);
        } catch (Exception e) {
            log.error("Errore in veicoloUtils.buildVeicoloFromReq: {}", e.getMessage(), e);
            throw e; 
        }
        
        log.debug("Macchina da salvare: {}", macchina);

        if (req.getCc() == null)
            throw new AcademyException("Cilindrata non caricata");

 
        macchina.setNumeroPorte(req.getNumeroPorte());
        checkNumeroPorte(req.getNumeroPorte());
        
        macchina.setCc(req.getCc());
        macchina.setTarga(req.getTarga());

        return macchinaR.save(macchina).getId();
    }
    
    private int checkNumeroPorte(Integer porte) throws AcademyException {
        if (porte == null)
            throw new AcademyException("Numero porte non caricato");
        if (porte < MIN_NUM_PORTE || porte > MAX_NUM_PORTE)
            throw new AcademyException("Numero porte non valido. Deve essere tra "+ MIN_NUM_PORTE+ " e "+  MAX_NUM_PORTE);
        return porte;
    }
    
	@Override
	public void update(MacchinaReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void delete(Integer id) throws AcademyException {
		   log.debug("delete macchina {}", id);

		    Macchina macchina = macchinaR.findById(id)
		            .orElseThrow(() -> new AcademyException("Macchina non trovata"));

		    macchinaR.delete(macchina);

		    log.debug("macchina {} eliminata correttamente", id);
		}

	@Override
	public MacchinaDTO findById(Integer id) throws AcademyException {
	    log.debug("findById {}", id);

	    Macchina m = macchinaR.findById(id)
	            .orElseThrow(() -> new AcademyException("Macchina non trovata: " + id));

	    return Mapper.buildMacchinaDTO(m);
	}

	@Override
	public List<MacchinaDTO> findAll() throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	@Override
	public List<MacchinaDTO> find(Integer id, String targa, Integer numeroPorte, Integer cc, String categoria,
			String colore, String marca, String alimentazione, String tipoVeicolo) throws AcademyException {
		List<Macchina> lM = macchinaR.searchByFilter(id, targa, numeroPorte, cc, categoria, 
				colore, marca, alimentazione, tipoVeicolo);
		return lM.stream()
		        .map(m -> MacchinaDTO.builder()
		                .idVeicolo(m.getId())
		                .annoProduzione(m.getAnnoProduzione())
		                .categoria(m.getCategoria() != null ? m.getCategoria().getCategoria() : null)
		                .cc(m.getCc())
		                .colore(m.getColore() != null ? m.getColore().getColore() : null)
		                .marca(m.getMarca() != null ? m.getMarca().getMarca() : null)
		                .modello(m.getModello())
		                .numeroPorte(m.getNumeroPorte())
		                .numeroRuote(m.getNumeroRuote())
		                .targa(m.getTarga())
		                .tipoAlimentazione(m.getAlimentazione() != null ? m.getAlimentazione().getAlimentazione() : null)
		                .tipoVeicolo(m.getTipoVeicolo() != null ? m.getTipoVeicolo().getVeicolo() : null)
		                .build())
		        .collect(Collectors.toList());
		
	}*/

	

	

}
