package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.AlimentazioneReq;
import com.betacom.jpa.dto.outputs.AlimentazioneDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface IAlimentazioneServices {
	Integer create(AlimentazioneReq req) throws AcademyException;
	void update(AlimentazioneReq req) throws AcademyException;
	void delete(Integer id) throws AcademyException;
	AlimentazioneDTO findById(Integer id) throws Exception;
	List<AlimentazioneDTO> findAll() throws AcademyException;
}
