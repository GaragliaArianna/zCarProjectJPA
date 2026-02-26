package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.jpa.dto.input.TipoVeicoloReq;
import com.betacom.jpa.dto.outputs.TipoVeicoloDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.TipoVeicolo;
import com.betacom.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.jpa.services.interfaces.ITipoVeicoloService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TipoVeicoloImpl implements ITipoVeicoloService {

    private final ITipoVeicoloRepository tipoVeicoloR;

 /*
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public Integer create(TipoVeicoloReq req) throws AcademyException {

        log.debug("create TipoVeicolo {}", req);

        if (req.getVeicolo() == null || req.getVeicolo().isBlank())
            throw new AcademyException("Tipo veicolo non caricato");

        if (tipoVeicoloR.existsById(req.get))
            throw new AcademyException("Tipo veicolo già presente: " + req.getVeicolo());

        TipoVeicolo tv = new TipoVeicolo();
        tv.setVeicolo(req.getVeicolo());

        return tipoVeicoloR.save(tv).getId();
    }*/

    /*
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void update(Integer id, TipoVeicoloReq req) throws AcademyException {

        log.debug("update TipoVeicolo id={} {}", id, req);

        TipoVeicolo tv = tipoVeicoloR.findById(id)
                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato"));

        if (req.getVeicolo() == null || req.getVeicolo().isBlank())
            throw new AcademyException("Tipo veicolo non caricato");

        if (!tv.getVeicolo().equals(req.getVeicolo())
                && tipoVeicoloR.existsById(req.getVeicolo()))
            throw new AcademyException("Tipo veicolo già presente: " + req.getVeicolo());

        tv.setVeicolo(req.getVeicolo());

        tipoVeicoloR.save(tv);
    }*/

    // -------------------------------------------------------
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void delete(Integer id) throws AcademyException {

        log.debug("delete TipoVeicolo {}", id);

        TipoVeicolo tv = tipoVeicoloR.findById(id)
                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato"));

        tipoVeicoloR.delete(tv);
    }

    // -------------------------------------------------------
    @Override
    public TipoVeicoloDTO findById(Integer id) throws AcademyException {

        log.debug("findById TipoVeicolo {}", id);

        TipoVeicolo tv = tipoVeicoloR.findById(id)
                .orElseThrow(() -> new AcademyException("Tipo veicolo non trovato"));

        return toDTO(tv);
    }

    // -------------------------------------------------------
    @Override
    public List<TipoVeicoloDTO> findAll() throws AcademyException {

        log.debug("findAll TipoVeicolo");

        return tipoVeicoloR.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private TipoVeicoloDTO toDTO(TipoVeicolo tv) {

        return TipoVeicoloDTO.builder()
                .id(tv.getId())
                .veicolo(tv.getVeicolo())
                .build();
    }

	@Override
	public Integer create(TipoVeicoloReq req) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Integer id, TipoVeicoloReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}
}