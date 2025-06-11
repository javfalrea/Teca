package com.teca.entities;

public class SerieValoracion {
	
	private Serie serie;
	private Double valoracion;
	private Boolean fav;
	private String critica;
	
	public SerieValoracion(Serie serie, Double valoracion, Boolean fav, String critica) {
		this.serie = serie;
		this.valoracion = valoracion;
		this.fav = fav;
		this.critica = critica;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
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
