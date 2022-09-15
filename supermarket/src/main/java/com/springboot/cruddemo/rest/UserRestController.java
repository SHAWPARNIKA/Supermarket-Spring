package com.springboot.cruddemo.rest;

import java.util.List;
import java.util.Map;

import com.springboot.cruddemo.entity.User;
import com.springboot.cruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/displayUsers")
	public List<User> findAllUser(){
		return userService.findAll();
	}

	@GetMapping("/getById/{userId}")
	public ResponseEntity<User> getUser(@PathVariable int userId) {
		return ResponseEntity.ok(userService.findById(userId));
	}

	@DeleteMapping("/deleteById/{userId}")
	public String deleteUser(@PathVariable int userId) {
		User tempUser=userService.findById(userId);
		//throw exception if null
		if(tempUser==null){
			return "User id not found- "+userId;
		}
		userService.deleteById(userId);
		return "Deleted user id- "+userId;
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody Map<String,String> userInput){

		return userService.addUser(userInput);
	}
}
