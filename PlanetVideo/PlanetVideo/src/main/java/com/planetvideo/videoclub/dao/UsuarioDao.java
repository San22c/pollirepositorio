package com.planetvideo.videoclub.dao;

import java.util.List;

import com.planetvideo.videoclub.domain.Usuario;

public interface UsuarioDao {
	   public void save (Usuario usuario);
	   public void edit (Usuario usuario); 
	    public void delete(String username);
	     
	    public Usuario get(String username);
	     
	    public List<Usuario> list();
	    
	    public boolean login(String username, String password);
	    public boolean esAdmin(String username);
}
