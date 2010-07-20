package com.demotape.authentication;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demotape.user.UserDao;
import com.demotape.user.Users;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao userDAO;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		Users user = userDAO.loadUserByUsername(username);
		UserDetails userDetails = null;
		
		if(user!=null){
			GrantedAuthority authority = new MyGrantedAuthority(user.getAuthority());
			Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(authority);
			userDetails = new MyUserDetails(authorities, user.getPassword(), user.getUsername(), user.getId(), user.getNick());
		}
		return userDetails;
	}
}
