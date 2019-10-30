package com.empresa.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
	
//	@GetMapping("/empleados")
//	public ResponseEntity<List<Empleado>> getAll(){
//		return ResponseEntity.ok().body(empleadoRepository.findAll());
//	}
	@GetMapping("/empleados")
	public ModelAndView getAll(){
		List<Empleado> list = empleadoRepository.getAll();
		return new ModelAndView("empleados", "list", list);
	}
	
	@GetMapping("/empleados/{dni}")
	public ResponseEntity<Empleado> getEspecifico(@PathVariable String dni){
		return ResponseEntity.ok().body(empleadoRepository.getEmpByDni(dni));
	}
	
	@PostMapping("/empleados")
	public ResponseEntity<Empleado> crearEmpl(@RequestBody Empleado emp){
		return ResponseEntity.ok().body(empleadoRepository.createEmp(emp));
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
