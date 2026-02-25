package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.TipoFrenoReq;
import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.outputs.TipoFrenoDTO;
import com.betacom.jpa.dto.outputs.TipoSospensioneDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface ITipoSospensioneService {

	Integer create(TipoSospensioneReq req) throws AcademyException;
	void update(TipoSospensioneReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	TipoSospensioneDTO findById(Integer id) throws Exception;
	List<TipoSospensioneReq> findAll() throws AcademyException;
}
