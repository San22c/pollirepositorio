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
	private int idusuario;
	
	@Size(min=4, max= 6)
	@NotNull
	private String username;
	

	@Size(min=4, max= 6)
	@NotNull
	private String password;
	
	@NotNull
	@Size(min=1, max= 1)
	private String admin;
	public Usuario() {}
	
	public Usuario(int idusuario) {
		 this.idusuario = idusuario;
	}
	
	public Usuario(String username, String password, String admin) {
		 
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public String getUsername() {
		return username;
	}

	 public String getAdmin() {
			return admin;
		}

		public void setAdmin(String admin) {
			this.admin = admin;
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

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	
	
	
	
}
