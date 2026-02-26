package com.betacom.jpa.controllers;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.outputs.VeicoloDTO;
import com.betacom.jpa.dto.outputs.VeicoloFilterDTO;
import com.betacom.jpa.services.interfaces.IMessaggioServices;
import com.betacom.jpa.services.interfaces.IMotoServices;
import com.betacom.jpa.services.interfaces.IVeicoloServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/veicolo")
@RequiredArgsConstructor
public class VeicoloController {

    private final IVeicoloServices veiS;

   
    @GetMapping("/list")
    public ResponseEntity<List<VeicoloDTO>> list(@ModelAttribute VeicoloFilterDTO filter) {
        if (filter == null) filter = new VeicoloFilterDTO(); // opzionale, ma sicuro
        return ResponseEntity.ok(veiS.find(filter));
    }
}
