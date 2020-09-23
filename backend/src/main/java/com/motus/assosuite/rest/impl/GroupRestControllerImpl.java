package com.motus.assosuite.rest.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motus.assosuite.models.Group;
import com.motus.assosuite.rest.GroupRestController;
import com.motus.assosuite.service.GroupService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("API Group of adherents")
@RequestMapping(path = "/assosuite/api/v1/groups")
public class GroupRestControllerImpl implements GroupRestController {

	private final GroupService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GroupRestControllerImpl.class);

	public GroupRestControllerImpl(GroupService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Recover all adhrents only for admin SUPERADMIN")
	@Override
	public ResponseEntity<List<Group>> findAll(
			@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false )Integer pageSize,
			@RequestParam(required = false ,defaultValue = "ASC")String order,
			@RequestParam(required = false ) @ApiParam(defaultValue = "ASC") String field) {
		LOGGER.debug("Fetching all groups");
		List<Group> groups = service.findAll(pageNum, pageSize,order, field);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Access-Control-Expose-Headers", "content-range");
		String size = service.findAll().isEmpty() ? "0" : String.valueOf(service.findAll().size());
		responseHeaders.add("content-range", size);
		return new ResponseEntity<List<Group>>(groups, responseHeaders,HttpStatus.OK);
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
	public ResponseEntity<Group> create(@RequestBody Group group) {
		return new ResponseEntity<Group>(service.create(group), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{uuid}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Endpoint to full Update of a group only for admin SUPERADMIN")
	@Override
	public ResponseEntity<Group> udpate(@RequestBody Group group,@RequestParam String uuid) {
		return new ResponseEntity<Group>(service.update(group, uuid), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{uuid}")
	@ApiOperation(value = "Endpoint to Delete group only for admin SUPERADMIN")
	@Override
	public ResponseEntity<Group> delete(String uuid) {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
