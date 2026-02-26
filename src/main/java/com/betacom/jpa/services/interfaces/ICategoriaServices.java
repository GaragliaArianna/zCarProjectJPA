package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.CategoriaReq;
import com.betacom.jpa.dto.outputs.CategoriaDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface ICategoriaServices {
	Integer create(CategoriaReq req) throws AcademyException;
	void update(CategoriaReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	List<CategoriaDTO> findAll() throws AcademyException;
	CategoriaDTO findByID(Integer id) throws AcademyException;
}
