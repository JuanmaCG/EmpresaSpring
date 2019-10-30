package com.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.empresa.laboral.Empleado;
import com.empresa.repository.EmpleadoRepository;

@SpringBootApplication
public class EmpresaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaSpringApplication.class, args);
	}

	
	
}
