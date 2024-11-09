package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Pelicula;
import com.example.demo.service.PeliculaService;
/**
 * Controlador para manejar solicitudes HTTP relacionados con el Entity Pelicula.java
 * 
 * */

@Controller
public class PeliculaController {
	@Autowired
	private PeliculaService peliculaService;
	/**
	 * Endpoint que maneja la ruta del navbar hacia Peliculas y lista todas las peliculas desde data.sql
	 * 
	 *  @param model que pasa los datos a la vista
	 *  @return a la vista donde se mostrarán las peliculas
	 * 
	 **/
	@GetMapping({"/pelicula"})
	public String listarPeliculas(Model model) {
		List<Pelicula> peliculas = peliculaService.findAll();
		
		model.addAttribute("peliculas",peliculas);
		return "forms/pelicula";
	}
	/**
	 *Endpoint que maneja la ruta del navbar,
	 *
	 * @return vista con un formulario donde se podrá agregar una nueva película
	 * 
	 **/
	
	
	@GetMapping({"/nueva-pelicula"})
	private String nuevaPelicula() {
		return "forms/nueva-pelicula";
	}
}
