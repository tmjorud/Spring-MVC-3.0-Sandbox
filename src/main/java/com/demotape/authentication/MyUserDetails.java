package com.demotape.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = -2101939031003054522L;
	private Collection<GrantedAuthority> authorities = null;
	private String password = null;
	private String username = null;
	private long userid = 0;
	private String nick = null;

	public MyUserDetails(Collection<GrantedAuthority> authorities, String password, String username, long userid, String nick) {
		super();
		this.authorities = authorities;
		this.password = password;
		this.username = username;
		this.userid = userid;
		this.nick = nick;
	}

	public Collection<GrantedAuthority> getAuthorities() { return authorities; }
	public String getPassword() { return password; }
	public String getUsername() { return username; }
	public long getUserid() { return userid; }
	public String getNick() { return nick; }

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}	
}
