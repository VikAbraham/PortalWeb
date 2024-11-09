package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Resena;
import com.example.demo.service.ResenaService;

/**
 * Controlador para manejar solicitudes HTTP relacionados con el Entity Resenas.java
 * 
 * */

@Controller
public class ResenaController {
	
	@Autowired
	private ResenaService resenaService;
	/**
	 * Endpoint que maneja la ruta del navbar hacia Resenas y lista todas las reseñas desde data.sql
	 * 
	 *  @param model que pasa los datos a la vista
	 *  @return a la vista donde se mostrarán las resenas
	 * 
	 **/
	@GetMapping({"/resena"})
	public String listarResena(Model model) {
		List<Resena> resenas = resenaService.findAll();
		
		model.addAttribute("resenas",resenas);
		return "forms/resena";
	}
	
	/**
	 *Endpoint que maneja la ruta del navbar,
	 *
	 * @return vista con un formulario donde se podrá agregar una nueva reseña
	 * 
	 **/
	@GetMapping({"/nueva-resena"})
		public String nuevaResena() {
			return "forms/nueva-resena";
		}
	
}
