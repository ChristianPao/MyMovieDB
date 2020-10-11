package com.pao.moviedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword("{bcrypt}"+encoder.encode(user.getPassword()));
		
		userRepository.save(user);
	}
	
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
