package com.motus.assosuite.rest;

import java.util.List;

import com.motus.assosuite.models.Adherent;

public interface AdherentRestController {

	Adherent create(Adherent adherent);

	List<Adherent> findAll();

}
