package com.teca.entities;

public class Usuario {
	
	private Long id;
	private String nombre;
	private String contrasena;
	private Boolean esAdmin;
	
	public Usuario(Long id, String nombre, String contrasena, Boolean esAdmin) {
		this.id = id;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.esAdmin = esAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Boolean getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(Boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

}
