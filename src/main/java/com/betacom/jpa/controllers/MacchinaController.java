package com.betacom.jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.services.interfaces.IAbbonamentoServices;
import com.betacom.jpa.services.interfaces.IMacchinaServices;
import com.betacom.jpa.services.interfaces.IMessagioServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/macchina")
@RequiredArgsConstructor
public class MacchinaController {
	
	private final IMacchinaServices abbS;
	private final IMessagioServices msgS;

}
