package com.betacom.jpa.services.implementations;
 
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.betacom.jpa.dto.input.TipoFrenoReq;
import com.betacom.jpa.dto.outputs.TipoFrenoDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.TipoFreno;
import com.betacom.jpa.repositories.ITipoFrenoRepository;
import com.betacom.jpa.services.interfaces.ITipoFrenoService;
 
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
@RequiredArgsConstructor
public class TipoFrenoImpl implements ITipoFrenoService {
 
    private final ITipoFrenoRepository tipoFrenoR;
 
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public Integer create(TipoFrenoReq req) throws AcademyException {
        log.debug("create TipoFreno {}", req);
 
        if (req.getTipo() == null || req.getTipo().isBlank())
            throw new AcademyException("Tipo freno non caricato");
 
        TipoFreno tf = new TipoFreno();
        tf.setTipo(req.getTipo());
 
        return tipoFrenoR.save(tf).getId();
    }
 
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void update(TipoFrenoReq req) throws AcademyException {
        log.debug("update TipoFreno {}", req);
 
        // TipoFrenoReq non ha id: aggiorniamo tramite ricerca per tipo esistente.
        // Aggiungiamo il campo id al req se presente, altrimenti lanciamo eccezione.
        throw new AcademyException("Operazione non supportata: aggiungere 'id' al TipoFrenoReq per effettuare l'update");
    }
 
    @Transactional(rollbackFor = AcademyException.class)
    @Override
    public void delete(Integer id) throws AcademyException {
        log.debug("delete TipoFreno {}", id);
 
        TipoFreno tf = tipoFrenoR.findById(id)
                .orElseThrow(() -> new AcademyException("Tipo freno non trovato"));
 
        tipoFrenoR.delete(tf);
    }
 
    @Override
    public TipoFrenoDTO findById(Integer id) throws Exception {
        log.debug("findById TipoFreno {}", id);
 
        TipoFreno tf = tipoFrenoR.findById(id)
                .orElseThrow(() -> new AcademyException("Tipo freno non trovato"));
 
        return toDTO(tf);
    }
 
    @Override
    public List<TipoFrenoDTO> findAll() throws AcademyException {
        log.debug("findAll TipoFreno");
 
        return tipoFrenoR.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
 
    // -------------------------------------------------------
    private TipoFrenoDTO toDTO(TipoFreno tf) {
        TipoFrenoDTO dto = new TipoFrenoDTO();
        dto.setIdTipoFreno(tf.getId());
        dto.setTipo(tf.getTipo());
        return dto;
    }
}