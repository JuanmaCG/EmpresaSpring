package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.empresa.laboral.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, String>{

}
