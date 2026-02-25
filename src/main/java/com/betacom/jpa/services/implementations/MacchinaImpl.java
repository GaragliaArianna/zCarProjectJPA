package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.outputs.MacchinaDTO;
import com.betacom.jpa.exceptions.AcademyException;

import com.betacom.jpa.repositories.IMacchinaRepository;

import com.betacom.jpa.services.interfaces.IMacchinaServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MacchinaImpl implements IMacchinaServices{
	private final IMacchinaRepository macchinaR;

	final IMessaggioServices msgS;

	@Override
	public Integer create(MacchinaReq req) throws AcademyException {
		log.debug("create");
		return null;
	}

	@Override
	public void update(MacchinaReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MacchinaDTO findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MacchinaDTO> findAll() throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

}
