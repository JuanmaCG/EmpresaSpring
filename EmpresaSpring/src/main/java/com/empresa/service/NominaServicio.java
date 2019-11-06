package com.empresa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.empresa.laboral.Empleado;
import com.empresa.laboral.Nomina;

@Service
public interface NominaServicio {
	Nomina updateNomina(Empleado emp);
	Nomina findById(String dni);
	List<Nomina> getAll();
}
