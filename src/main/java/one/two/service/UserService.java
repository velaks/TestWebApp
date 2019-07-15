package one.two.service;

import java.util.List;

import one.two.domain.User;

public interface UserService  {
	
	User findUserById(Long id);
	List<User> findAllUsers();
	User saveUser(User user);
}
