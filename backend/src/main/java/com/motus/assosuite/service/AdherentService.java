package com.motus.assosuite.service;

import java.util.List;

import com.motus.assosuite.models.Adherent;

public interface AdherentService {

	Adherent create(Adherent adherent);

	List<Adherent> findAll();
}
