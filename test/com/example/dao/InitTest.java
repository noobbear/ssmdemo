package com.example.dao;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.entity.User;
import com.example.service.IUserService;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class InitTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private IUserService UserServiceImpl;
	
	@Test
	public void testDataSource() {
//		System.out.println(dataSource);
		List<User> userList = UserServiceImpl.getUserList();
		for (User user : userList) {
			System.out.println(user);
		}
	}

}
