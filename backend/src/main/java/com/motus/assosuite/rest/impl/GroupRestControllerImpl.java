package com.motus.assosuite.rest.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motus.assosuite.models.Group;
import com.motus.assosuite.rest.GroupRestController;
import com.motus.assosuite.service.GroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("API Group of adherents")
@RequestMapping(path = "/assosuite/api/v1/groups")
public class GroupRestControllerImpl implements GroupRestController {

	private final GroupService service;

	public GroupRestControllerImpl(GroupService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "/{uuid}")
	@ApiOperation("Endpoint to find a group of adherent")
	@Override
	public ResponseEntity<Group> find(String uuid) {
		return new ResponseEntity<Group>(service.find(uuid), HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Endpoint to add a group of adherents")
	@Override
	public ResponseEntity<Group> create(Group group) {
		return new ResponseEntity<Group>(service.create(group), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{uuid}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Endpoint to full Update of a group only for admin SUPERADMIN")
	@Override
	public ResponseEntity<Group> udpate(Group group, String uuid) {
		return new ResponseEntity<Group>(service.update(group, uuid), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{uuid}")
	@ApiOperation(value = "Endpoint to Delete group only for admin SUPERADMIN")
	@Override
	public ResponseEntity<Group> delete(String uuid) {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
