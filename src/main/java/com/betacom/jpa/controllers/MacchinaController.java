package com.betacom.jpa.controllers;


import com.betacom.jpa.dto.input.MacchinaReq;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.response.Resp;
import com.betacom.jpa.services.interfaces.IMacchinaServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
}
