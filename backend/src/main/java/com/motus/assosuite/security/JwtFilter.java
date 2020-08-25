package com.motus.assosuite.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.motus.assosuite.models.Admin;
import com.motus.assosuite.service.AdminService;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private static final String BEARER = "Bearer";
	private static final String AUTHORIZATION = "Authorization";

	@Autowired
	private JwtUtils utils;

	@Autowired
	private AdminService adminService;

	private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

	public JwtFilter(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		logger.debug("doFilterInternal");
		String bearerToken = request.getHeader(AUTHORIZATION);
		String jwt = null;
		String username = null;
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER)) {
			jwt = bearerToken.substring(7);
			username = utils.getMail(jwt);
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			Admin admin = adminService.loadUserByUsername(username);
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(admin, null,
					admin.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}

}
