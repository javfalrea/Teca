package com.teca.entities;

public class PeliculaValoracion {
	
	private Pelicula pelicula;
	private Double valoracion;
	private Boolean fav;
	private String critica;
	
	public PeliculaValoracion(Pelicula pelicula, Double valoracion, Boolean fav, String critica) {
		this.pelicula = pelicula;
		this.valoracion = valoracion;
		this.fav = fav;
		this.critica = critica;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
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
