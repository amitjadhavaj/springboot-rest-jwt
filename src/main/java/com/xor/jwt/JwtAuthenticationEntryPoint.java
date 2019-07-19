package com.xor.jwt;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.xor.constant.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.debug(Constants.JWT_AUTH_FAILED + authException);

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, Constants.JWT_AUTH_FAILED);

	}
}