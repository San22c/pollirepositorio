package com.planetvideo.videoclub.form;

import javax.validation.constraints.Size;

public class Post {
	
	@Size(min=4, max=10)
	private String username;
	
	@Size(min=6, max= 10)
	private String password;

	public String getUsername() {
		return username;
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
