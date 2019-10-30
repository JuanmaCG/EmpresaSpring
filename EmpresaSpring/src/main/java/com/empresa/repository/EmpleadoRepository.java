package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empresa.laboral.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>{

}
