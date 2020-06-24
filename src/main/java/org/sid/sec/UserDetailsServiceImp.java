package org.sid.sec;

import java.util.ArrayList;
import java.util.List;

import org.sid.entities.User;
import org.sid.services.AccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired private AccountServiceImp service;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = service.loadUserByUsername(username);
		 if(user ==null ) throw new UsernameNotFoundException("User not found");
		 List<GrantedAuthority> authorities = new ArrayList<>();
		 user.getRoles().forEach(r->{
			 System.out.println("UserDetailsServiceImp :"+r);
			 authorities.add(new SimpleGrantedAuthority(r.getRolename()));
		 });
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}

 

}
