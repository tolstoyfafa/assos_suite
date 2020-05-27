package com.motus.assosuite.service;

import java.util.List;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.models.Adherent;

public interface AdherentService {

	Adherent create(Adherent adherent);

	List<Adherent> findAll(Integer pageNum, Integer pageSize, String order, String field);

	Adherent update(Adherent adherent, String uuid);

	Adherent find(String uuid) throws BusinessException;
	
	void delete(String uuid) throws BusinessException;
	
	
}
