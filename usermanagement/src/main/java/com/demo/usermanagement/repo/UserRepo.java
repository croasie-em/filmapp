package com.demo.usermanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.usermanagement.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	// Find user by username using optional to avoid null pointer exceptions later on
	Optional<User> findByUsername(String username);
	
    // Find user by email
    Optional<User> findByEmail(String email);
	

}
