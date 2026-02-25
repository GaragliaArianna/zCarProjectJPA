package com.betacom.jpa.services.interfaces;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.dto.outputs.MotoDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface IMotoServices {
	
	Integer create(MotoReq req) throws AcademyException;
	void update(MotoReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	MotoDTO findById(Integer id) throws Exception;

}
