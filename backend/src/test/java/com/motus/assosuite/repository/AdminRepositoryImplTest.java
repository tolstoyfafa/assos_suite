package com.motus.assosuite.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.motus.assosuite.config.MongoConfigTests;
import com.motus.assosuite.models.Admin;

@SpringBootTest
@Import(MongoConfigTests.class)
public class AdminRepositoryImplTest {


	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AdminRepository repository;

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
	public void testGetAdmin() {
		logger.info("======BEGIN_TEST======");
		assertEquals(repository.findAll().size(), 1);
		logger.info("======END_TEST======");
	}

}
