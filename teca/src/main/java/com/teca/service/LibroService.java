package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teca.entities.Libro;
import com.teca.util.General;

@Service
public class LibroService {
	
	public Libro crear(String titulo, String tituloOriginal, Integer anioLanzamiento, Integer paginasAprox, String sinopsis, String imagen) throws SQLException {
		Connection conn = General.conexion();
		
		String insertLibro = "INSERT INTO libro (titulo, titulo_original, anio_lanzamiento, paginas_aprox, sinopsis, imagen) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertLibro, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, titulo);
		ps.setString(2, tituloOriginal);
		ps.setInt(3, anioLanzamiento);
		ps.setInt(4, paginasAprox);
		ps.setString(5, sinopsis);
		ps.setString(6, imagen);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido crear el libro");
		}
		
		Long id = General.obtenerClaveGenerada(ps);
		
		Libro libro = new Libro(id, titulo, tituloOriginal, anioLanzamiento, paginasAprox, sinopsis, imagen);
		
		ps.close();
		conn.close();
		
		return libro;
	}
	
	public Libro modificar(Long id, String titulo, String tituloOriginal, Integer anioLanzamiento, Integer paginasAprox, String sinopsis, String imagen) throws SQLException {
		Connection conn = General.conexion();
		
		String updateLibro = "UPDATE libro SET titulo = ?, titulo_original = ?, anio_lanzamiento = ?, paginas_aprox = ?, sinopsis = ?, imagen = ? WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(updateLibro);
		ps.setString(1, titulo);
		ps.setString(2, tituloOriginal);
		ps.setInt(3, anioLanzamiento);
		ps.setInt(4, paginasAprox);
		ps.setString(5, sinopsis);
		ps.setString(6, imagen);
		ps.setLong(7, id);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido modificar el libro");
		}
		
		Libro libro = new Libro(id, titulo, tituloOriginal, anioLanzamiento, paginasAprox, sinopsis, imagen);
		
		ps.close();
		conn.close();
		
		return libro;
	}
	
	public void eliminar(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteLibro = "DELETE FROM libro WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteLibro);
		ps.setLong(1, id);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido eliminar el libro");
		}
				
		ps.close();
		conn.close();
	}
	
	public List<Libro> buscarTodos() throws SQLException {
		Connection conn = General.conexion();
		
		String selectLibro = "SELECT * FROM libro";
		
		PreparedStatement ps = conn.prepareStatement(selectLibro);
		
		ResultSet rs = ps.executeQuery();
		List<Libro> libros = new ArrayList<Libro>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String titulo = rs.getString("titulo");
			String tituloOriginal = rs.getString("titulo_original");
			Integer anioLanzamiento = rs.getInt("anio_lanzamiento");
			Integer paginasAprox = rs.getInt("paginas_aprox");
			String sinopsis = rs.getString("sinopsis");
			String imagen = rs.getString("imagen");
			
			Libro libro = new Libro(id, titulo, tituloOriginal, anioLanzamiento, paginasAprox, sinopsis, imagen);
			libros.add(libro);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return libros;
	}
	
	public Libro buscarPorId(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String selectLibro = "SELECT * FROM libro WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectLibro);
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		String titulo = rs.getString("titulo");
		String tituloOriginal = rs.getString("titulo_original");
		Integer anioLanzamiento = rs.getInt("anio_lanzamiento");
		Integer paginasAprox = rs.getInt("paginas_aprox");
		String sinopsis = rs.getString("sinopsis");
		String imagen = rs.getString("imagen");
			
		Libro libro = new Libro(id, titulo, tituloOriginal, anioLanzamiento, paginasAprox, sinopsis, imagen);
		
		rs.close();
		ps.close();
		conn.close();
		
		return libro;
	}
	
	public List<Libro> busquedaAvanzada(String tituloBq, String autor, Long idGenero) throws SQLException {
		Connection conn = General.conexion();
		
		if (tituloBq == null || tituloBq.trim().isEmpty()) {
	        tituloBq = "";
	    }
	    if (autor == null || autor.trim().isEmpty()) {
	        autor = "";
	    }
	    if (idGenero == null || idGenero <= 0) {
	        idGenero = 0L;
	    }
		
		String selectLibro = "SELECT DISTINCT l.id, l.titulo, l.titulo_original, l.anio_lanzamiento, l.paginas_aprox, l.sinopsis, l.imagen FROM libro l LEFT JOIN libro_participante lp ON l.id = lp.id_libro LEFT JOIN participante p ON lp.id_participante = p.id LEFT JOIN libro_genero lg ON l.id = lg.id_libro LEFT JOIN genero g ON lg.id_genero = g.id WHERE (? = '' OR LOWER(l.titulo) LIKE ? OR LOWER(l.titulo_original) LIKE ?) AND (? = '' OR LOWER(p.nombre) LIKE ?) AND (g.id = ? OR ? = 0)";
		
		PreparedStatement ps = conn.prepareStatement(selectLibro);
		
		ps.setString(1, tituloBq);
	    ps.setString(2, "%" + tituloBq.toLowerCase() + "%");
	    ps.setString(3, "%" + tituloBq.toLowerCase() + "%");
	    ps.setString(4, autor);
	    ps.setString(5, "%" + autor.toLowerCase() + "%");
	    ps.setLong(6, idGenero);
	    ps.setLong(7, idGenero);
		
		ResultSet rs = ps.executeQuery();
		List<Libro> libros = new ArrayList<Libro>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String titulo = rs.getString("titulo");
			String tituloOriginal = rs.getString("titulo_original");
			Integer anioLanzamiento = rs.getInt("anio_lanzamiento");
			Integer paginasAprox = rs.getInt("paginas_aprox");
			String sinopsis = rs.getString("sinopsis");
			String imagen = rs.getString("imagen");
			
			Libro libro = new Libro(id, titulo, tituloOriginal, anioLanzamiento, paginasAprox, sinopsis, imagen);
			libros.add(libro);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return libros;
	}
	
	public List<Libro> buscarPorAutor(Long idParticipante) throws SQLException {
		Connection conn = General.conexion();
		
		String selectLibro = "SELECT * FROM libro l JOIN libro_participante lp ON l.id = lp.id_libro JOIN participante p ON lp.id_participante = p.id WHERE p.id = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectLibro);
		ps.setLong(1, idParticipante);
		
		ResultSet rs = ps.executeQuery();
		List<Libro> libros = new ArrayList<Libro>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String titulo = rs.getString("titulo");
			String tituloOriginal = rs.getString("titulo_original");
			Integer anioLanzamiento = rs.getInt("anio_lanzamiento");
			Integer paginasAprox = rs.getInt("paginas_aprox");
			String sinopsis = rs.getString("sinopsis");
			String imagen = rs.getString("imagen");
			
			Libro libro = new Libro(id, titulo, tituloOriginal, anioLanzamiento, paginasAprox, sinopsis, imagen);
			libros.add(libro);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return libros;
	}

}
