package com.xor.web;

import com.xor.repository.UserRepository;
import com.xor.service.CustomerServiceImpl;

import lombok.extern.slf4j.Slf4j;

import com.xor.constant.Constants;
import com.xor.jwt.JwtTokenProvider;
import com.xor.model.AuthenticationRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {
        log.info("Inside AuthenticationController signin()");
        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put(Constants.USER_NAME, username);
            model.put(Constants.USER_PASS, token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(Constants.INVALID_CREDENTAILS);
        }
    }
}