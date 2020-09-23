package com.motus.assosuite.service;

import java.util.List;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.models.Group;

public interface GroupService {

	Group create(Group group) throws BusinessException;

	Group update(Group group, String uuid) throws BusinessException;

	Group find(String uuid) throws BusinessException;
	
	List<Group> findAll(Integer pageNum, Integer pageSize, String order, String field);
	
	List<Group> findAll();

	void delete(String uuid) throws BusinessException;
}
