package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.AlimentazioneReq;
import com.betacom.jpa.dto.outputs.AlimentazioneDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Alimentazione;
import com.betacom.jpa.repositories.IAlimentazioneRepository;
import com.betacom.jpa.services.interfaces.IAlimentazioneServices;
import com.betacom.jpa.utils.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class AlimentazioneImpl implements IAlimentazioneServices{

	private final IAlimentazioneRepository alimR;
	
	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public Integer create(AlimentazioneReq req) throws AcademyException {
		log.debug("create {}");
		if(req.getTipoAlimentazione()==null)
			throw new AcademyException("Alimentazione non caricato");
		Alimentazione a = new Alimentazione();
		a.setAlimentazione(req.getTipoAlimentazione());
		return alimR.save(a).getId();
	}

	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void update(AlimentazioneReq req) throws AcademyException {
		log.debug("update {}");
		Optional<Alimentazione> ali = alimR.findById(req.getId());
		if (ali.isEmpty())
			throw new AcademyException("Alimentazione non trovata");
		Alimentazione a = ali.get();
		if(req.getTipoAlimentazione()!=null)
			a.setAlimentazione(req.getTipoAlimentazione());
		
		alimR.save(a);
	}

	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void delete(Integer id) throws AcademyException {
		log.debug("delete {}", id);
		Alimentazione alim = alimR.findById(id)
				.orElseThrow( () ->  new AcademyException("Alimentazione non trovata"));
		alimR.delete(alim);
		
	}

	@Override
	public AlimentazioneDTO findById(Integer id) throws Exception {
		log.debug("findById: {}", id);
		Alimentazione alim = alimR.findById(id)
				.orElseThrow( () ->  new AcademyException("Alimentazione non trovata"));
		return Mapper.buildAlimentazioneDTO(alim);
	}

	@Override
	public List<AlimentazioneDTO> findAll() throws AcademyException {
		log.debug("findAll {}");
		List<Alimentazione>  lA = alimR.findAll();	
		return Mapper.buildAlimentazioneDTO(lA);
	}

}
