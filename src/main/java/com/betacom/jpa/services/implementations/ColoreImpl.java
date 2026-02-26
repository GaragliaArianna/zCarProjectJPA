package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.ColoreReq;
import com.betacom.jpa.dto.outputs.ColoreDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.services.interfaces.IColoreServices;
import com.betacom.jpa.utils.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ColoreImpl implements IColoreServices{
	
	private final IColoreRepository colR;
	
	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public Integer create(ColoreReq req) throws AcademyException {
		log.debug("create {}");
		if(req.getColore()==null)
			throw new AcademyException("Colore non caricato");
		Colore c = new Colore();
		c.setColore(req.getColore());
		return colR.save(c).getIdColore();
	}

	@Override
	public void update(ColoreReq req) throws AcademyException {
		log.debug("update {}");
		Optional<Colore> col = colR.findById(req.getId());
		if(col.isEmpty())
			throw new AcademyException("Colore non trovato");
		Colore c = col.get();
		if(req.getColore()!=null)
			c.setColore(req.getColore());
		colR.save(c);
		
	}

	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void delete(Integer id) throws AcademyException {
		log.debug("delete {}");
		Colore col = colR.findById(id)
				.orElseThrow( () -> new AcademyException("Colore non trovato"));
		colR.delete(col);
	}

	@Override
	public List<ColoreDTO> findAll() throws AcademyException {
		log.debug("findAll {}");
		List<Colore> lC= colR.findAll();
		
		return Mapper.buildColoreDTO(lC);
	}

	@Override
	public ColoreDTO findByID(Integer id) throws AcademyException {
		log.debug("findById {}");
		Colore col = colR.findById(id)
				.orElseThrow( () -> new AcademyException("Colore non trovato"));
		return Mapper.buildColoreDTO(col);
	}

}
