package com.teca.entities;

public class SerieGenero {
	
	private Serie serie;
	private Genero genero;
	
	public SerieGenero(Serie serie, Genero genero) {
		this.serie = serie;
		this.genero = genero;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
