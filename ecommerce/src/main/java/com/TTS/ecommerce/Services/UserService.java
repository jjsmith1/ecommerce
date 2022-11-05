package com.TTS.ecommerce.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.TTS.ecommerce.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public void saveExisting(User user) {
		userRepository.save(user);
	}
	
	public User getLoggedInUser() {
		return
				findByUsername(SecurityContextHolder.getContext(). getAuthentication().getName());
	}
 }
