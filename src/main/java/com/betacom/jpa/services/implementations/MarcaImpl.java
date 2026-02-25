package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.MarcaReq;
import com.betacom.jpa.dto.outputs.MarcaDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Marca;
import com.betacom.jpa.repositories.IMarcaRepository;
import com.betacom.jpa.services.interfaces.IMarcaServices;
import com.betacom.jpa.utils.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class MarcaImpl implements IMarcaServices{
	private final IMarcaRepository marR;
	
	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public Integer create(MarcaReq req) throws AcademyException {
		log.debug("create {}");
		if(req.getMarca()==null)
			throw new AcademyException("Marca non caricata");
		Marca m = new Marca();
		m.setMarca(req.getMarca());
		return marR.save(m).getIdMarca();
	}
	
	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void update(MarcaReq req) throws AcademyException {
		log.debug("update {}");
		Optional<Marca> mar = marR.findById(req.getId());
		if(mar.isEmpty())
			throw new AcademyException("Marca non trovata");
		Marca m = mar.get();
		if(req.getMarca()!=null)
			m.setMarca(req.getMarca());
		marR.save(m);
		
	}

	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void delete(Integer id) throws AcademyException {
		log.debug("delete {}");
		Marca m = marR.findById(id)
				.orElseThrow( () -> new AcademyException("Marca non trovata"));
		marR.delete(m);
		
	}

	@Override
	public List<MarcaDTO> findAll() throws AcademyException {
		log.debug("findAll {}");
		List<Marca> lM = marR.findAll();
		return Mapper.buildMarcaDTO(lM);
	}

	@Override
	public MarcaDTO findByID(Integer id) throws AcademyException {
		log.debug("findById {}");
		Marca m = marR.findById(id)
				.orElseThrow( () -> new AcademyException("Marca non trovata"));
		return Mapper.buildMarcaDTO(m);
	}
}
