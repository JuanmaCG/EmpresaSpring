package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.empresa.service.NominaServicio;

@Controller
public class NominaController {

	@Autowired
	NominaServicio nominaServicio;
		
	@GetMapping("/nomina")
	public ModelAndView getNomina(@RequestParam String dni) {
		return new ModelAndView("nominaEmpleado", "nomina", nominaServicio.findById(dni)); 
	}
}
