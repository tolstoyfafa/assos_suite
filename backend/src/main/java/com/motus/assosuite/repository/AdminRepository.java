package com.motus.assosuite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.motus.assosuite.models.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {

	Admin findByUuid();
}
