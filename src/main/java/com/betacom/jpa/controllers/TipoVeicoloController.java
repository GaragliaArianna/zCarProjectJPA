package com.betacom.jpa.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.betacom.jpa.dto.input.TipoVeicoloReq;
import com.betacom.jpa.dto.outputs.TipoVeicoloDTO;
import com.betacom.jpa.services.interfaces.ITipoVeicoloService;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-veicolo")
public class TipoVeicoloController {

    private static final Logger log = LoggerFactory.getLogger(TipoVeicoloController.class);

    private final ITipoVeicoloService service;

    public TipoVeicoloController(ITipoVeicoloService service) {
        this.service = service;
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
}