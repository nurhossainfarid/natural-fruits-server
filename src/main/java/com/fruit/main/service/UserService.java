package com.fruit.main.service;

import com.fruit.main.exception.UserException;
import com.fruit.main.modal.User;

public interface UserService {
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
}
