package com.empresa.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.empresa.laboral.Empleado;
import com.empresa.service.EmpleadoServicio;
import com.empresa.service.NominaServicio;

@RestController
@RequestMapping("/")
public class EmpleadoController {

	@Autowired
	EmpleadoServicio empleadoService;
	
	@Autowired
	NominaServicio nominaService;
		
	@GetMapping("/")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	@GetMapping("/altaEmpleados")
    public ModelAndView showForm() {
        return new ModelAndView("altaEmpleados", "empleado", new Empleado());
    }
	
	@GetMapping("/empleados")
	public ModelAndView getAll(){
		List<Empleado> list = empleadoService.getAll();
		return new ModelAndView("empleados", "list", list);
	}
	
	@GetMapping("/empleados/{dni}")
	public ModelAndView getEspecifico(@PathVariable String dni){
		Empleado emp = empleadoService.getEmpByDni(dni);
		return new ModelAndView("empleado", "emp", emp); 
	}
	
	@PostMapping("/empleados")
	public ModelAndView submit(@ModelAttribute("Empleado") Empleado empleado,BindingResult result, ModelMap model) {

		model.addAttribute("nombre", empleado.getNombre());
		model.addAttribute("sexo", empleado.getSexo());
		model.addAttribute("dni", empleado.getDni());
		model.addAttribute("categoria", empleado.getCategoria());
		model.addAttribute("anyos", empleado.getAnyos());
		empleadoService.createEmp(empleado);
        return new ModelAndView("empView", "empleado", empleado);
    }
	
	@GetMapping("/updateEmpleado")
    public ModelAndView updateEmp(@RequestParam String dni) {
        return new ModelAndView("updateEmpleado", "empleado", empleadoService.getEmpByDni(dni));
    }
	
	@PostMapping("/update")
	public ModelAndView actualizaEmp(@ModelAttribute("Empleado") Empleado emp){
		empleadoService.updateEmp(emp);
		nominaService.updateNomina(emp);
		return new ModelAndView("index");
	}
	
	@DeleteMapping("/empleados/{dni}")
	public HttpStatus borrarEmp(@PathVariable String dni){
		empleadoService.deleteEmp(dni);
		return HttpStatus.OK;
	}
}
