package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.empresa.laboral.Nomina;
import com.empresa.service.NominaServicio;

public class NominaController {

	@Autowired
	NominaServicio nominaServicio;
		
	@GetMapping("/nomina/{dni}")
	public ModelAndView getNomina(@PathVariable String dni) {
		Nomina nomina = nominaServicio.findById(dni);
		return new ModelAndView("nominaEmpleado", "nomina", nomina); 
	}
}
