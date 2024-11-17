package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Resena;
import com.example.demo.service.ResenaService;
import com.example.demo.serviceImpl.ResenaServiceImpl;

/**
 * Controlador para manejar solicitudes HTTP relacionados con el Entity
 * Resenas.java
 * 
 */

@Controller
@RequestMapping("/resena")
public class ResenaController {

	@Autowired
	private ResenaServiceImpl resenaService;

	/**
	 * Endpoint que maneja la ruta del navbar hacia Resenas y lista todas las
	 * reseñas desde data.sql
	 * 
	 * @param model que pasa los datos a la vista
	 * @return a la vista donde se mostrarán las resenas
	 * 
	 **/
	@GetMapping({ "/listar" })
	public String listarResena(Model model) {
		List<Resena> resenas = resenaService.findAll();

		model.addAttribute("resenas", resenas);
		return "forms/resena";
	}

	/**
	 * Endpoint que maneja la ruta del navbar,
	 *
	 * @return vista con un formulario donde se podrá agregar una nueva reseña
	 * 
	 **/
	@GetMapping({ "/nuevaResena" })
	public String nuevaResena(Model model) {
		model.addAttribute("titulo", "Nueva Reseña");
		model.addAttribute("resena", new Resena());
		return "forms/nueva-resena";
	}

	@PostMapping("/agregar")
	public String guardarResena(@ModelAttribute Resena resena) {
		resenaService.save(resena);
		return "redirect:/resena/listar";
	}
	
	@GetMapping({ "/editar/{id}" })
	public String editarResena(@PathVariable("id") Long id,Model model) {
		model.addAttribute("titulo", "Editar Reseña");
		Resena resena = resenaService.findOne(id);
		if(resena !=  null) {
			model.addAttribute("resena", resena);
			return "forms/nueva-resena";
		}else {
			return "redirect:/resena";
		}
	}
	
	@GetMapping({ "/eliminar/{id}" })
	public String eliminarResena(@PathVariable("id") Long id,Model model) {
		Resena resena = resenaService.findOne(id);
		if(resena !=  null) {
			resenaService.delete(id);
			return "redirect:/resena/listar";
		}else {
			return "redirect:/resena/listar";
		}
	}
	

}
