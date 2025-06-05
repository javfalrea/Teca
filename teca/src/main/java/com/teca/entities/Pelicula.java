package com.teca.entities;

public class Pelicula {
	
	private Long id;
	private String titulo;
	private String tituloOriginal;
	private Integer anioEstreno;
	private Integer duracion;
	private String sinopsis;
	private String imagen;
	private Pais pais;
	
	public Pelicula(Long id, String titulo, String tituloOriginal, Integer anioEstreno, Integer duracion, String sinopsis, String imagen, Pais pais) {
		this.id = id;
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.anioEstreno = anioEstreno;
		this.duracion = duracion;
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

	public Integer getAnioEstreno() {
		return anioEstreno;
	}

	public void setAnioEstreno(Integer anioEstreno) {
		this.anioEstreno = anioEstreno;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
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
