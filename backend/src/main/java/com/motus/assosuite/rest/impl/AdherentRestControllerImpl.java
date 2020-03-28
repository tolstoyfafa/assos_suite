package com.motus.assosuite.rest.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motus.assosuite.models.Adherent;
import com.motus.assosuite.rest.AdherentRestController;
//import com.motus.assosuite.rest.AdherentRestController;
import com.motus.assosuite.service.AdherentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/assosuite/api/adherents")
@Api("Adherents API to manage adhrents root operations as ADD or LIST.")
public class AdherentRestControllerImpl implements AdherentRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdherentRestControllerImpl.class);

	private final AdherentService service;

	@Autowired
	public AdherentRestControllerImpl(AdherentService service) {
		this.service = service;
	}

	@PostMapping(
			path ="",
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Add an adhrent")
	@Override
	public Adherent create(@RequestBody @Valid Adherent adherent) {
		LOGGER.debug("Create and adherent {}", adherent.toString());
		return service.create(adherent);
	}

	@GetMapping(
			path = "",
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ApiOperation(value = "Recover all adhrents only for admin SUPERADMIN")
	@Override
	public List<Adherent> findAll() {
		LOGGER.debug("Fetching all adherents");
		return service.findAll();
	}
}
