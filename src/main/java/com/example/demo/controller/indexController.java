package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador que maneja la solicitud HTTP para el proyecto Resumen y Reseñas
 * Proporciona un endpoint para inicializar en la página web principal
 * 
 * @author Sebastián Arriagada & Victor Silva
 * @version 1.0
 * 
 * */

@Controller
public class indexController {
	@GetMapping({"/","index"})
	public String inicio(Model model) {
		return "index";
	}
	
}
