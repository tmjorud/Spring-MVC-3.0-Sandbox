package com.demotape.user;

import java.util.Collection;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository("userDao")	//This will make easier to autowire
@Transactional
public class UserDaoImpl implements UserDao{

	Md5PasswordEncoder e = new Md5PasswordEncoder();

	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	public Users loadUser(long id) {
		return this.em.find(Users.class, id);
	}
	
	@Transactional(readOnly = true)
	public Users loadUserByUsername(String username){
		try{
			return (Users)em.createQuery("SELECT user FROM Users user WHERE user.username=?1").setParameter(1, username).getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public Collection<Users> getAllUsers() {
		return em.createQuery("SELECT user FROM Users user ORDER BY user.nick").getResultList();
	}

	@Transactional(readOnly = false)
	public Users saveUser(Users user) {
		user.setPassword(e.encodePassword(user.getPassword(),null));
		em.persist(user);
	    return user;
	}
	
	@Transactional(readOnly = false)
	public Users updateUser(Users user) {
		em.merge(user);
	    return user;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Transactional(readOnly = false)
	public void deleteUser(long id) {
		Users user = loadUser(id);
		this.em.remove(user);
	}
}
