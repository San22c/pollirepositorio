package com.planetvideo.videoclub.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	 
	private String username;
	 @NotNull
	 
	private String password;
	public Usuario() {}
	
	public Usuario(int id) {
		 this.id = id;
	}
	
	public Usuario(String username, String password) {
		 
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
	
	
}
