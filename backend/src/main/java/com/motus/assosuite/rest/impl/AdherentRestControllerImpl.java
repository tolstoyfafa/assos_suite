package com.motus.assosuite.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.motus.assosuite.models.Adherent;
import com.motus.assosuite.rest.AdherentRestController;
import com.motus.assosuite.service.AdherentService;

@RestController(value = "/assosuite/api/adherents")
public class AdherentRestControllerImpl implements AdherentRestController {

	private final AdherentService service;

	@Autowired
	public AdherentRestControllerImpl(AdherentService service) {
		this.service = service;
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, value = "/")
	@Override
	public Adherent create(@RequestBody Adherent adherent) {
		return service.create(adherent);
	}
}
