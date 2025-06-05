package com.teca.entities;

public class PeliculaGenero {
	
	private Pelicula pelicula;
	private Genero genero;
	
	public PeliculaGenero(Pelicula pelicula, Genero genero) {
		this.pelicula = pelicula;
		this.genero = genero;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
