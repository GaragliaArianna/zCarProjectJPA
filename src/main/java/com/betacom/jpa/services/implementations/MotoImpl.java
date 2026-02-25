package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.outputs.MotoDTO;
import com.betacom.jpa.exceptions.AcademyException;

import com.betacom.jpa.repositories.IMotoRepository;

import com.betacom.jpa.services.interfaces.IMessaggioServices;

import com.betacom.jpa.services.interfaces.IMotoServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MotoImpl implements IMotoServices{

	private final IMotoRepository motoR;
	
	final IMessaggioServices msgS;

	@Override
	public Integer create(MotoReq req) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MotoReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MotoDTO findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MotoDTO> findAll() throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}
}
