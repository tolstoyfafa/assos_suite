package com.motus.assosuite.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.motus.assosuite.models.Admin;
import com.motus.assosuite.repository.AdminRepository;

@SpringBootTest
public class JwtProviderTest {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private JwtUtils provider;

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

	@Autowired
	private AdminRepository adminRepository;

	@Test
	public void testGeneration() {
		Admin admin = adminRepository.getDefault();
		String token = provider.generateToken(admin);
		assertNotNull(token);
		assertEquals(provider.getMail(token), admin.getMail());
		logger.info("=============> {}", token);
	}
}
