package com.motus.assosuite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.motus.assosuite.repository.AdminRepository;
import com.motus.assosuite.service.InitService;
import com.motus.assosuite.service.impl.InitServiceImpl;

@Configuration
public class ServiceContext {

	private AdminRepository repository;

	@Bean(initMethod = "init")
	public InitService initService() {
		return new InitServiceImpl(repository);
	}
}
