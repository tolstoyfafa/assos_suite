package com.motus.assosuite.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motus.assosuite.models.Adherent;
import com.motus.assosuite.repository.AdherentRepository;
import com.motus.assosuite.service.AdherentService;

@Service
public class AdherentServiceImpl implements AdherentService {

	private final AdherentRepository repository;

	@Autowired
	public AdherentServiceImpl(AdherentRepository repository) {
		this.repository = repository;
	}

	@Override
	public Adherent create(Adherent adherent) {
		return repository.save(adherent);
	}

	@Override
	public List<Adherent> findAll() {
		return repository.findAll();
	}

}
