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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.empresa.laboral.Empleado;
import com.empresa.repository.EmpleadoRepository;
import com.empresa.service.EmpleadoServicio;

@RestController
@RequestMapping("/")
public class EmpleadoController {

	@Autowired
	EmpleadoServicio empleadoRepository;
		
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
		List<Empleado> list = empleadoRepository.getAll();
		return new ModelAndView("empleados", "list", list);
	}
	
	@GetMapping("/empleados/{dni}")
	public ModelAndView getEspecifico(@PathVariable String dni){
		Empleado emp = empleadoRepository.getEmpByDni(dni);
		return new ModelAndView("empleado", "emp", emp); 
	}
	
	@PostMapping("/empleados")
	public ModelAndView submit(@ModelAttribute("Empleado") Empleado empleado,BindingResult result, ModelMap model) {

		model.addAttribute("nombre", empleado.getNombre());
		model.addAttribute("sexo", empleado.getSexo());
		model.addAttribute("dni", empleado.getDni());
		model.addAttribute("categoria", empleado.getCategoria());
		model.addAttribute("anyos", empleado.getAnyos());
		empleadoRepository.createEmp(empleado);
        return new ModelAndView("empView", "empleado", empleado);
    }
	
	@PutMapping("/empleados/{dni}")
	public ResponseEntity<Empleado> actualizaEmp(@PathVariable String dni,@RequestBody Empleado emp){
		emp.setDni(dni);
		return ResponseEntity.ok().body(empleadoRepository.updateEmp(emp));
	}
	
	@DeleteMapping("/empleados/{dni}")
	public HttpStatus borrarEmp(@PathVariable String dni){
		empleadoRepository.deleteEmp(dni);
		return HttpStatus.OK;
	}
}
