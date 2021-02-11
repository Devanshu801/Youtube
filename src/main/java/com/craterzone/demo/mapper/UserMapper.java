package com.craterzone.demo.mapper;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import com.craterzone.demo.dao.AddressDao;
import com.craterzone.demo.dao.UserDao;
import com.craterzone.demo.model.Address;
import com.craterzone.demo.model.User;

public class UserMapper {
	
	public static User UserDaoToUser(UserDao userdao) {
		User user = new User();
		BeanUtils.copyProperties(userdao, user);
		user.setAddress(UserMapper.AddressDaoToAddress(userdao.getAddress()));
		return  user;
	}
	public static AddressDao AddressToAddressDao(Address address) {
		AddressDao addressDao = new AddressDao();
		BeanUtils.copyProperties(address, addressDao);
		return addressDao;	
	}	
	public static Address AddressDaoToAddress(AddressDao addressdao) {
		Address address = new Address();
		BeanUtils.copyProperties(addressdao,address);
		return address;	
	}
	public static UserDao UserToUserDao(User user) {
		UserDao userdao = new UserDao();
		BeanUtils.copyProperties(user, userdao); 
		userdao.setAddress(UserMapper.AddressToAddressDao(user.getAddress()));
		userdao.getAddress().setUser(userdao);
		return  userdao;
	}
	/*
	public static List<User> UserdbListtoUserList(List<UserDao> list){
		return list.stream().map(x -> UserDaoToUser(x)).collect(Collectors.toList());
	}
	*/
}
