package com.betacom.jpa.services.implementations;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.repositories.IAbbonamentoRepository;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.repositories.ISocioRepository;
import com.betacom.jpa.services.interfaces.IAbbonamentoServices;
import com.betacom.jpa.services.interfaces.IBiciServices;
import com.betacom.jpa.services.interfaces.IMessagioServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BiciImpl implements IBiciServices{
	private final IBiciRepository biciR;

	final IMessagioServices msgS;

	@Override
	public Integer create(BiciReq req) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BiciReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BiciDTO findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
