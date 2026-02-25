package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.input.TipoFrenoReq;
import com.betacom.jpa.dto.outputs.MotoDTO;
import com.betacom.jpa.dto.outputs.TipoFrenoDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface ITipoFrenoService {
	
	Integer create(TipoFrenoReq req) throws AcademyException;
	void update(TipoFrenoReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	TipoFrenoDTO findById(Integer id) throws Exception;
	List<TipoFrenoDTO> findAll() throws AcademyException;


}
