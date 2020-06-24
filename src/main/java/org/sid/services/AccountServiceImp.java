package org.sid.services;

import org.sid.dao.RoleRepo;
import org.sid.dao.UserRepo;
import org.sid.entities.Role;
import org.sid.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

	@Autowired
	private RoleRepo roleRepo;
	@Autowired
	private UserRepo userRepo;

	@Override
	public User saveUser(String username, String password, String repassword) {
		User user = (User) userRepo.findByUsername(username);
		if (user != null)
			throw new RuntimeException("compte d'eja exist !!");
		if (!password.equals(repassword))
			throw new RuntimeException("confirmer votre password !!");
		User user2 = new User();
		user2.setUsername(username);
		user2.setPassword(encoder().encode(password));
		user2.setActive(true);
		userRepo.save(user2);
		AddRoleToUser(username, "USER");
		return user2;
	}

	@Override
	public Role saveRole(String rolename) {
		Role role = roleRepo.findByRolename(rolename);
		if (role == null) {
			return roleRepo.save(new Role(rolename));
		} else {
			System.out.println("role deja exist ");
		}
		return role;
	}

	@Override
	public void AddRoleToUser(String username, String rolename) {
		Role role = roleRepo.findByRolename(rolename);
		User user = loadUserByUsername(username);
		if (role != null && user != null) {
			user.getRoles().add(role);
		}
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	public User loadUserByUsername(String username) {

		return (User) userRepo.findByUsername(username);
	}
}
