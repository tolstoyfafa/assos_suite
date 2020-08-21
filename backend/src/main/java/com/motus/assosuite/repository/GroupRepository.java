package com.motus.assosuite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.models.Group;

public interface GroupRepository extends MongoRepository<Group, String>{

	Group findByUuid (String uuid) throws BusinessException;

	Group findByName() throws BusinessException;

}
