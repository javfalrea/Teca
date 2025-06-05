package com.teca.entities;

public class Pais {
	
	private Long id;
	private String nombre;
	private String bandera;
	
	public Pais(Long id, String nombre, String bandera) {
		this.id = id;
		this.nombre = nombre;
		this.bandera = bandera;
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

	public String getBandera() {
		return bandera;
	}

	public void setBandera(String bandera) {
		this.bandera = bandera;
	}

}
