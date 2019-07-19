package com.xor.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.xor.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository users;

	public CustomUserDetailsService(UserRepository users) {
		this.users = users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		log.info("Inside CustomUserDetailsService loadUserByUsername()");
		return this.users.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
	}
}