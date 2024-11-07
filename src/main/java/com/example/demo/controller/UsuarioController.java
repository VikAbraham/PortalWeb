package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping({"/listar/usuario"})
	public String listarUsuario(Model model) {
		List<Usuario> usuarios = usuarioService.findAll();
		
		model.addAttribute("usuario",usuarios);
		return "forms/Listar_suarios";
	}
}
