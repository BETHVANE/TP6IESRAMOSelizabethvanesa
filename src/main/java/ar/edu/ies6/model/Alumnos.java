package ar.edu.ies6.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;


@Component
public class Alumnos {
	private String name;
	private String lastName;
	private String addressStreet;
	private Integer andressNumber;
	private LocalDate fechaNac;
	private Integer dni;
	private Integer telefono;
	private String email;
	private String estadoCivil;
	private Boolean estado;
	public String getName() {
		return name;
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
	public Integer getAndressNumber() {
		return andressNumber;
	}
	public void setAndressNumber(Integer andressNumber) {
		this.andressNumber = andressNumber;
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
	}
	
	
		
		 
	
