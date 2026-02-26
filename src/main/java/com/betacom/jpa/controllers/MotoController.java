package com.betacom.jpa.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.input.MotoReq;
import com.betacom.jpa.dto.outputs.MotoDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.services.interfaces.IMessaggioServices;

import com.betacom.jpa.services.interfaces.IMotoServices;

import org.springframework.web.bind.annotation.RequestBody; 
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/moto")
@RequiredArgsConstructor
public class MotoController {

	private final IMotoServices abbS;
	private final IMessaggioServices msgS;

	
	 @PostMapping
	    public ResponseEntity<Integer> create(@RequestBody MotoReq req) {
	        try {
	            Integer id = abbS.create(req);
	            return ResponseEntity.status(HttpStatus.CREATED).body(id);
	        } catch (AcademyException e) {
	            log.error("Errore create moto: {}", e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<MotoDTO> findById(@PathVariable Integer id) {
	        try {
	            MotoDTO moto = abbS.findById(id);
	            return ResponseEntity.ok(moto);
	        } catch (Exception e) {
	            log.error("Moto non trovata: {}", id);
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<MotoDTO>> findAll() {
	        try {
	            List<MotoDTO> lista = abbS.findAll();
	            return ResponseEntity.ok(lista);
	        } catch (AcademyException e) {
	            log.error("Errore findAll moto: {}", e.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody MotoReq req) {
	        try {
	            req.setId(id);  
	            abbS.update(req);
	            return ResponseEntity.ok().build();
	        } catch (AcademyException e) {
	            log.error("Errore update moto {}: {}", id, e.getMessage());
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Integer id) {
	        try {
	            abbS.delete(id);
	            return ResponseEntity.noContent().build();
	        } catch (AcademyException e) {
	            log.error("Errore delete moto {}: {}", id, e.getMessage());
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }


	    @GetMapping("/list")
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
    		obj = abbS.find(id, targa, cc, categoria, 
    						colore, marca, alimentazione, tipoVeicolo);
    	}catch(Exception e) {
    		obj = e.getMessage();
    		status = HttpStatus.BAD_REQUEST;
    	}
    	return ResponseEntity.status(status).body(obj);
    	
    }

}
