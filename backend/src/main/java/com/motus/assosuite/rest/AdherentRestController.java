package com.motus.assosuite.rest;

import java.util.List;

import com.motus.assosuite.models.Adherent;

public interface AdherentRestController {
	
	Adherent find(String uuid);

	Adherent create(Adherent adherent);

	List<Adherent> findAll();

	Adherent udpate(Adherent adherent, String uuid);

}
