package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.dto.outputs.MacchinaDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface IMacchinaServices {
	
	Integer create(MacchinaReq req) throws AcademyException;
	void update(MacchinaReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	MacchinaDTO findById(Integer id) throws Exception;
	List<MacchinaDTO> findAll() throws AcademyException;

}
