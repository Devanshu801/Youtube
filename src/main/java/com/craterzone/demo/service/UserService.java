package com.craterzone.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craterzone.demo.dao.AddressDao;
import com.craterzone.demo.dao.UserDao;
import com.craterzone.demo.mapper.UserMapper;
import com.craterzone.demo.model.Address;
import com.craterzone.demo.model.User;
import com.craterzone.demo.repositry.UserRepositry;

@Service
public class UserService {
	@Autowired
	private	UserRepositry userRepositry;
	
	
	public Optional<User> login(User user){
		Optional<UserDao> userid = userRepositry.findByEmail(user.getEmail());
		if(userid.isPresent()) {
			if(userid.get().getEmailPassword().equals(user.getEmailPassword())) {
				return Optional.of(UserMapper.UserDaoToUser(userid.get()));
			}
		}
	
		return null;
	}
	public Optional<User> registerUser(User user){
		Optional<UserDao> userExists = userRepositry.findByEmail(user.getEmail());
		if(userExists.isPresent()) {
			return null;
		}
		UserDao userDao = UserMapper.UserToUserDao(user);
		AddressDao addressDao = UserMapper.AddressToAddressDao(user.getAddress());
		addressDao.setUser(userDao);
		userDao = userRepositry.save(userDao);
		return Optional.of(user);	
		}
	public Optional<List<User>> getAll(){
		List<UserDao> userdao =userRepositry.findAll();
		return Optional.of(UserMapper.UserdbListtoUserList(userdao));
	}
	public Optional<User> updateAddress(int id,Address address){
		Optional<UserDao> user = userRepositry.findById(id);
		if(user.isPresent()) {
			user.get().setAddress(UserMapper.AddressToAddressDao(address));
			userRepositry.save(user.get());
		}
		return Optional.of(UserMapper.UserDaoToUser(user.get()));
	}
	
	
		public void deleteById(int id) {
		Optional<UserDao> user = userRepositry.findById(id);
		if(user.isPresent()) {
		userRepositry.deleteById(id);
		}
		return;
		}
}
