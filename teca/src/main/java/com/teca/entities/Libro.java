package com.teca.entities;

public class Libro {

	private Long id;
	private String titulo;
	private String tituloOriginal;
	private Integer anioLanzamiento;
	private Integer paginasAprox;
	private String sinopsis;
	private String imagen;
	
	public Libro(Long id, String titulo, String tituloOriginal, Integer anioLanzamiento, Integer paginasAprox, String sinopsis, String imagen) {
		this.id = id;
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.anioLanzamiento = anioLanzamiento;
		this.paginasAprox = paginasAprox;
		this.sinopsis = sinopsis;
		this.imagen = imagen;
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

	public Integer getAnioLanzamiento() {
		return anioLanzamiento;
	}

	public void setAnioLanzamiento(Integer anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}

	public Integer getPaginasAprox() {
		return paginasAprox;
	}

	public void setPaginasAprox(Integer paginasAprox) {
		this.paginasAprox = paginasAprox;
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
	
}
