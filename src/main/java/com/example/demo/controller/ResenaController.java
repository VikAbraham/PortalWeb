package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Resena;
import com.example.demo.serviceImpl.ResenaServiceImpl;

import jakarta.validation.Valid;


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
	

	@PostMapping("/agregar") //Utilizar @Valid para validar campos
	public String guardarResena(@Valid Resena resena,BindingResult result, Model model, RedirectAttributes flash) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Crear nueva reseña");
			System.out.println("Error");
			System.out.println(result.toString());
			return "forms/nueva-resena"; 
		}
		flash.addFlashAttribute("success", "Reseña agregada exitosamente");
		resenaService.save(resena);
		return "redirect:/resena/listar";
	}
	
	
	@GetMapping({ "/editar/{id}" })
	public String editarResena(@PathVariable("id") Long id,Model model, RedirectAttributes flash) {
		model.addAttribute("titulo", "Editar Reseña");
		Resena resena = resenaService.findOne(id);
		if(resena !=  null) {
			model.addAttribute("resena", resena);
			return "forms/nueva-resena";
		}else {
			flash.addFlashAttribute("error", "El ID del coctel no existe");
			return "redirect:/resena/listar";
		}
	}
	
	@GetMapping({ "/eliminar/{id}" })
	public String eliminarResena(@PathVariable("id") Long id,Model model, RedirectAttributes flash) {
		Resena resena = resenaService.findOne(id);
		if(resena !=  null) {
			resenaService.delete(id);
			flash.addFlashAttribute("success", "Reseña eliminada");
			return "redirect:/resena/listar";
		}else {
			flash.addFlashAttribute("error", "No se pudo eliminar");
			return "redirect:/resena/listar";
		}
	}
	

}
