package one.two.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.two.domain.ResponseStatus;
import one.two.domain.User;
import one.two.service.UserService;

@RestController
@RequestMapping(produces = "application/json", path = "/api/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
			return userService.findUserById(id);
	}
	
	@PostMapping
	public Long saveUser(@RequestBody User user) {
			LocalTime time = LocalTime.now();
			user.setTime(time);
			return userService.saveUser(user).getId();
	}
	
	@PutMapping("/{id}/{status}")
	public ResponseStatus updateStatus(@PathVariable Long id, @PathVariable String status) {
		
		ResponseStatus reStatus =  new ResponseStatus(id, status, userService.findUserById(id).getStatus());
		User user = userService.findUserById(id);
		if(!status.equals("Online") && 
				!status.equals("Offline") && 
				!status.equals("Away")) {
			System.out.println("Wrong word " + status);	
		} else if (status.equals("Online")) {
			LocalTime time = LocalTime.now();
			user.setStatus(status);
			user.setTime(time);
			userService.saveUser(user);	
		} else {	
	    	user.setStatus(status);
	    	userService.saveUser(user);
		}
		return reStatus;
	}
}
