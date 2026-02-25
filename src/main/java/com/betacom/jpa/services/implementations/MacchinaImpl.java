package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.outputs.MacchinaDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.repositories.IMacchinaRepository;

import com.betacom.jpa.services.interfaces.IMacchinaServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;
import com.betacom.jpa.utils.VeicoloUtils;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MacchinaImpl implements IMacchinaServices{
	private final IMacchinaRepository macchinaR;

	final IMessaggioServices msgS;
	
	private VeicoloUtils veicoloUtils;

    @Transactional(rollbackOn = AcademyException.class)
    @Override
    public Integer create(MacchinaReq req) throws AcademyException {

        log.debug("create Macchina {}", req);

   
        if (req.getTarga() == null || req.getTarga().isBlank())
            throw new AcademyException("Targa non caricata");

        if (macchinaR.existsByTarga(req.getTarga()))
            throw new AcademyException("Targa già presente: " + req.getTarga());

 
        Macchina macchina = new Macchina();
        veicoloUtils.buildVeicoloFromReq(macchina, req);

     
        if (req.getNumeroPorte() == null)
            throw new AcademyException("Numero porte non caricato");

        if (req.getCc() == null)
            throw new AcademyException("Cilindrata non caricata");

 
        macchina.setNumeroPorte(req.getNumeroPorte());
        macchina.setCc(req.getCc());
        macchina.setTarga(req.getTarga());

        return macchinaR.save(macchina).getId();
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
