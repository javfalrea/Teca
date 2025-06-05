package com.teca.entities;

public class Temporada {
	
	private Long id;
	private Integer numero;
	private Integer anioEstreno;
	private Integer numCapitulos;
	private Integer duracionMedia;
	private String sinopsis;
	private Serie serie;
	public Temporada(Long id, Integer numero, Integer anioEstreno, Integer numCapitulos, Integer duracionMedia, String sinopsis, Serie serie) {
		this.id = id;
		this.numero = numero;
		this.anioEstreno = anioEstreno;
		this.numCapitulos = numCapitulos;
		this.duracionMedia = duracionMedia;
		this.sinopsis = sinopsis;
		this.serie = serie;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getAnioEstreno() {
		return anioEstreno;
	}
	public void setAnioEstreno(Integer anioEstreno) {
		this.anioEstreno = anioEstreno;
	}
	public Integer getNumCapitulos() {
		return numCapitulos;
	}
	public void setNumCapitulos(Integer numCapitulos) {
		this.numCapitulos = numCapitulos;
	}
	public Integer getDuracionMedia() {
		return duracionMedia;
	}
	public void setDuracionMedia(Integer duracionMedia) {
		this.duracionMedia = duracionMedia;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

}
