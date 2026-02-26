package com.betacom.jpa.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.betacom.jpa.dto.input.TipoSospensioneReq;
import com.betacom.jpa.dto.outputs.TipoSospensioneDTO;
import com.betacom.jpa.services.interfaces.ITipoSospensioneService;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-sospensioni")
public class TipoSospensioneController {

    private static final Logger log = LoggerFactory.getLogger(TipoSospensioneController.class);

    private ITipoSospensioneService service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody TipoSospensioneReq req) {
        try {
            service.create(req);
            return ResponseEntity.ok("TipoSospensione creato con successo");
        } catch (Exception e) {
            log.error("Errore create TipoSospensione: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody TipoSospensioneReq req) {
        try {
            service.update(req);
            return ResponseEntity.ok("TipoSospensione aggiornato con successo");
        } catch (Exception e) {
            log.error("Errore update TipoSospensione: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("TipoSospensione eliminato con successo");
        } catch (Exception e) {
            log.error("Errore delete TipoSospensione: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<TipoSospensioneReq>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            log.error("Errore getById TipoSospensione: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}