package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Pelicula;
import com.example.demo.service.PeliculaService;

@Controller
public class PeliculaController {
	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping({"/listar"})
	public String listarPeliculas(Model model) {
		List<Pelicula> peliculas = peliculaService.findAll();
		
		model.addAttribute("peliculas",peliculas);
		return "forms/listar";
	}
}
