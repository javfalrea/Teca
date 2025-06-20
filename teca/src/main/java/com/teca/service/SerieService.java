package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teca.entities.Pais;
import com.teca.entities.Serie;
import com.teca.util.General;

@Service
public class SerieService {

	@Autowired
	private PaisService p;
	
	public Serie crear(String titulo, String tituloOriginal, Boolean terminada, String sinopsis, String imagen, Long idPais) throws SQLException {
		Connection conn = General.conexion();
		
		String insertSerie = "INSERT INTO serie (titulo, titulo_original, terminada, sinopsis, imagen, id_pais) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertSerie, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, titulo);
		ps.setString(2, tituloOriginal);
		ps.setBoolean(3, terminada);
		ps.setString(4, sinopsis);
		ps.setString(5, imagen);
		ps.setLong(6, idPais);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido crear la serie");
		}
		
		Long id = General.obtenerClaveGenerada(ps);
		
		Pais pais = p.buscarPorSerie(id);
		
		Serie serie = new Serie(id, titulo, tituloOriginal, terminada, sinopsis, imagen, pais);
		
		ps.close();
		conn.close();
		
		return serie;
	}
	
	public Serie modificar(Long id, String titulo, String tituloOriginal, Boolean terminada, String sinopsis, String imagen, Long idPais) throws SQLException {
		Connection conn = General.conexion();
		
		String updateSerie = "UPDATE serie SET titulo = ?, titulo_original = ?, terminada = ?, sinopsis = ?, imagen = ?, id_pais = ? WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(updateSerie);
		ps.setString(1, titulo);
		ps.setString(2, tituloOriginal);
		ps.setBoolean(3, terminada);
		ps.setString(4, sinopsis);
		ps.setString(5, imagen);
		ps.setLong(6, idPais);
		ps.setLong(7, id);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido modificar la serie");
		}
		
		Pais pais = p.buscarPorSerie(id);
		
		Serie serie = new Serie(id, titulo, tituloOriginal, terminada, sinopsis, imagen, pais);
		
		ps.close();
		conn.close();
		
		return serie;
	}
	
	public void eliminar(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteSerie = "DELETE FROM serie WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteSerie);
		ps.setLong(1, id);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido eliminar la serie");
		}
				
		ps.close();
		conn.close();
	}
	
	public List<Serie> buscarTodo() throws SQLException {
		Connection conn = General.conexion();
		
		String selectSerie = "SELECT * FROM serie";
		
		PreparedStatement ps = conn.prepareStatement(selectSerie);
		
		ResultSet rs = ps.executeQuery();
		List<Serie> series = new ArrayList<Serie>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String titulo = rs.getString("titulo");
			String tituloOriginal = rs.getString("titulo_original");
			Boolean terminada = rs.getBoolean("terminada");
			String sinopsis = rs.getString("sinopsis");
			String imagen = rs.getString("imagen");
			
			Pais pais = p.buscarPorSerie(id);
			
			Serie serie = new Serie(id, titulo, tituloOriginal, terminada, sinopsis, imagen, pais);
			series.add(serie);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return series;
	}
	
	public Serie buscarPorId(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String selectSerie = "SELECT * FROM serie WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectSerie);
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		String titulo = rs.getString("titulo");
		String tituloOriginal = rs.getString("titulo_original");
		Boolean terminada = rs.getBoolean("terminada");
		String sinopsis = rs.getString("sinopsis");
		String imagen = rs.getString("imagen");
			
		Pais pais = p.buscarPorSerie(id);
			
		Serie serie = new Serie(id, titulo, tituloOriginal, terminada, sinopsis, imagen, pais);
		
		rs.close();
		ps.close();
		conn.close();
		
		return serie;
	}
	
	public List<Serie> busquedaAvanzada(String tituloBq, String participanteBq, Long idGenero) throws SQLException {
		Connection conn = General.conexion();
		
		if (tituloBq == null || tituloBq.trim().isEmpty()) {
	        tituloBq = "";
	    }
	    if (participanteBq == null || participanteBq.trim().isEmpty()) {
	    	participanteBq = "";
	    }
	    if (idGenero == null || idGenero <= 0) {
	        idGenero = 0L;
	    }
		
	    String selectSerie = "SELECT DISTINCT s.id, s.titulo, s.titulo_original, s.terminada, s.sinopsis, s.imagen, s.id_pais FROM serie s LEFT JOIN serie_participante sp ON s.id = sp.id_serie LEFT JOIN participante p ON sp.id_participante = p.id LEFT JOIN serie_genero sg ON s.id = sg.id_serie LEFT JOIN genero g ON sg.id_genero = g.id WHERE (? = '' OR LOWER(s.titulo) LIKE ? OR LOWER(s.titulo_original) LIKE ?) AND (? = '' OR LOWER(p.nombre) LIKE ?) AND (? = 0 OR g.id = ?)";
		
		PreparedStatement ps = conn.prepareStatement(selectSerie);
		
		ps.setString(1, tituloBq);
	    ps.setString(2, "%" + tituloBq.toLowerCase() + "%");
	    ps.setString(3, "%" + tituloBq.toLowerCase() + "%");
	    ps.setString(4, participanteBq);
	    ps.setString(5, "%" + participanteBq.toLowerCase() + "%");
	    ps.setLong(6, idGenero);
	    ps.setLong(7, idGenero);
		
		ResultSet rs = ps.executeQuery();
		List<Serie> series = new ArrayList<Serie>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String titulo = rs.getString("titulo");
			String tituloOriginal = rs.getString("titulo_original");
			Boolean terminada = rs.getBoolean("terminada");
			String sinopsis = rs.getString("sinopsis");
			String imagen = rs.getString("imagen");
			
			Pais pais = p.buscarPorSerie(id);
			
			Serie serie = new Serie(id, titulo, tituloOriginal, terminada, sinopsis, imagen, pais);
			series.add(serie);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return series;
	}
	
	public List<Serie> buscarPorDirector(Long idParticipante) throws SQLException {
		Connection conn = General.conexion();
		
		String selectSerie = "SELECT * FROM serie s JOIN serie_participante sp ON s.id = sp.id_serie JOIN participante p ON sp.id_participante = p.id WHERE p.id = ? AND sp.es_director = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectSerie);
		ps.setLong(1, idParticipante);
		ps.setBoolean(2, true);
		
		ResultSet rs = ps.executeQuery();
		List<Serie> series = new ArrayList<Serie>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String titulo = rs.getString("titulo");
			String tituloOriginal = rs.getString("titulo_original");
			Boolean terminada = rs.getBoolean("terminada");
			String sinopsis = rs.getString("sinopsis");
			String imagen = rs.getString("imagen");
			
			Pais pais = p.buscarPorSerie(id);
			
			Serie serie = new Serie(id, titulo, tituloOriginal, terminada, sinopsis, imagen, pais);
			series.add(serie);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return series;
	}
	
	public List<Serie> buscarPorActor(Long idParticipante) throws SQLException {
		Connection conn = General.conexion();
		
		String selectSerie = "SELECT * FROM serie s JOIN serie_participante sp ON s.id = sp.id_serie JOIN participante p ON sp.id_participante = p.id WHERE p.id = ? AND sp.es_actor = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectSerie);
		ps.setLong(1, idParticipante);
		ps.setBoolean(2, true);
		
		ResultSet rs = ps.executeQuery();
		List<Serie> series = new ArrayList<Serie>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String titulo = rs.getString("titulo");
			String tituloOriginal = rs.getString("titulo_original");
			Boolean terminada = rs.getBoolean("terminada");
			String sinopsis = rs.getString("sinopsis");
			String imagen = rs.getString("imagen");
			
			Pais pais = p.buscarPorSerie(id);
			
			Serie serie = new Serie(id, titulo, tituloOriginal, terminada, sinopsis, imagen, pais);
			series.add(serie);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return series;
	}
	
}
