package com.betacom.jpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.betacom.jpa.dto.input.BiciReq;
import com.betacom.jpa.dto.outputs.BiciDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.services.interfaces.IBiciServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/bici")
@RequiredArgsConstructor
public class BiciController {

    private final IBiciServices biciService;

    // CREATE
    @PostMapping
    public ResponseEntity<Integer> createBici(@RequestBody BiciReq req) {
        try {
            Integer id = biciService.create(req);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (AcademyException e) {
            log.error("Errore create bici: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<BiciDTO> getBiciById(@PathVariable Integer id) {
        try {
            BiciDTO bici = biciService.findById(id); // throws Exception
            return ResponseEntity.ok(bici);
        } catch (Exception e) {
            log.error("Bici non trovata: {}", id);
            return ResponseEntity.notFound().build();
        }
    }
    
    // READ ALL
    @GetMapping
    public ResponseEntity<List<BiciDTO>> getAllBici() {
        try {
            List<BiciDTO> biciList = biciService.findAll();
            return ResponseEntity.ok(biciList);
        } catch (AcademyException e) {
            log.error("Errore findAll bici: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBici(@PathVariable Integer id, @RequestBody BiciReq req) {
        try {
            biciService.update(id, req);
            return ResponseEntity.ok().build();
        } catch (AcademyException e) {
            log.error("Errore update bici {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBici(@PathVariable Integer id) {
        try {
            biciService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (AcademyException e) {
            log.error("Errore delete bici {}: {}", id, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}