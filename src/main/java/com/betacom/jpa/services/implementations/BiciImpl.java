package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.exceptions.AcademyException;

import com.betacom.jpa.repositories.IBiciRepository;

import com.betacom.jpa.services.interfaces.IBiciServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BiciImpl implements IBiciServices{
	private final IBiciRepository biciR;

	private final IMessaggioServices msgS;

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

	@Override
	public List<BiciDTO> findAll() throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

}
