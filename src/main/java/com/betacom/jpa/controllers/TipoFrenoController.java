package com.betacom.jpa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.betacom.jpa.dto.input.TipoFrenoReq;
import com.betacom.jpa.dto.outputs.TipoFrenoDTO;
import com.betacom.jpa.services.interfaces.ITipoFrenoService;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-freni")
public class TipoFrenoController {

    private static final Logger log = LoggerFactory.getLogger(TipoFrenoController.class);

    @Autowired
    private ITipoFrenoService service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody TipoFrenoReq req) {
        try {
            service.create(req);
            return ResponseEntity.ok("TipoFreno creato con successo");
        } catch (Exception e) {
            log.error("Errore create TipoFreno: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody TipoFrenoReq req) {
        try {
            service.update(req);
            return ResponseEntity.ok("TipoFreno aggiornato con successo");
        } catch (Exception e) {
            log.error("Errore update TipoFreno: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("TipoFreno eliminato con successo");
        } catch (Exception e) {
            log.error("Errore delete TipoFreno: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<TipoFrenoDTO>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            log.error("Errore getById TipoFreno: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}