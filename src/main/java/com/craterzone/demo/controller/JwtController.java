package com.craterzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.craterzone.demo.helper.JwtUtil;
import com.craterzone.demo.model.JwtRequest;
import com.craterzone.demo.model.JwtResoponse;
import com.craterzone.demo.service.DetailsService;


@RestController
public class JwtController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired 
	private DetailsService detailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/token")
	private ResponseEntity<?> generatetoken(@RequestBody  JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
		}
		catch (UsernameNotFoundException e)
		{
			e.printStackTrace();
			throw new Exception("Bad Cedentials");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Cedentials");

		}
		
	UserDetails userDetails =	this.detailsService.loadUserByUsername(jwtRequest.getUsername());
	
			String token = this.jwtUtil.generateToken(userDetails);
			System.out.println("JWT"+token);
			
			return ResponseEntity.ok(new JwtResoponse(token));
	}
	
	
}
