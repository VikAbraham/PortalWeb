package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

/**
 * Controlador para manejar solicitudes HTTP relacionados con el Entity Usuario.java
 * 
 * */

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Endpoint que maneja la ruta del navbar hacia Usuarios y lista todos los usuarios desde data.sql
	 * 
	 *  @param model que pasa los datos a la vista
	 *  @return a la vista donde se podrán mostrar los usuarios, sin implementar aún
	 * 
	 **/
	
	@GetMapping({"/listar/usuario"})
	public String listarUsuario(Model model) {
		List<Usuario> usuarios = usuarioService.findAll();
		
		model.addAttribute("usuario",usuarios);
		return "/index";
	}
	/**
	 *Endpoint que maneja la ruta del navbar,
	 *
	 * @return vista con un formulario donde se podrá agregar un nuevo usuario
	 * 
	 **/
	
	@GetMapping({"usuario"})
	public String usuario(Model model) {
		return "forms/usuario";
	}
	
}
