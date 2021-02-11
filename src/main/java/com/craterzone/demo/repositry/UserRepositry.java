package com.craterzone.demo.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.craterzone.demo.dao.UserDao;

public interface UserRepositry extends JpaRepository<UserDao, Integer> {
	Optional<UserDao> findByEmail(String email);
	
}
