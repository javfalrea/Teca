package com.teca.entities;

public class PeliculaParticipante {
	
	private Pelicula pelicula;
	private Participante participante;
	private Boolean esActor;
	private Boolean esDirector;
	
	public PeliculaParticipante(Pelicula pelicula, Participante participante, Boolean esActor, Boolean esDirector) {
		this.pelicula = pelicula;
		this.participante = participante;
		this.esActor = esActor;
		this.esDirector = esDirector;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Boolean getEsActor() {
		return esActor;
	}

	public void setEsActor(Boolean esActor) {
		this.esActor = esActor;
	}

	public Boolean getEsDirector() {
		return esDirector;
	}

	public void setEsDirector(Boolean esDirector) {
		this.esDirector = esDirector;
	}

}
