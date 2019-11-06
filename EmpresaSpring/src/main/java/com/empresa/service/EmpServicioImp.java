package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.laboral.Empleado;
import com.empresa.repository.EmpleadoRepository;

import exception.ResourceNotFoundException;

@Service
public class EmpServicioImp implements EmpleadoServicio{

	@Autowired
	private EmpleadoRepository empRepository;
	
	@Override
	public Empleado createEmp(Empleado emp) {
		return empRepository.save(emp);
	}

	@Override
	public Empleado updateEmp(Empleado emp) {
		Optional<Empleado> empleado = empRepository.findById(emp.getDni());
		if(empleado.isPresent()) {
			Empleado empActualizado = empleado.get();
			empActualizado.setAnyos(emp.getAnyos());
			empActualizado.setCategoria(emp.getCategoria());
			empActualizado.setDni(emp.getDni());
			empActualizado.setNombre(emp.getNombre());
			empActualizado.setSexo(emp.getSexo());
			empRepository.save(empActualizado);
			return empActualizado;
		}else {
			throw new ResourceNotFoundException("Empleado no encontrado");
		}
	}

	@Override
	public List<Empleado> getAll() {
		return empRepository.findAll();
	}

	@Override
	public Empleado getEmpByDni(String dni) {
		// TODO Auto-generated method stub
		Optional<Empleado> emp = empRepository.findById(dni);
		if(emp.isPresent()) {
			return emp.get();
		}else {
			throw new ResourceNotFoundException("Empleado no encontrado");
		}
	}

	@Override
	public void deleteEmp(String dni) {
		// TODO Auto-generated method stub
		Optional<Empleado> emp = empRepository.findById(dni);
		if(emp.isPresent()) {
			empRepository.delete(emp.get());
		}else {
			throw new ResourceNotFoundException("Empleado no encontrado");
		}
	}

}
