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

import com.teca.entities.Serie;
import com.teca.entities.Temporada;
import com.teca.util.General;

@Service
public class TemporadaService {
	
	@Autowired
	private SerieService s;
	
	public Temporada crear(Integer numero, Integer anioEstreno, Integer numCapitulos, Integer duracionMedia, String sinopsis, Long idSerie) throws SQLException {
		Connection conn = General.conexion();
		
		String insertTemporada = "INSERT INTO temporada (numero, anio_estreno, num_capitulos, duracion_media, sinopsis, id_serie) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertTemporada, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, numero);
		ps.setInt(2, anioEstreno);
		ps.setInt(3, numCapitulos);
		ps.setInt(4, duracionMedia);
		ps.setString(5, sinopsis);
		ps.setLong(6, idSerie);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido crear la temporada");
		}
		
		Long id = General.obtenerClaveGenerada(ps);
		
		Serie serie = s.buscarPorId(idSerie);
		
		Temporada temporada = new Temporada(id, numero, anioEstreno, numCapitulos, duracionMedia, sinopsis, serie);
		
		ps.close();
		conn.close();
		
		return temporada;
	}
	
	public Temporada modificar(Long id, Integer numero, Integer anioEstreno, Integer numCapitulos, Integer duracionMedia, String sinopsis, Long idSerie) throws SQLException {
		Connection conn = General.conexion();
		
		String updateTemporada = "UPDATE temporada SET numero = ?, anio_estreno = ?, num_capitulos = ?, duracion_media = ?, sinopsis = ?, id_serie = ? WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(updateTemporada);
		ps.setInt(1, numero);
		ps.setInt(2, anioEstreno);
		ps.setInt(3, numCapitulos);
		ps.setInt(4, duracionMedia);
		ps.setString(5, sinopsis);
		ps.setLong(6, idSerie);
		ps.setLong(7, id);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido modificar la temporada");
		}
		
		Serie serie = s.buscarPorId(idSerie);
		
		Temporada temporada = new Temporada(id, numero, anioEstreno, numCapitulos, duracionMedia, sinopsis, serie);
		
		ps.close();
		conn.close();
		
		return temporada;
	}
	
	public void eliminar(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteTemporada = "DELETE FROM temporada WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteTemporada);
		ps.setLong(1, id);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido eliminar la temporadaa");
		}
				
		ps.close();
		conn.close();
	}
	
	public List<Temporada> buscarTodo() throws SQLException {
		Connection conn = General.conexion();
		
		String selectSerie = "SELECT * FROM temporada";
		
		PreparedStatement ps = conn.prepareStatement(selectSerie);
		
		ResultSet rs = ps.executeQuery();
		List<Temporada> temporadas = new ArrayList<Temporada>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			Integer numero = rs.getInt("numero");
			Integer anioEstreno = rs.getInt("anio_estreno");
			Integer numCapitulos = rs.getInt("num_capitulos");
			Integer duracionMedia = rs.getInt("duracion_media");
			String sinopsis = rs.getString("sinopsis");
			Long idSerie = rs.getLong("id_serie");
			
			Serie serie = s.buscarPorId(idSerie);
			
			Temporada temporada = new Temporada(id, numero, anioEstreno, numCapitulos, duracionMedia, sinopsis, serie);
			temporadas.add(temporada);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return temporadas;
	}
	
	public List<Temporada> buscarPorSerie(Long idSerie) throws SQLException {
		Connection conn = General.conexion();
		
		String selectSerie = "SELECT id, numero, anio_estreno, num_capitulos, duracion_media, sinopsis, id_serie FROM temporada WHERE id_serie = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectSerie);
		ps.setLong(1, idSerie);

		ResultSet rs = ps.executeQuery();
		List<Temporada> temporadas = new ArrayList<Temporada>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			Integer numero = rs.getInt("numero");
			Integer anioEstreno = rs.getInt("anio_estreno");
			Integer numCapitulos = rs.getInt("num_capitulos");
			Integer duracionMedia = rs.getInt("duracion_media");
			String sinopsis = rs.getString("sinopsis");
			
			Serie serie = s.buscarPorId(idSerie);
			
			Temporada temporada = new Temporada(id, numero, anioEstreno, numCapitulos, duracionMedia, sinopsis, serie);
			temporadas.add(temporada);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return temporadas;
	}
	
	public Temporada buscarPorId(Long id) throws SQLException {
		Connection conn = General.conexion();

		String selectTemporada = "SELECT id, numero, anio_estreno, num_capitulos, duracion_media, sinopsis, id_serie FROM temporada WHERE id = ?";

		PreparedStatement ps = conn.prepareStatement(selectTemporada);
		ps.setLong(1, id);

		ResultSet rs = ps.executeQuery();
		rs.next();
		Integer numero = rs.getInt("numero");
		Integer anioEstreno = rs.getInt("anio_estreno");
		Integer numCapitulos = rs.getInt("num_capitulos");
		Integer duracionMedia = rs.getInt("duracion_media");
		String sinopsis = rs.getString("sinopsis");
		Long idSerie = rs.getLong("id_serie");

		Serie serie = s.buscarPorId(idSerie);

		Temporada temporada = new Temporada(id, numero, anioEstreno, numCapitulos, duracionMedia, sinopsis, serie);

		rs.close();
		ps.close();
		conn.close();

		return temporada;
	}

}
