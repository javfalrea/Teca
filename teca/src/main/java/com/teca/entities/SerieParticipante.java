package com.teca.entities;

public class SerieParticipante {
	
	private Serie serie;
	private Participante participante;
	private Boolean esActor;
	private Boolean esDirector;
	
	public SerieParticipante(Serie serie, Participante participante, Boolean esActor, Boolean esDirector) {
		this.serie = serie;
		this.participante = participante;
		this.esActor = esActor;
		this.esDirector = esDirector;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
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
