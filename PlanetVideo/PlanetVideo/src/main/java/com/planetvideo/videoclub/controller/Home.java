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
 
	 
	@RequestMapping(value = "/newUsuario", method = RequestMethod.GET)
	public ModelAndView newUsuario(ModelAndView model) {
	    Usuario newUsuario = new Usuario();
	    model.addObject("usuario", newUsuario);
	    model.setViewName("UsuarioForm");
	    return model;
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView listUsuario(ModelAndView model) throws IOException{
		List<Usuario> listUsuarios = usuariodao.list();
	    model.addObject("listContact", listUsuarios);
	    model.setViewName("home");
	    return model;
	}
	
	@RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute Usuario usuario) {
	    usuariodao.saveOrUpdate(usuario);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteUsuario", method = RequestMethod.GET)
	public ModelAndView deleteUsuario(HttpServletRequest request) {
	    int usuarioid = Integer.parseInt(request.getParameter("id"));
	    usuariodao.delete(usuarioid);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editUsuario", method = RequestMethod.GET)
	public ModelAndView editUsuario(HttpServletRequest request) {
	    int usuarioid = Integer.parseInt(request.getParameter("id"));
	    Usuario usuario = usuariodao.get(usuarioid);
	    ModelAndView model = new ModelAndView("UsuarioForm");
	    model.addObject("usuario", usuario);
	 
	    return model;
	}
	
}
