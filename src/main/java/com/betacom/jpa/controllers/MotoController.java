package com.betacom.jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.betacom.jpa.services.interfaces.IMessaggioServices;

import com.betacom.jpa.services.interfaces.IMotoServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/moto")
@RequiredArgsConstructor
public class MotoController {

	private final IMotoServices abbS;
	private final IMessaggioServices msgS;

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
