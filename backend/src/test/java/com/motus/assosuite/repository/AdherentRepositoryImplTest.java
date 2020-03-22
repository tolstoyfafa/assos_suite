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
	public void test() {
		logger.info("======BEGIN_TEST======");
		Adherent adherent = repository.save(new Adherent());
		assertNotNull(adherent, "adhrent was not created");
		logger.info("======END_TEST======");
	}

}
