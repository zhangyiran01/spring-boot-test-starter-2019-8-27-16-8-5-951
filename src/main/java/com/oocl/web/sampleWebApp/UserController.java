package com.oocl.web.sampleWebApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	private static List<User> users = new ArrayList<User>();
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		users.add(user);
		return ResponseEntity.created(null).build();
	}

}
