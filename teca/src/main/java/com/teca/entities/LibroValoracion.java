package com.teca.entities;

public class LibroValoracion {
	
	private Libro libro;
	private Usuario usuario;
	private Boolean vista;
	private Double valoracion;
	private Boolean fav;
	private String critica;
	
	public LibroValoracion(Libro libro, Usuario usuario, Boolean vista, Double valoracion, Boolean fav, String critica) {
		this.libro = libro;
		this.usuario = usuario;
		this.vista = vista;
		this.valoracion = valoracion;
		this.fav = fav;
		this.critica = critica;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getVista() {
		return vista;
	}

	public void setVista(Boolean vista) {
		this.vista = vista;
	}

	public Double getValoracion() {
		return valoracion;
	}

	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}

	public Boolean getFav() {
		return fav;
	}

	public void setFav(Boolean fav) {
		this.fav = fav;
	}

	public String getCritica() {
		return critica;
	}

	public void setCritica(String critica) {
		this.critica = critica;
	}

}
