package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Pelicula;
import com.example.demo.serviceImpl.PeliculaServiceImpl;

import jakarta.validation.Valid;

/**
 * Controlador para manejar solicitudes HTTP relacionados con el Entity
 * Pelicula.java
 * 
 */

@Controller
@RequestMapping("/pelicula")
public class PeliculaController {
	@Autowired
	private PeliculaServiceImpl peliculaService;

	/**
	 * Endpoint que maneja la ruta del navbar hacia Peliculas y lista todas las
	 * peliculas desde data.sql
	 * 
	 * @param model que pasa los datos a la vista
	 * @return a la vista donde se mostrarán las peliculas
	 * 
	 **/

	@GetMapping({ "/peliculas" })
	public String listarPeliculas(Model model) {
		List<Pelicula> peliculas = peliculaService.findAll();

		model.addAttribute("peliculas", peliculas);
		return "forms/pelicula";
	}

	/**
	 * Endpoint que maneja la ruta del navbar,
	 *
	 * @return vista con un formulario donde se podrá agregar una nueva película
	 * 
	 **/

	@GetMapping({ "/nueva-pelicula" })
	private String nuevaPelicula(Model model) {
		model.addAttribute("pelicula", new Pelicula());
		return "forms/nueva-pelicula";
	}

	@PostMapping("/agregar")
	public String guardarPelicula(@Valid Pelicula pelicula, BindingResult result, Model model,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			System.out.println("Error");
			System.out.println(result.toString());
			return "forms/nueva-pelicula";
		}
		flash.addFlashAttribute("success", "Pelicula agregada exitosamente");
		peliculaService.save(pelicula);
		return "redirect:/pelicula/peliculas";
	}

	@GetMapping({ "/editar/{id}" })
	public String editarPelicula(@PathVariable("id") Long id, Model model, RedirectAttributes flash) {
		Pelicula pelicula = peliculaService.findOne(id);
		if (pelicula != null) {
			model.addAttribute("pelicula", pelicula);
			return "forms/nueva-pelicula";
		} else {
			flash.addFlashAttribute("error", "El ID no existe");
			return "redirect:/pelicula/peliculas";
		}
	}

	@GetMapping({ "/eliminar/{id}" })
	public String eliminarPelicula(@PathVariable("id") Long id, Model model, RedirectAttributes flash) {
		//Probar si se puede existe la ID para eliminar 
		try {
			Pelicula pelicula = peliculaService.findOne(id);
			if (pelicula != null) {
				System.out.println(pelicula);

				peliculaService.delete(id);
				flash.addFlashAttribute("success", "Pelicula eliminada");
			} else {
				flash.addFlashAttribute("warning", "La pelicula que deseas eliminar no existe");

			}
		} catch (DataIntegrityViolationException e) {
			// Captura el error específico relacionado con la integridad referencial
			flash.addFlashAttribute("error",
					"No se puede eliminar la película porque está asociada a otros registros");
		} catch (Exception e) {
			// Captura cualquier otro tipo de excepción
			flash.addFlashAttribute("error", "Ups, ocurrió un error: " + e.getMessage());
		}
		return "redirect:/pelicula/peliculas";
	}

}
