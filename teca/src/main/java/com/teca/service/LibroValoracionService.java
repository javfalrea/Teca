package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teca.entities.Libro;
import com.teca.entities.LibroValoracion;
import com.teca.entities.Usuario;
import com.teca.util.General;

@Service
public class LibroValoracionService {
	
	@Autowired
	private LibroService l;
	
	@Autowired
	private UsuarioService u;
	
	public LibroValoracion crear(Long idLibro,Long idUsuario, Boolean vista, Double valoracion, Boolean fav, String critica) throws SQLException {
		Connection conn = General.conexion();
		
		String insertValoracion = "INSERT INTO libro_valoracion (id_libro, id_usuario, vista, valoracion, fav, critica) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertValoracion, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idLibro);
		ps.setLong(2, idUsuario);
		ps.setBoolean(3, vista);
		ps.setDouble(4, valoracion);
		ps.setBoolean(5, fav);
		ps.setString(6, critica);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido crear la valoracion");
		}
		
		Libro libro = l.buscarPorId(idLibro);
		
		Usuario usuario = u.buscarPorId(idUsuario);
		
		LibroValoracion libroValoracion = new LibroValoracion(libro, usuario, vista, valoracion, fav, critica);
		
		ps.close();
		conn.close();
		
		return libroValoracion;
	}
	
	public LibroValoracion modificar(Long idLibro,Long idUsuario, Boolean vista, Double valoracion, Boolean fav, String critica) throws SQLException {
		Connection conn = General.conexion();
		
		String updateValoracion = "UPDATE libro_valoracion SET vista = ?, valoracion = ?, fav = ?, critica = ? WHERE id_libro = ? AND id_usuario = ?";
		
		PreparedStatement ps = conn.prepareStatement(updateValoracion);
		ps.setBoolean(1, vista);
		ps.setDouble(2, valoracion);
		ps.setBoolean(3, fav);
		ps.setString(4, critica);
		ps.setLong(5, idLibro);
		ps.setLong(6, idUsuario);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido modificar la valoración");
		}
		
		Libro libro = l.buscarPorId(idLibro);
		
		Usuario usuario = u.buscarPorId(idUsuario);
		
		LibroValoracion libroValoracion = new LibroValoracion(libro, usuario, vista, valoracion, fav, critica);
		
		ps.close();
		conn.close();
		
		return libroValoracion;		
	}
	
	public void eliminar(Long idLibro, Long idUsuario) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteValoracion = "DELETE FROM libro_valoracion WHERE id_libro = ? AND id_usuario = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteValoracion);
		ps.setLong(1, idLibro);
		ps.setLong(2, idUsuario);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido eliminar la valoración");
		}
				
		ps.close();
		conn.close();
	}
	
	public LibroValoracion buscarPorLibroYUsuario(Long idLibro, Long idUsuario) throws SQLException {
		Connection conn = General.conexion();
		
		String selectValoracion = "SELECT * FROM pelicula_valoracion WHERE id_libro = ? AND id_usuario = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectValoracion);
		ps.setLong(1, idLibro);
		ps.setLong(2, idUsuario);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		Boolean vista = rs.getBoolean("vista");
		Double valoracion = rs.getDouble("valoracion");
		Boolean fav = rs.getBoolean("fav");
		String critica = rs.getString("critica");
			
		Libro libro = l.buscarPorId(idLibro);
		
		Usuario usuario = u.buscarPorId(idUsuario);
		
		LibroValoracion libroValoracion = new LibroValoracion(libro, usuario, vista, valoracion, fav, critica);		
		
		rs.close();
		ps.close();
		conn.close();
		
		return libroValoracion;
	}

}
