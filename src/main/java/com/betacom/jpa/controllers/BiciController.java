package com.betacom.jpa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.jpa.services.interfaces.IBiciServices;
import com.betacom.jpa.services.interfaces.IMessaggioServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rest/bici")
@RequiredArgsConstructor
public class BiciController {

	private final IBiciServices abbS;
	private final IMessaggioServices msgS;
	
	
}
