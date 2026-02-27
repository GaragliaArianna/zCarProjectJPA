package com.betacom.jpa.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.dto.outputs.MacchinaDTO;
import com.betacom.jpa.dto.outputs.MotoDTO;
import com.betacom.jpa.dto.outputs.VeicoloDTO;
import com.betacom.jpa.dto.outputs.VeicoloFilterDTO;
//import com.betacom.jpa.dto.outputs.VeicoloFilterDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Bici;
import com.betacom.jpa.models.Macchina;
import com.betacom.jpa.models.Moto;
import com.betacom.jpa.models.Veicolo;
import com.betacom.jpa.repositories.IAlimentazioneRepository;
import com.betacom.jpa.repositories.IBiciRepository;
import com.betacom.jpa.repositories.ICategoriaRepository;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.repositories.IMarcaRepository;
import com.betacom.jpa.repositories.ITipoFrenoRepository;
import com.betacom.jpa.repositories.ITipoSospensioneRepository;
import com.betacom.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.jpa.repositories.IVeicoloRepository;
import com.betacom.jpa.services.interfaces.IVeicoloServices;
import com.betacom.jpa.utils.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class VeicoloImpl implements IVeicoloServices{
	private final IVeicoloRepository veiR;
	@Override
	public List<VeicoloDTO> find(VeicoloFilterDTO filter) throws AcademyException {
		log.debug("find {}");
	    try {

	        List<Veicolo> veicoli = veiR.searchByFilter(
	                filter.getId(),
	                filter.getModello(),
	                filter.getAnnoProduzione(),
	                filter.getNumeroRuote(),
	                filter.getCategoria(),
	                filter.getColore(),
	                filter.getMarca(),
	                filter.getAlimentazione(),
	                filter.getTipoVeicolo(),
	                filter.getTarga(),
	                filter.getNumeroPorte(),
	                filter.getCilindrataAuto(),
	                filter.getCilindrataMoto(),
	                filter.getTargaMoto(),
	                filter.getNumeroMarce(),
	                filter.getPieghevole(),
	                filter.getSospensione(),
	                filter.getFreno()
	        );
	        
	        return Mapper.buildVeicoloDTO(veicoli);
	    } catch (Exception e) {
	        throw new AcademyException("Errore durante la ricerca dei veicoli"+e.getMessage());
	    }
	}
	@Override
    public List<VeicoloDTO> findAll() {
		log.debug("findAll {}");
        return Mapper.buildVeicoloDTO(veiR.findAll());
    }
	
}
