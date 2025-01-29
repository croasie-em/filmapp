package com.demo.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.usermanagement.entity.User;
import com.demo.usermanagement.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;

	public User registerUser(User user) {
		return repo.save(user);

	}

    public Optional<User> getUserByUsername(String username) {
        return repo.findByUsername(username); 
    }

    public List<User> getAllUsers() {
        return repo.findAll(); 
    }
	
	

}
