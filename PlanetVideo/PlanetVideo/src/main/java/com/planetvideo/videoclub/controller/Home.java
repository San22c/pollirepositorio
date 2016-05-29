
package com.planetvideo.videoclub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.planetvideo.videoclub.dao.PeliculaDao;
import com.planetvideo.videoclub.dao.UsuarioDao;
import com.planetvideo.videoclub.domain.Pelicula;
import com.planetvideo.videoclub.domain.Usuario; 

@Controller
public class Home {

	@Autowired
	private UsuarioDao  usuariodao;
	
	@Autowired
	private PeliculaDao  peliculadao;
	
	
	 
  	/**
  	 * 
  	 *  
  	 * INICIO
  	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Usuario usuario) {
		return "home";
	}
	

  
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Usuario usuario) {
		
		boolean login = false;
		boolean admin = false;
		login = usuariodao.login(usuario.getUsername(), usuario.getPassword());
		if (login == true){
			admin = usuariodao.esAdmin(usuario.getUsername());
			if(admin == true){ 
				    return new ModelAndView("redirect:homeUsuarios");
				 }
			else{
				 return new ModelAndView("redirect:busquedaPeliculas");
			
			}
		}
		else{
			 return new ModelAndView("redirect:/");}
		
	}
	
	
	/**
  	 * 
  	 *  
  	 * USUARIOS
  	 */
	
	
	
  	@RequestMapping(value = "/newUsuario", method = RequestMethod.GET)
	public ModelAndView newUsuario(ModelAndView model) {
	    Usuario newUsuario = new Usuario();
	    model.addObject("usuario", newUsuario);
	    model.setViewName("UsuarioForm");
	    return model;
	}
	
  	@RequestMapping(value = "/homeUsuarios", method = RequestMethod.GET)
	public ModelAndView listUsuario(ModelAndView model) throws IOException{
		List<Usuario> listUsuarios = usuariodao.list();
	    model.addObject("listUsuarios", listUsuarios);
	    model.setViewName("homeUsuarios");
	    return model;
	}
  	
  	@RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
	public ModelAndView saveUsuario(@ModelAttribute Usuario usuario) {
	    
  		usuariodao.save(usuario);
	    return new ModelAndView("redirect:homeUsuarios");
	}
  	
  	@RequestMapping(value = "/updateUsuario", method = RequestMethod.POST)
	public ModelAndView updateUsuario(@ModelAttribute Usuario usuario) {
	    usuariodao.edit(usuario);
	    return new ModelAndView("redirect:homeUsuarios");
	}
  	
  	@RequestMapping(value = "/deleteUsuario/{username}", method = RequestMethod.GET)
	public String deleteUsuario(@PathVariable String username) {
 	    usuariodao.delete(username);
 	   return "redirect:/homeUsuarios";
	}
  	@RequestMapping(value = "/editUsuario/{username}", method = RequestMethod.GET)
	public ModelAndView editUsuario(@PathVariable String username) {
	    Usuario usuario = usuariodao.get(username); 
	    ModelAndView model = new ModelAndView("EditUsuario");
		model.addObject("usuario", usuario);
	    return model;

	} 

  	 
  	@RequestMapping(value = "/homePeliculas", method = RequestMethod.GET)
	public ModelAndView listPeliculas(ModelAndView model) throws IOException{
		List<Pelicula> listPeliculas = peliculadao.list();
	    model.addObject("listPeliculas", listPeliculas);
	    model.setViewName("homePeliculas");
	    return model;
	}
  	
  	
  	
  	@RequestMapping(value = "/deletePelicula/{nombre}", method = RequestMethod.GET)
	public String deletePelicula(@PathVariable String nombre) {
 	    peliculadao.delete(nombre);
 	   return "redirect:/homePeliculas";
	}
  	
  	@RequestMapping(value = "/editPelicula/{nombre}", method = RequestMethod.GET)
	public ModelAndView editPelicula(@PathVariable String nombre) {
	    Pelicula pelicula = peliculadao.get(nombre); 
	    ModelAndView model = new ModelAndView("EditPelicula");
		model.addObject("pelicula", pelicula);
	    return model;

	}
  	
	@RequestMapping(value = "/newPelicula", method = RequestMethod.GET)
	public ModelAndView newPelicula(ModelAndView model) {
	    Pelicula newPelicula = new Pelicula();
	    model.addObject("usuario", newPelicula);
	    model.setViewName("PeliculaForm");
	    return model;
	}
  	
	@RequestMapping(value = "/savePelicula", method = RequestMethod.POST)
	public ModelAndView savePelicula(@ModelAttribute Pelicula pelicula) {
	    
  		peliculadao.save(pelicula);
	    return new ModelAndView("redirect:homePeliculas");
	}
  	
  	@RequestMapping(value = "/updatePelicula", method = RequestMethod.POST)
	public ModelAndView updatePelicula(@ModelAttribute Pelicula pelicula) {
	    peliculadao.edit(pelicula);
	    return new ModelAndView("redirect:homePeliculas");
	}
	
  	@RequestMapping(value = "/verPelicula/{nombre}", method = RequestMethod.GET)
	public ModelAndView verPelicula(@PathVariable String nombre) {
	    Pelicula pelicula = peliculadao.get(nombre); 
	    ModelAndView model = new ModelAndView("verPelicula");
		model.addObject("pelicula", pelicula);
	    return model;

	}
  	
  	@RequestMapping(value = "/verPeliculaUsuario/{nombre}", method = RequestMethod.GET)
	public ModelAndView verPeliculaUsuario(@PathVariable String nombre) {
	    Pelicula pelicula = peliculadao.get(nombre); 
	    ModelAndView model = new ModelAndView("verPelicula1");
		model.addObject("pelicula", pelicula);
	    return model;

	}

	@RequestMapping(value = "/busquedaPeliculas", method = RequestMethod.GET)
	public ModelAndView busquedaPeliculas(ModelAndView model) throws IOException{
		List<Pelicula> listPeliculas = peliculadao.list();
	    model.addObject("listPeliculas", listPeliculas);
	    model.setViewName("busquedaPeliculas");
	    return model;
	}
  	
  	
  	
}
