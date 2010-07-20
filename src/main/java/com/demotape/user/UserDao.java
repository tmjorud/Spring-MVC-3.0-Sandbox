package com.demotape.user;

import java.util.Collection;

public interface UserDao {
	public Users loadUser(long id);
	public Users loadUserByUsername(String username);
	public Collection<Users> getAllUsers();
	public Users saveUser(Users user);
	public Users updateUser(Users user);
	public void deleteUser(long id);
}
