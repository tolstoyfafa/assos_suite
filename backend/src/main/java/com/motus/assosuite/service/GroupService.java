package com.motus.assosuite.service;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.models.Group;

public interface GroupService {

	Group create(Group group) throws BusinessException;

	Group update(Group group, String uuid) throws BusinessException;

	Group find(String uuid) throws BusinessException;

	void delete(String uuid) throws BusinessException;
}
