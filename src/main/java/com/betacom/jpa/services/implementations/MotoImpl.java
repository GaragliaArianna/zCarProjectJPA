package com.betacom.jpa.services.implementations;



import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.outputs.MotoDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Moto;
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

	
	@Transactional (rollbackFor = AcademyException.class)
	@Override
	public Integer create (MotoReq req) throws AcademyException {
		log.debug("create {}", req);
		if(req.getTarga()==null)
			throw new AcademyException("Targa moto non caricata!");
		if(req.getCc()== null)
			throw new AcademyException("Cilindrata non specificata!");
		Optional<Moto> m = motoR.findByTarga(req.getTarga());
		if (m.isPresent())
			throw new AcademyException("Targa "+ req.getTarga()+" già presente!");
		
		
		Moto mot = new Moto();
		mot.setCc(req.getCc());
		mot.setTarga(req.getTarga());
		
		return motoR.save(mot).getId();
	}
	
	
	@Transactional (rollbackFor = AcademyException.class)
	@Override
	public void update (MotoReq req) throws AcademyException {
		log.debug("update {}", req);
		Optional<Moto> mot = motoR.findById(req.getId());
		if(mot.isEmpty())
			throw new AcademyException("Moto non trovata!");
		
		Moto m = mot.get();
		
		if(req.getCc() != null)
			m.setCc(req.getCc());
		
		 if (req.getTarga() != null) {
		        Optional<Moto> targaEsistente = motoR.findByTarga(req.getTarga());
		        if (targaEsistente.isPresent() && !targaEsistente.get().getId().equals(m.getId()))
		            throw new AcademyException("Targa " + req.getTarga() + " già presente!");
		        m.setTarga(req.getTarga());
		    }
		
		motoR.save(m);
	}
	
	
	@Transactional (rollbackFor = AcademyException.class)
	@Override
	public void delete(Integer id) throws AcademyException {
		log.debug("delete{}", id);
		Moto mot = motoR.findById(id)
				.orElseThrow(() -> new AcademyException("Moto non trovata"));
		
		motoR.delete(mot);
		
	}
	
	@Override
	public MotoDTO findById(Integer id) throws Exception {
		log.debug("findById: {}", id);
		Moto m = motoR.findById(id)
				.orElseThrow(()-> new AcademyException("Moto con id: "+ id + " non trovata!"));
		
		return MotoDTO.builder()
				.id(m.getId())
				.targa(m.getTarga())
				.cc(m.getCc())
				.build();
	}
	

	@Override
	public List<MotoDTO> findAll() throws AcademyException {
		log.debug("findAll");
		List<Moto> lM = motoR.findAll();
		
		return lM.stream()
				.map(m-> MotoDTO.builder()
						.id(m.getId())
						.targa(m.getTarga())
						.cc(m.getCc())
						.build()
						).toList();
	}
	
}
