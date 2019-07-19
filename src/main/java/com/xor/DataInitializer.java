package com.xor;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.xor.constant.Constants;
import com.xor.entity.User;
import com.xor.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

	@Autowired
	UserRepository users;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		this.users
				.save(User.builder().username(Constants.USER).password(this.passwordEncoder.encode(Constants.USER_PASS))
						.roles(Arrays.asList(Constants.ROLE_USER)).build());

		this.users
				.save(User.builder().username(Constants.ADMIN).password(this.passwordEncoder.encode(Constants.USER_PASS))
						.roles(Arrays.asList(Constants.ROLE_USER, Constants.ROLE_ADMIN)).build());

		log.debug("printing all users...");
		this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
	}
}
