package com.betacom.jpa.controllers;

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

import com.betacom.jpa.dto.input.AlimentazioneReq;
import com.betacom.jpa.response.Resp;
import com.betacom.jpa.services.interfaces.IAlimentazioneServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/alimentazione")
public class AlimentazioneController {
	private final IAlimentazioneServices alimS;
	private final IMessaggioServices msgS;
	
	@GetMapping ("/list")
	public ResponseEntity<Object> list(){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r = alimS.findAll();
		}catch(Exception e) {
			r  = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
		
	}
	
	@GetMapping ("/findById")
	public ResponseEntity<Object> findById(@RequestParam (required = true) Integer id){
		Object r = new Object();
		HttpStatus status = HttpStatus.OK;
		try {
			r = alimS.findById(id);
		}catch(Exception e) {
			r  = e.getMessage();
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@PostMapping ("/create")
	public ResponseEntity<Resp> create(@RequestBody(required = true) AlimentazioneReq req) {
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			alimS.create(req);
			r.setMsg(msgS.get("rest_created"));
		}catch(Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@PutMapping ("/update")
	public ResponseEntity<Resp> update(@RequestBody(required = true) AlimentazioneReq req) {
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			alimS.update(req);
			r.setMsg(msgS.get("rest_updated"));
		}catch(Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Resp> delete(@PathVariable(required = true) Integer id) {
		Resp r = new Resp();
		HttpStatus status = HttpStatus.OK;
		try {
			alimS.delete(id);
			r.setMsg(msgS.get("rest_deleted"));
		}catch(Exception e) {
			r.setMsg(e.getMessage());
			status = HttpStatus.BAD_REQUEST;
		}
		return ResponseEntity.status(status).body(r);
	}

}
