package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Resena;
import com.example.demo.entity.Usuario;
import com.example.demo.serviceImpl.UsuarioServiceImpl;

import jakarta.validation.Valid;

/**
 * Controlador para manejar solicitudes HTTP relacionados con el Entity Usuario.java
 * 
 * */

@Controller
@RequestMapping ("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired // Inject the password encoder bean
    private BCryptPasswordEncoder passwordEncoder;
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
	
	@GetMapping("/registrar")
	public String mostrarFormulario(Model model) {
	    model.addAttribute("usuario", new Usuario());
	    return "forms/nuevo-usuario"; 
	}
	
	@PostMapping("/agregar")
	public String guardarUsuario(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			System.out.println("Error");
			System.out.println(result.toString());
			model.addAttribute("usuario", usuario);
			return "forms/nuevo-usuario"; 
		}
		usuario.setPass(passwordEncoder.encode(usuario.getPass()));
		
		usuarioService.save(usuario);
		System.out.println(usuario.getNombre());
		System.out.println(usuario.getPass());
		flash.addFlashAttribute("success", "Usuario creado exitosamente");
		return "redirect:/index";
	}

	
}
