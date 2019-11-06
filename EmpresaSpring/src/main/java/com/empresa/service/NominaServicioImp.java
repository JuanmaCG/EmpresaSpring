package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.empresa.laboral.Empleado;
import com.empresa.laboral.Nomina;
import com.empresa.repository.EmpleadoRepository;
import com.empresa.repository.NominaRepository;

import exception.ResourceNotFoundException;

public class NominaServicioImp implements NominaServicio{

	private static final int SUELDO_BASE[] = {50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000, 230000};
		
	public static int sueldo(Empleado empleado) {
		
		return SUELDO_BASE[empleado.getCategoria() -1 ] + 5000 * empleado.getAnyos();
	
	}
	
	@Autowired
	private NominaRepository nominaRepository;
	

	@Override
	public Nomina updateNomina(Empleado emp) {
		Optional<Nomina> nomina = nominaRepository.findById(emp.getDni());
		if(nomina.isPresent()) {
			Nomina nominaActualizado = nomina.get();
			nominaActualizado.setEmp(emp);
			nominaActualizado.setSalario(sueldo(emp));
			nominaRepository.save(nominaActualizado);
			return nominaActualizado;
		}else {
			throw new ResourceNotFoundException("Empleado no encontrado");
		}
	}


	@Override
	public Nomina findById(String dni) {
		Optional<Nomina> nomina = nominaRepository.findById(dni);
		if(nomina.isPresent()) {
			return nomina.get();
		}else {
			throw new ResourceNotFoundException("Empleado no encontrado");
		}

	}


	@Override
	public List<Nomina> getAll() {
		return nominaRepository.findAll();
	}

	

}
