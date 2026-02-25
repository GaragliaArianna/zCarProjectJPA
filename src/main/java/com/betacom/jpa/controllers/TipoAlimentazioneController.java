package com.betacom.jpa.controllers;

import com.betacom.jpa.dto.input.AlimentazioneReq;
import com.betacom.jpa.dto.outputs.AlimentazioneDTO;
import com.betacom.jpa.services.interfaces.IAlimentazioneServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-alimentazioni")
public class TipoAlimentazioneController {

    private static final Logger log = LoggerFactory.getLogger(TipoAlimentazioneController.class);

    @Autowired
    private IAlimentazioneServices service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody AlimentazioneReq req) {
        try {
            service.create(req);
            return ResponseEntity.ok("TipoAlimentazione creato con successo");
        } catch (Exception e) {
            log.error("Errore create TipoAlimentazione: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody AlimentazioneReq req) {
        try {
            service.update(req);
            return ResponseEntity.ok("TipoAlimentazione aggiornato con successo");
        } catch (Exception e) {
            log.error("Errore update TipoAlimentazione: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return ResponseEntity.ok("TipoAlimentazione eliminato con successo");
        } catch (Exception e) {
            log.error("Errore delete TipoAlimentazione: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<AlimentazioneDTO>> listAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            log.error("Errore getById TipoAlimentazione: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
