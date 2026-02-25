package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.outputs.BiciDTO;

import com.betacom.jpa.exceptions.AcademyException;

public interface IBiciServices {
	
	Integer create(BiciReq req) throws AcademyException;
	void update(BiciReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	BiciDTO findById(Integer id) throws Exception;
	List<BiciDTO> findAll() throws AcademyException;

}
