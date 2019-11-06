package com.empresa.laboral;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Nomina")
public class Nomina implements Serializable {
	

	@Id
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dni", referencedColumnName = "dni", unique = true)
    private Empleado empleado;
	
	private int salario;
	
	
	public Nomina() {}
	

	public Nomina(Empleado emp, int salario) {
		super();
		this.empleado = emp;
		this.empleado.setNomina(this);
		this.salario = salario;
	}


	
	

	

	public Empleado getEmp() {
		return empleado;
	}




	public void setEmp(Empleado emp) {
		this.empleado = emp;
	}


	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	

	
	
}
