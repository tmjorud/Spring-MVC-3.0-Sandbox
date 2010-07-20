package com.demotape.user;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name="Users")
@Table(name = "users")
public class Users implements Serializable{

	private static final long serialVersionUID = -3320318353584002452L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="password", nullable=false)
	@NotEmpty(message="Password is a required field")
	private String password;
	
	@SuppressWarnings("unused")
	@Transient
	private String email;
	
	@Column(name="username", nullable=false)
	@NotEmpty(message = "Email is a required field") @Pattern(regexp = "^[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$", message = "Email is not valid")
	//@Email (message = "Email is not valid")
	private String username;
	
	@Column(name = "authority", nullable=false)
	private String authority;
	
	@Column(name="nick", nullable=false)
	@NotEmpty(message="Nick is a required field")
	private String nick;
	
	@Column(name="acceptedTerms", nullable=false)
	@AssertTrue(message="You have to accept the terms")
	private boolean acceptedTerms;
	
	public Users(){}

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public String getEmail() { return username; }
	//public void setEmail(String email) { this.email = email; }

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getAuthority() { return authority; }
	public void setAuthority(String authority) { this.authority = authority; }

	public String getNick() { return nick; }
	public void setNick(String nick) { this.nick = nick; }

	public boolean getAcceptedTerms() { return acceptedTerms; }
	public void setAcceptedTerms(boolean acceptedTerms) { this.acceptedTerms = acceptedTerms; }
}
