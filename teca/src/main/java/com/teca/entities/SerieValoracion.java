package com.teca.entities;

public class SerieValoracion {
	
	private Serie serie;
	private Usuario usuario;
	private Boolean vista;
	private Double valoracion;
	private Boolean fav;
	private String critica;
	
	public SerieValoracion(Serie serie, Usuario usuario, Boolean vista, Double valoracion, Boolean fav, String critica) {
		this.serie = serie;
		this.usuario = usuario;
		this.vista = vista;
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
