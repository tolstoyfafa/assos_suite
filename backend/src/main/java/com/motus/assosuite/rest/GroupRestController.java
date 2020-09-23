package com.motus.assosuite.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.motus.assosuite.models.Group;

public interface GroupRestController {

	ResponseEntity<Group> find(String uuid);

	ResponseEntity<Group> create(Group Group);
	
	ResponseEntity<Group> udpate(Group Group, String uuid);
	
	ResponseEntity<Group> delete(String uuid);

	ResponseEntity<List<Group>> findAll(Integer pageNum, Integer pageSize, String order, String field);

}
