package com.hcl.service;

import com.hcl.repository.UserRepository;
import com.hcl.to.UserTO;

public class UserService {
	
	public void saveUser(UserTO to) {
		
		UserRepository repository = new UserRepository();
		
		repository.saveUser(to);
	}
	
	public UserTO validate(String username, String password) {
		
		UserRepository repository = new UserRepository();
		
		UserTO to =  repository.getUser(username, password);
		
		return to;
	}

}
