package com.jaken.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaken.sp.dao.UserDao;
import com.jaken.sp.entity.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public void save(User user){
		userDao.save(user);
	}
	
	public int count(User user){
		return userDao.countUser(user);
	} 
}
