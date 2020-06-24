package org.sid.services;


import org.sid.entities.Role;
import org.sid.entities.User;

public interface AccountService {

	
	public User saveUser(String username, String password, String repassword);
	
	public Role saveRole(String rolename);
	
	public void AddRoleToUser(String username, String rolename);

}
