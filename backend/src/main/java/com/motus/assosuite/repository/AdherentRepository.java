package com.motus.assosuite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.motus.assosuite.models.Adherent;

public interface AdherentRepository extends MongoRepository<Adherent, String>{

}
