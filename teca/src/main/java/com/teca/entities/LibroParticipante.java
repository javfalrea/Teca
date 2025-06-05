package com.teca.entities;

public class LibroParticipante {
	
	private Libro libro;
	private Participante participante;
	
	public LibroParticipante(Libro libro, Participante participante) {
		this.libro = libro;
		this.participante = participante;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

}
