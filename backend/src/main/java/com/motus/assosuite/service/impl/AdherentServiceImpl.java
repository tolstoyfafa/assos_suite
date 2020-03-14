package com.motus.assosuite.service.impl;

import com.motus.assosuite.models.Adherent;
import com.motus.assosuite.repository.AdherentRepository;
import com.motus.assosuite.service.AdherentService;

public class AdherentServiceImpl implements AdherentService{
	
	private final AdherentRepository repository;

	public AdherentServiceImpl(AdherentRepository repository) {
		this.repository = repository;
	}
	@Override
	public Adherent create(Adherent adherent) {
		// TODO Auto-generated method stub
		return repository.save(adherent);
	}

}
