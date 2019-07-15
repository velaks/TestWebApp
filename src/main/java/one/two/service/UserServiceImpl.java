package one.two.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import one.two.domain.User;
import one.two.repository.UserRep;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private final UserRep userRep;
	
	
	public UserServiceImpl(UserRep userRep) {
		this.userRep = userRep;
	}

	@Override
	public User findUserById(Long id) {
		return userRep.findById(id).get();
	}

	@Override
	public List<User> findAllUsers() {
		return userRep.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userRep.save(user);
	}
    
    @Scheduled(fixedRate = 10000)
    public void doAwayStatus() {
        List<User> users = userRep.findAll();
        LocalTime time = LocalTime.now();
        
        for(User u : users) {
        	if(u.getStatus().equals("Online") && 
        	time.isAfter(u.getTime().plusMinutes(5))) {
        		
        		u.setStatus("Away");
        		userRep.save(u);
        	}
        }
    }
    
}
