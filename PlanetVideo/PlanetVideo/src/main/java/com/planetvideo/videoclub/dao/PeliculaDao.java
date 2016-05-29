package com.planetvideo.videoclub.dao;

import java.util.List;

import com.planetvideo.videoclub.domain.Pelicula;
import com.planetvideo.videoclub.domain.Usuario;


public interface PeliculaDao {
	    
	    public void save (Pelicula pelicula);
		public void edit (Pelicula pelicula); 
		public void delete(String nombre);
	    public Pelicula get(String nombre);	     
		public List<Pelicula> list();
		 
	    
	    
}
