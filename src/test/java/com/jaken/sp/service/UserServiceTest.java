package com.jaken.sp.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jaken.sp.config.RootConfig;
import com.jaken.sp.entity.User;
import com.jaken.sp.util.CommonUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testsave(){
		User user=new User(CommonUtil.getUUID(),"张小白",32);
		userService.save(user);
	}
}
