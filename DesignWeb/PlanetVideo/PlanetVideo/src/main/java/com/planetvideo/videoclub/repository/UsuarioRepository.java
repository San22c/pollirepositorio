package com.planetvideo.videoclub.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import com.planetvideo.videoclub.domain.Usuario;

@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> { 
	 public Usuario findByUsername(String username);

}
