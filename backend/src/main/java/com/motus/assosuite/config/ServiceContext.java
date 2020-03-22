package com.motus.assosuite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.motus.assosuite.repository.AdminRepository;
import com.motus.assosuite.service.AdminService;
import com.motus.assosuite.service.impl.AdminServiceImpl;

@Configuration
public class ServiceContext {

	private AdminRepository repository;

	@Bean(initMethod = "init")
	public AdminService adminService() {
		return new AdminServiceImpl(repository);
	}
}
