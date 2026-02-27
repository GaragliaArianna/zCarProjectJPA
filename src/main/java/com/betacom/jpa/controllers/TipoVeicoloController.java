package com.betacom.jpa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.betacom.jpa.dto.input.ColoreReq;
import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.input.TipoVeicoloReq;
import com.betacom.jpa.dto.outputs.TipoVeicoloDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Colore;
import com.betacom.jpa.models.TipoVeicolo;
import com.betacom.jpa.repositories.IColoreRepository;
import com.betacom.jpa.repositories.ITipoVeicoloRepository;
import com.betacom.jpa.response.Resp;
import com.betacom.jpa.services.interfaces.IMessaggioServices;
import com.betacom.jpa.services.interfaces.ITipoVeicoloService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipo-veicolo")
public class TipoVeicoloController {

    private static final Logger log = LoggerFactory.getLogger(TipoVeicoloController.class);

    private final ITipoVeicoloService service;
    private final ITipoVeicoloRepository veicoloR;
	private final IMessaggioServices msgS;

    public TipoVeicoloController(ITipoVeicoloService service, ITipoVeicoloRepository veicolo, IMessaggioServices msgS) {
        this.service = service;
		this.veicoloR = veicolo;
		this.msgS = msgS;
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody TipoVeicoloReq req) {
        try {
            service.create(req);
            return ResponseEntity.ok("TipoVeicolo creato con successo");
        } catch (Exception e) {
            log.error("Errore create TipoVeicolo: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<TipoVeicoloDTO>> listAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            log.error("Errore listAll TipoVeicolo: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            log.error("Errore getById TipoVeicolo: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
	@PutMapping ("/update")
	public ResponseEntity<Resp> update(@RequestBody(required = true) TipoVeicoloReq req) {
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			service.update(req);
			r.setMsg(msgS.get("rest_updated"));
		}catch(Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("TipoVeicolo eliminato con successo");
        } catch (Exception e) {
            log.error("Errore delete TipoVeicolo: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}