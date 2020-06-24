package org.sid.controller;

import org.sid.dao.UserRepo;
import org.sid.entities.User;
import org.sid.services.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired private AccountServiceImp service;
	@Autowired private UserRepo userRepo;
	
	
	@PostMapping("/register")
	public User register(@RequestBody FormRegister formRegister) {
		
		User user =service.saveUser(formRegister.getUsername(), formRegister.getPassword(), formRegister.getRepassword());
		return user;
	}
	@PostMapping("/users/addRoleAdminToUser/{id}")
	public boolean addRoleAdminToUser(@PathVariable(name = "id") int id) {
		User user =(User) userRepo.findById(id).get();
		 service.AddRoleToUser(user.getUsername(), "ADMIN");
		 return true;
	}
	
	@PatchMapping("/users/disActiveUser/{id}")
	public User disAblePersonne(@PathVariable(name = "id") int id) {
		 User user = userRepo.findById(id).get();
		 user.setActive(!user.isActive()); 
		 userRepo.save(user); 
		 return user;
	}
	
}
class FormRegister{
	
	private String username;

	private String password;

	private String repassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	
}
