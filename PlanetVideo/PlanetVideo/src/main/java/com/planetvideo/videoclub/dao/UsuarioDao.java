package com.planetvideo.videoclub.dao;

import java.util.List;

import com.planetvideo.videoclub.domain.Usuario;

public interface UsuarioDao {
	   public void saveOrUpdate(Usuario usuario);
	     
	    public void delete(int usuarioid);
	     
	    public Usuario get(int usuarioid);
	     
	    public List<Usuario> list();
}
