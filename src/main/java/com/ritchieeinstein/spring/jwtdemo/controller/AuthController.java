package com.ritchieeinstein.spring.jwtdemo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritchieeinstein.spring.jwtdemo.model.AuthenticationRequest;
import com.ritchieeinstein.spring.jwtdemo.security.JwtTokenProvider;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    UserDetailsService userDetailsService;
    
    @PostMapping("/signin")
    public ResponseEntity signin() {

        try {
            String username = "Ritchie";
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, "Tester"));
            if(userDetailsService.loadUserByUsername(username) == null) {
            	throw new BadCredentialsException("Invalid username/password supplied");
            }
            List<String> permissions = new ArrayList<>();
            permissions.add("ROLE_USER");
            String token = jwtTokenProvider.createToken(username, permissions);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

}
