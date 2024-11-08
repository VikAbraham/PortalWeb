package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Resena;
import com.example.demo.service.ResenaService;

@Controller
public class ResenaController {
	
	@Autowired
	private ResenaService resenaService;
	
	@GetMapping({"/resena"})
	public String listarResena(Model model) {
		List<Resena> resenas = resenaService.findAll();
		
		model.addAttribute("resenas",resenas);
		return "forms/resena";
	}
	@GetMapping({"/nueva-resena"})
		public String nuevaResena() {
			return "forms/nueva-resena";
		}
	
}
