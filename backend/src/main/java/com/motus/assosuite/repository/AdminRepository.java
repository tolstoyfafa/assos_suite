package com.motus.assosuite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.motus.assosuite.models.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {
	@Query("{'mail': 'adminstrator@assosuite.com'}")
	Admin getDefault();

	Admin findByUuid(String uuid);

	Admin findByMail(String mail);
}
