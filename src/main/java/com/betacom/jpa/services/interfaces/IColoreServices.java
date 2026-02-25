package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.ColoreReq;
import com.betacom.jpa.dto.outputs.ColoreDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface IColoreServices {
	Integer create(ColoreReq req) throws AcademyException;
	void update(ColoreReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	List<ColoreDTO> findAll() throws AcademyException;
	ColoreDTO findByID(Integer id) throws AcademyException;
}
