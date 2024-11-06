package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	@GetMapping({"/","index"})
	public String inicio(Model model) {
		return "index";
	}
	
	@GetMapping({"nosotros"})
	public String nosotros(Model model) {
		return "/forms/nosotros";
	}
}
