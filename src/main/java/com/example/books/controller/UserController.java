package com.example.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.model.User;
import com.example.books.service.UserService;



@RestController
public class UserController {
@Autowired
UserService usrService;

//http://localhost:8080/checkLogin
@PostMapping("/checkLogin")
	public String validateUser(@RequestBody User u)
	{
	System.out.println(u.getUsername());
		return usrService.validateUser(u.getUsername(),u.getPassword());
	}

//http://localhost:8080/addUser
@PostMapping("/addUser")
public User User(@RequestBody User u)
{
return usrService.saveUser(u);
}
}
