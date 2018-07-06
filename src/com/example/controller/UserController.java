package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.IUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/getUserList")
	public String getUserList(ModelMap map) {
		map.put("userList",userService.getUserList());
		return "userList";
	}
	
	@RequestMapping(value = "/deleteUser/{id}")
	public String deleteUser(@PathVariable("id")Integer id) {
		System.out.println("UserController.deleteUser() id:"+id);
		List<User> userList = userService.getUserList();
		for (User user : userList) {
			// 1.先要找到用户传递的id
			if(id.equals(user.getId())){
				userList.remove(user); // 在集合删除的时候不能修改结构
				break;
			}
		}
		return "redirect:../getUserList";
	}
	
	@RequestMapping(value = "/getUserById/{id}")
	public String getUserById(@PathVariable("id")Integer id,ModelMap map) {
	
		// 1.获取用户集合
		List<User> userList = userService.getUserList();
		
		for (User user : userList) {
			if(id.equals(user.getId())){
				map.put("user", user);
				break;
			}
		}
		return "updateUser";
	}
	
	
	@RequestMapping(value = "/updateUser")
	public String updateUser(User user) {
		System.out.println("UserController.updateUser():"+user);
		return "redirect:getUserList";
	}
}
