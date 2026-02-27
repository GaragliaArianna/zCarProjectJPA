package com.betacom.jpa.services.interfaces;

import java.util.List;

import com.betacom.jpa.dto.outputs.MacchinaDTO;
import com.betacom.jpa.dto.outputs.VeicoloDTO;
import com.betacom.jpa.dto.outputs.VeicoloFilterDTO;
import com.betacom.jpa.exceptions.AcademyException;

public interface IVeicoloServices {
	List<VeicoloDTO> find(VeicoloFilterDTO filter) throws AcademyException;
	 List<VeicoloDTO> findAll() throws AcademyException;
}
