package com.motus.assosuite.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.motus.assosuite.config.MongoConfigTests;
import com.motus.assosuite.models.Adherent;

@SpringBootTest
@Import(MongoConfigTests.class)
public class AdherentRepositoryImplTest {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AdherentRepository repository;

	@BeforeEach
	public void setUp() {
		logger.info("======BEGIN_SETUP======");
		logger.info("======END_SETUP======");
	}

	@AfterEach
	public void tearDown() {
		logger.info("======BEGIN_SETUP======");
		logger.info("======END_SETUP======");
	}

	@Test
	public void testCreate() {
		logger.info("======BEGIN_TEST======");
		Adherent adherent = repository.save(new Adherent());
		assertNotNull(adherent, "adhrent was not created");
		logger.info("======END_TEST======");
	}
	
	@Test
	public void testFindAll() {
		logger.info("======BEGIN_TEST======");
		repository.save(new Adherent());
		repository.save(new Adherent());
		repository.save(new Adherent());
		repository.save(new Adherent());
		repository.save(new Adherent());
		repository.save(new Adherent());
		repository.save(new Adherent());
		assertEquals(7, repository.findAll().size());
		Pageable paging = PageRequest.of(1, 3);
		logger.info(paging.toString());
		assertEquals(3, repository.findAll(paging).toList().size());
		logger.info("======END_TEST======");
	}

}
