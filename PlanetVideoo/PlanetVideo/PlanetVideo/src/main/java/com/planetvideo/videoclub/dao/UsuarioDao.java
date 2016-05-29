package com.planetvideo.videoclub.dao;

import java.util.List;

import com.planetvideo.videoclub.domain.Usuario;

public interface UsuarioDao {
	   public void saveOrUpdate(Usuario usuario);
	     
	    public void delete(String username);
	     
	    public Usuario get(int usuarioid);
	     
	    public List<Usuario> list();
	    
	    public boolean login(String username, String password);
	    public boolean esAdmin(String username);
}
