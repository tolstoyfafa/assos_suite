package com.motus.assosuite.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.motus.assosuite.models.Adherent;

public interface AdherentRestController {
	
	ResponseEntity<Adherent> find(String uuid);

	ResponseEntity<Adherent> create(Adherent adherent);

	ResponseEntity<List<Adherent>> findAll();

	ResponseEntity<Adherent> udpate(Adherent adherent, String uuid);

}
