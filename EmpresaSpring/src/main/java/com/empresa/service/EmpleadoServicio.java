package com.empresa.service;

import java.util.List;

import com.empresa.laboral.Empleado;

public interface EmpleadoServicio {
	Empleado createEmp(Empleado emp);
	Empleado updateEmp(Empleado emp);
	List<Empleado> getAll();
	Empleado getEmpByDni(String dni);
	void deleteEmp(String dni);
}
