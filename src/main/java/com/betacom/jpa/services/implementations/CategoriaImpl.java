package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.CategoriaReq;
import com.betacom.jpa.dto.outputs.CategoriaDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Categoria;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.services.interfaces.ICategoriaServices;
import com.betacom.jpa.utils.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoriaImpl implements ICategoriaServices{

	private final ICategoriaRepository catR;
	
	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public Integer create(CategoriaReq req) throws AcademyException {
		log.debug("create {}");
		if(req.getCategoria()==null)
			throw new AcademyException("Categoria non caricata");
		Categoria c = new Categoria();
		c.setCategoria(req.getCategoria());
		return catR.save(c).getId();
	}

	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void update(CategoriaReq req) throws AcademyException {
		log.debug("update {}");
		Optional<Categoria> cat = catR.findById(req.getId());
		if(cat.isEmpty())
			throw new AcademyException("Categoria non trovata");
		Categoria c = cat.get();
		if(req.getCategoria()!=null)
			c.setCategoria(req.getCategoria());
		catR.save(c);
	}

	@Transactional(rollbackFor = AcademyException.class)
	@Override
	public void delete(Integer id) throws AcademyException {
		log.debug("delete {}");
		Categoria cat = catR.findById(id)
				.orElseThrow( () -> new AcademyException("Categoria non trovata"));
		catR.delete(cat);
		
	}

	@Override
	public List<CategoriaDTO> findAll() throws AcademyException {
		log.debug("findAll {}");
		List<Categoria> lC = catR.findAll();
		return Mapper.buildCategoriaDTO(lC);
	}

	@Override
	public CategoriaDTO findByID(Integer id) throws AcademyException {
		log.debug("findById {}");
		Categoria cat = catR.findById(id)
				.orElseThrow( () -> new AcademyException("Categoria non trovata"));
		return Mapper.buildCategoriaDTO(cat);
	}

}
