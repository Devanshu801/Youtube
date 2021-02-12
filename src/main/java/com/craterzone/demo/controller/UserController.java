package com.craterzone.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.craterzone.demo.model.Address;
import com.craterzone.demo.model.User;
import com.craterzone.demo.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	
	
	@Autowired
	private UserService userService;


	//get getAll
/*
	@GetMapping("/user")
	private ResponseEntity<Optional<List<User>>> getAll(){
		Optional<List<User>> userid = userService.getAll();
		if(userid!=null) 
			return ResponseEntity.status(HttpStatus.OK).body(userid);
	
			return ResponseEntity.noContent().build();
	 }
	*/

	
	@DeleteMapping("{id}")
	private ResponseEntity<User> deleteUser(@PathVariable("id") int id){
		if(!Objects.isNull(id)) {
		userService.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
	}
		return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("")
	private ResponseEntity<User> registerUser(@RequestBody User user){
		//validation
		Optional<User> userfromdatabase = userService.registerUser(user);
		if(!Objects.isNull(userfromdatabase)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		}
		return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}
	@PostMapping("/login")
	private ResponseEntity<Optional<User>> login(@RequestBody User user){
		//validation
		Optional<User> userdb = userService.login(user);
		if(userdb!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(userdb);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	@PatchMapping("{id}/Address")
	private ResponseEntity updateAddress(@PathVariable("id") int id,@RequestBody Address address) {
		Optional<User> addres = userService.updateAddress(id, address);
		if(addres.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(addres);
		}
		return ResponseEntity.badRequest().build();
	}
	
}
