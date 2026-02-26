package com.betacom.jpa.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.dto.outputs.MacchinaDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.response.Resp;
import com.betacom.jpa.services.interfaces.IMacchinaServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rest/macchina")
@RequiredArgsConstructor
public class MacchinaController {
	
	private final IMacchinaServices macchinaS;
	private final IMessaggioServices msgS;

	@PostMapping("/create")
	public ResponseEntity<Resp> create(@Valid @RequestBody MacchinaReq req) {

	    Resp r = new Resp();
	    HttpStatus status = HttpStatus.OK;

	    try {
	        Integer id = macchinaS.create(req);
	        r.setMsg("Macchina creata con successo, ID: " + id);
	    } 
	    catch (AcademyException e) {
	        r.setMsg(e.getMessage());
	        status = HttpStatus.BAD_REQUEST;
	    } 
	    catch (Exception e) {
	        r.setMsg("Errore interno del server");
	        status = HttpStatus.INTERNAL_SERVER_ERROR;
	    }

	    return ResponseEntity.status(status).body(r);
	}
	
    @GetMapping("/listAll")
    public ResponseEntity<List<MacchinaDTO>> getAllMacchina() {
        try {
            List<MacchinaDTO> macchinaList = macchinaS.findAll();
            return ResponseEntity.ok(macchinaList);
        } catch (AcademyException e) {
            log.error("Errore findAll macchine: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<Void> updateMacchina(@RequestParam(required=true) Integer id, @RequestBody(required=true) MacchinaReq req) {
        try {
            macchinaS.update(id, req);
            return ResponseEntity.ok().build();
        } catch (AcademyException e) {
            log.error("Errore update macchina {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @GetMapping("/findById")
    public ResponseEntity<MacchinaDTO> getBiciById(@RequestParam(required=true) Integer id) {
        try {
            MacchinaDTO macchina = macchinaS.findById(id); // throws Exception
            return ResponseEntity.ok(macchina);
        } catch (Exception e) {
            log.error("Macchina non trovata: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
    
    // DELETE
    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteMacchina(@RequestParam(required=true)  Integer id) {
        try {
        	macchinaS.delete(id);
            return ResponseEntity.noContent().build();
        } catch (AcademyException e) {
            log.error("Errore delete macchina {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



    @GetMapping("/listaFiltrata")
    public ResponseEntity<Object> list(
    		@RequestParam(required=false) Integer id,
    		@RequestParam(required=false)String targa,
    		@RequestParam(required=false)Integer numeroPorte,
    		@RequestParam(required=false)Integer cc,
    		@RequestParam(required=false)String categoria,
    		@RequestParam(required=false)String colore,
    		@RequestParam(required=false)String marca,
    		@RequestParam(required=false)String alimentazione,
    		@RequestParam(required=false)String tipoVeicolo
    		){
    	Object obj = new Object();
    	HttpStatus status = HttpStatus.OK;
    	try {
    		obj = macchinaS.find(id, targa, numeroPorte, cc, categoria, 
    						colore, marca, alimentazione, tipoVeicolo);
    	}catch(Exception e) {
    		obj = e.getMessage();
    		status = HttpStatus.BAD_REQUEST;
    	}
    	return ResponseEntity.status(status).body(obj);
    }
}