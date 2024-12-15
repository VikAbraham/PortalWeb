package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomController implements ErrorController{
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		//Capturar error en status
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
			if (status != null) {
				//pasar error en String a la variable para comparar
				int statusCode = Integer.parseInt(status.toString());
				//Buscar error 403
				if(statusCode == HttpStatus.FORBIDDEN.value()) {
					return "forms/error-403";
					//Buscar error 404
				} else if (statusCode == HttpStatus.NOT_FOUND.value()) {
					return "forms/error-404";
				}
			}
		return "index"; //Cualquier otro error enviará a Index
	}
	
	public String getErrorPath() {
		return "/error";
	}
}
