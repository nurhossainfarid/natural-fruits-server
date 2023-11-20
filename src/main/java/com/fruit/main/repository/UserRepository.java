package com.fruit.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fruit.main.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);
}
