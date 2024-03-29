package com.xor.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.xor.constant.Constants;

@Component
public class JwtTokenAuthenticationFilter extends GenericFilterBean {

	private JwtTokenProvider jwtTokenProvider;

	public JwtTokenAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			String token = jwtTokenProvider.resolveToken((HttpServletRequest) req);
			if (token != null && jwtTokenProvider.validateToken(token)) {
				Authentication auth = jwtTokenProvider.getAuthentication(token);

				if (auth != null) {
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}
			filterChain.doFilter(req, res);
		} catch (Exception e) {
			((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, Constants.JWT_AUTH_FAILED);
		}
	}
}