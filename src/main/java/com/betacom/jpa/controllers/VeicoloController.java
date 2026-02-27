package com.betacom.jpa.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.dto.outputs.VeicoloDTO;
import com.betacom.jpa.dto.outputs.VeicoloFilterDTO;
import com.betacom.jpa.services.interfaces.IVeicoloServices;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/veicolo")
@RequiredArgsConstructor
public class VeicoloController {

    private final IVeicoloServices veiS;

   
    @PostMapping("/list")
    public ResponseEntity<List<VeicoloDTO>> list(@RequestBody(required = false) VeicoloFilterDTO filter, 
                                                  HttpServletRequest request) throws Exception {

        String body = new String(request.getInputStream().readAllBytes());
        System.out.println("BODY GREZZO: " + body);
        System.out.println("FILTER RICEVUTO: " + filter);
        
        if (filter == null) filter = new VeicoloFilterDTO();
        return ResponseEntity.ok(veiS.find(filter));
    }
}
