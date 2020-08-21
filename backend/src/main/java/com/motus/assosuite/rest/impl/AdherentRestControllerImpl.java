package com.motus.assosuite.rest.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.motus.assosuite.models.Adherent;
import com.motus.assosuite.rest.AdherentRestController;
import com.motus.assosuite.service.AdherentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/assosuite/api/v1/adherents")
@Api("Adherents API to manage adhrents root operations as ADD or LIST.")
public class AdherentRestControllerImpl implements AdherentRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdherentRestControllerImpl.class);

	private final AdherentService service;

	@Autowired
	public AdherentRestControllerImpl(AdherentService service) {
		this.service = service;
	}

	@GetMapping(path = "/{uuid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Find an adhrent by its uuid")
	@Override
	public ResponseEntity<Adherent> find(@PathVariable String uuid) {
		LOGGER.debug("find an adherent");
		return new ResponseEntity<Adherent>(service.find(uuid), HttpStatus.OK);
	}

	@PostMapping(path = "", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Add an adhrent")
	@Override
	public ResponseEntity<Adherent> create(@RequestBody @Valid Adherent adherent) {
		LOGGER.debug("Create and adherent {}", adherent.toString());
		return new ResponseEntity<Adherent>(service.create(adherent), HttpStatus.CREATED);
	}

	@GetMapping(path = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Recover all adhrents only for admin SUPERADMIN")
	@Override
	public ResponseEntity<List<Adherent>> findAll(
			@RequestParam(required = false) Integer pageNum,
			@RequestParam(required = false )Integer pageSize,
			@RequestParam(required = false ,defaultValue = "ASC")String order,
			@RequestParam(required = false ) @ApiParam(defaultValue = "ASC") String field) {
		LOGGER.debug("Fetching all adherents");
		List<Adherent> adherents = service.findAll(pageNum, pageSize,order, field);
		return new ResponseEntity<List<Adherent>>(adherents, HttpStatus.OK);
	}

	@PutMapping(path = "/{uuid}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Full Update of an adherent only for admin SUPERADMIN")
	@Override
	public ResponseEntity<Adherent> udpate(@RequestBody Adherent adherent, @PathVariable String uuid) {
		return new ResponseEntity<Adherent>(service.update(adherent, uuid), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{uuid}")
	@ApiOperation(value = "Delte adherent only for admin SUPERADMIN")
	@Override
	public ResponseEntity<Adherent> delete(@PathVariable String uuid) {
		service.delete(uuid);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
