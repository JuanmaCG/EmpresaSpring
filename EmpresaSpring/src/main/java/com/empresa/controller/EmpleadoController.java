package com.empresa.controller;

import java.util.List;
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

import com.empresa.laboral.Empleado;
import com.empresa.repository.EmpleadoRepository;

@RestController
@RequestMapping("/")
public class EmpleadoController {

	@Autowired
	EmpleadoRepository empleadoRepository;
		
	
	@GetMapping("/empleados")
	public ResponseEntity<List<Empleado>> getAll(){
		return ResponseEntity.ok().body(empleadoRepository.findAll());
	}
	
	@GetMapping("/empleados/{dni}")
	public ResponseEntity<Optional<Empleado>> getEspecifico(@PathVariable String dni){
		return ResponseEntity.ok().body(empleadoRepository.findById(dni));
	}
	
	@PostMapping("/empleados")
	public ResponseEntity<Empleado> crearEmpl(@RequestBody Empleado emp){
		return ResponseEntity.ok().body(empleadoRepository.save(emp));
	}
	
	@PutMapping("/empleados/{dni}")
	public ResponseEntity<Empleado> actualizaEmp(@PathVariable String dni,@RequestBody Empleado emp){
		emp.setDni(dni);
		return ResponseEntity.ok().body(empleadoRepository.save(emp));
	}
	
	@DeleteMapping("/empleados/{dni}")
	public HttpStatus borrarEmp(@PathVariable String dni){
		empleadoRepository.deleteById(dni);
		return HttpStatus.OK;
	}
}
