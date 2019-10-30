package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.laboral.Empleado;

@Service
public interface EmpleadoServicio {
	Empleado createEmp(Empleado emp);
	Empleado updateEmp(Empleado emp);
	List<Empleado> getAll();
	Empleado getEmpByDni(String dni);
	void deleteEmp(String dni);
}
