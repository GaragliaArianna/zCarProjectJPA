package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.MarcaReq;
import com.betacom.jpa.dto.outputs.MarcaDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface IMarcaServices {
	Integer create(MarcaReq req) throws AcademyException;
	void update(MarcaReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	List<MarcaDTO> findAll() throws AcademyException;
	MarcaDTO findByID(Integer id) throws AcademyException;
}
