package com.betacom.jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.services.interfaces.IAbbonamentoServices;
import com.betacom.jpa.services.interfaces.IMessagioServices;
import com.betacom.jpa.services.interfaces.IMotoServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/moto")
@RequiredArgsConstructor
public class MotoController {

	private final IMotoServices abbS;
	private final IMessagioServices msgS;
}
