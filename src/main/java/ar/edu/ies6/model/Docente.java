package ar.edu.ies6.model;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Docente {
	@Column
	private String name;
	@Column
	private String lastName;
	@Column
	private String addressStreet;
	@Column
	private Integer addressNumber;
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaNac;
	@Id
	private Integer dni;
	@Column
	private Integer telefono;
	@Column
	private String email;
	@Column
	private String estadoCivil;
	@Column
	private Boolean estado;
	public String getName() {
		return name;
	}
	public Docente() {
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public Integer getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(Integer andressNumber) {
		this.addressNumber = andressNumber;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	
	}
	public Integer getEdad() {
		int edad=0;
		
		LocalDate fechaActual=LocalDate.now();
		Period periodo=Period.between(fechaNac, fechaActual);
		edad=periodo.getYears();
		return edad;
	}
		
	}
