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
import com.teca.util.General;

@Service
public class LibroValoracionService {
	
	@Autowired
	private LibroService l;
	
	public LibroValoracion crear(Long idLibro, Double valoracion, Boolean fav, String critica) throws SQLException {
		Connection conn = General.conexion();
		
		String insertValoracion = "INSERT INTO libro_valoracion (id_libro, valoracion, fav, critica) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertValoracion, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idLibro);
		ps.setDouble(2, valoracion);
		ps.setBoolean(3, fav);
		ps.setString(4, critica);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido crear la valoracion");
		}
		
		Libro libro = l.buscarPorId(idLibro);
			
		LibroValoracion libroValoracion = new LibroValoracion(libro, valoracion, fav, critica);
		
		ps.close();
		conn.close();
		
		return libroValoracion;
	}
	
	public LibroValoracion modificar(Long idLibro, Double valoracion, Boolean fav, String critica) throws SQLException {
		Connection conn = General.conexion();
		
		String updateValoracion = "UPDATE libro_valoracion SET valoracion = ?, fav = ?, critica = ? WHERE id_libro = ?";
		
		PreparedStatement ps = conn.prepareStatement(updateValoracion);
		ps.setDouble(1, valoracion);
		ps.setBoolean(2, fav);
		ps.setString(3, critica);
		ps.setLong(4, idLibro);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido modificar la valoración");
		}
		
		Libro libro = l.buscarPorId(idLibro);
			
		LibroValoracion libroValoracion = new LibroValoracion(libro, valoracion, fav, critica);
		
		ps.close();
		conn.close();
		
		return libroValoracion;		
	}
	
	public void eliminar(Long idLibro) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteValoracion = "DELETE FROM libro_valoracion WHERE id_libro = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteValoracion);
		ps.setLong(1, idLibro);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido eliminar la valoración");
		}
				
		ps.close();
		conn.close();
	}
	
	public LibroValoracion buscarPorId(Long idLibro) throws SQLException {
		Connection conn = General.conexion();

		String selectValoracion = "SELECT * FROM libro_valoracion WHERE id_libro = ?";

		PreparedStatement ps = conn.prepareStatement(selectValoracion);
		ps.setLong(1, idLibro);
		
		ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	        Double valoracion = rs.getDouble("valoracion");
	        Boolean fav = rs.getBoolean("fav");
	        String critica = rs.getString("critica");
	        
	        Libro libro = l.buscarPorId(idLibro);
	        
	        LibroValoracion libroValoracion = new LibroValoracion(libro, valoracion, fav, critica);
	        
	        rs.close();
	        ps.close();
	        conn.close();
	        
	        return libroValoracion;
	    } else {
	        rs.close();
	        ps.close();
	        conn.close();
	        
	        return null;
	    }
	}

}
