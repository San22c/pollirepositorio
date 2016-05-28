
package com.planetvideo.videoclub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.planetvideo.videoclub.dao.UsuarioDao;
import com.planetvideo.videoclub.domain.Usuario;
import com.planetvideo.videoclub.form.Post;
import com.planetvideo.videoclub.repository.UsuarioRepository;

@Controller
public class Home {

	@Autowired
	private UsuarioDao  usuariodao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Usuario usuario) {
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute Usuario usuario) {
		
		boolean login = false;
		boolean admin = false;
		login = usuariodao.login(usuario.getUsername(), usuario.getPassword());
		if (login = true){
			admin = usuariodao.esAdmin(usuario.getUsername());
			if(admin = true){ 
				    return new ModelAndView("redirect:homeUsuarios");
				 }
			else{
				 return new ModelAndView("redirect:busquedaPeliculas");
			
			}
		}
		else{
			 return new ModelAndView("redirect:home");}
		
	}
 
	 
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
	public ModelAndView saveContact(@ModelAttribute Usuario usuario) {
	    usuariodao.saveOrUpdate(usuario);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteUsuario", method = RequestMethod.GET)
	public ModelAndView deleteUsuario(HttpServletRequest request) {
	    int usuarioid = Integer.parseInt(request.getParameter("idusuario"));
	    usuariodao.delete(usuarioid);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editUsuario", method = RequestMethod.GET)
	public ModelAndView editUsuario(HttpServletRequest request) {
	    int usuarioid = Integer.parseInt(request.getParameter("idusuario"));
	    Usuario usuario = usuariodao.get(usuarioid);
	    ModelAndView model = new ModelAndView("UsuarioForm");
	    model.addObject("usuario", usuario);
	 
	    return model;
	}
	
}
