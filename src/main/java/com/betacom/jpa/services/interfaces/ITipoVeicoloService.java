package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.input.TipoVeicoloReq;
import com.betacom.jpa.dto.outputs.TipoSospensioneDTO;
import com.betacom.jpa.dto.outputs.TipoVeicoloDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface ITipoVeicoloService {

    Integer create(TipoVeicoloReq req) throws AcademyException;

    void update(Integer id, TipoVeicoloReq req) throws AcademyException;

    void delete(Integer id) throws AcademyException;

    TipoVeicoloDTO findById(Integer id) throws AcademyException;

    List<TipoVeicoloDTO> findAll() throws AcademyException;
}