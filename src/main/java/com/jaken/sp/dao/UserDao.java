package com.jaken.sp.dao;

import org.springframework.stereotype.Repository;

import com.jaken.sp.entity.User;

@Repository("userDao")
public interface UserDao {

	public void save(User user);
	
	public int countUser(User user);
}
