package com.teca.entities;

public class Serie {
	
	private Long id;
	private String titulo;
	private String tituloOriginal;
	private Boolean terminada;
	private String sinopsis;
	private String imagen;
	private Pais pais;
	public Serie(Long id, String titulo, String tituloOriginal, Boolean terminada, String sinopsis, String imagen, Pais pais) {
		this.id = id;
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.terminada = terminada;
		this.sinopsis = sinopsis;
		this.imagen = imagen;
		this.pais = pais;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTituloOriginal() {
		return tituloOriginal;
	}
	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}
	public Boolean getTerminada() {
		return terminada;
	}
	public void setTerminada(Boolean terminada) {
		this.terminada = terminada;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
}
