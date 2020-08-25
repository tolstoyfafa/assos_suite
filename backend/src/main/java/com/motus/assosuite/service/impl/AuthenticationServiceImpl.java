package com.motus.assosuite.service.impl;

import java.util.Arrays;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.motus.assosuite.api.exceptions.BusinessException;
import com.motus.assosuite.api.payloads.AuthDto;
import com.motus.assosuite.api.payloads.ChangePasswordDto;
import com.motus.assosuite.enums.AssosBusinessErrorCode;
import com.motus.assosuite.models.Admin;
import com.motus.assosuite.security.JwtUtils;
import com.motus.assosuite.service.AdminService;
import com.motus.assosuite.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private final AuthenticationManager authenticationManager;

	@Autowired
	private final AdminService adminService;

	@Autowired
	private JwtUtils utils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public AuthenticationServiceImpl(AuthenticationManager authenticationManager, AdminService adminService) {
		super();
		this.authenticationManager = authenticationManager;
		this.adminService = adminService;
	}

	@Override
	public String authenticateJwt(AuthDto admin) {
		logger.info("Admin attempting to sign in");

		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(admin.getMail(), admin.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (BadCredentialsException e) {
			throw new BusinessException("You have set a bad credentials for administrator",
					AssosBusinessErrorCode.ADMIN_BAD_CREDENTIALS);
		}
		return utils.generateToken(adminService.loadUserByUsername(admin.getMail()));
	}

	@Override
	public Admin changePassword(ChangePasswordDto change) throws BusinessException {
		logger.info("Admin attempting to change his password");
		Admin admin = adminService.loadUserByUsername(change.getMail());
		PasswordValidator validator = new PasswordValidator(Arrays.asList(
				new LengthRule(8, 20),
				new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new CharacterRule(EnglishCharacterData.LowerCase, 1), new CharacterRule(EnglishCharacterData.Digit, 1),
				new CharacterRule(EnglishCharacterData.Special, 1), new WhitespaceRule()));
		RuleResult result = validator.validate(new PasswordData(change.getNewPassword()));
		if (!result.isValid()) {
			throw new BusinessException(validator.getMessages(result).toString(),
					AssosBusinessErrorCode.PASSWORD_INVALID);
		}
		// TODO: add history chack for the password
		admin.setPassword(passwordEncoder.encode(change.getNewPassword()));
		return adminService.update(admin);
	}

}
