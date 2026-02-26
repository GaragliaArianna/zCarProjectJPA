package com.betacom.jpa.services.implementations;
 
import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.outputs.TipoSospensioneDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.TipoSospensione;
import com.betacom.jpa.repositories.ITipoSospensioneRepository;
import com.betacom.jpa.services.interfaces.ITipoSospensioneService;
import com.betacom.jpa.utils.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
@RequiredArgsConstructor
public class TipoSospensioneImpl implements ITipoSospensioneService {
 
    private final ITipoSospensioneRepository tipoSospensioneR;
 
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public Integer create(TipoSospensioneReq req) throws AcademyException {
        log.debug("create TipoSospensione {}", req);
 
        if (req.getSospensione() == null || req.getSospensione().isBlank())
            throw new AcademyException("Tipo sospensione non caricato");
 
        TipoSospensione ts = new TipoSospensione();
        ts.setSospensione(req.getSospensione());
 
        return tipoSospensioneR.save(ts).getIdSospensione();
    }
 
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void update(TipoSospensioneReq req) throws AcademyException {
        log.debug("update TipoSospensione {}", req);
 
        // TipoSospensioneReq non ha id: aggiorniamo tutti i record o lanciamo eccezione.
        throw new AcademyException("Operazione non supportata: aggiungere 'id' al TipoSospensioneReq per effettuare l'update");
    }
 
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void delete(Integer id) throws AcademyException {
        log.debug("delete TipoSospensione {}", id);
 
        TipoSospensione ts = tipoSospensioneR.findById(id)
                .orElseThrow(() -> new AcademyException("Tipo sospensione non trovata"));
 
        tipoSospensioneR.delete(ts);
    }
 
    @Override
    public TipoSospensioneDTO findById(Integer id) throws Exception {
        log.debug("findById TipoSospensione {}", id);

        TipoSospensione ts = tipoSospensioneR.findById(id)
                .orElseThrow(() -> new AcademyException("Tipo sospensione non trovata"));

        return Mapper.buildTipoSospensioneDTO(ts);
    }
    
    
    @Override
    public List<TipoSospensioneDTO> findAll() throws AcademyException {
        log.debug("findAll TipoSospensione");

        return Mapper.buildTipoSospensioneDTO(
                tipoSospensioneR.findAll()
        );
    }



}