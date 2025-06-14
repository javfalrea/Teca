package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teca.entities.Pais;
import com.teca.util.General;

@Service
public class PaisService {
	
	public Pais crear(String nombre, String bandera) throws SQLException {
		Connection conn = General.conexion();
		
	    String comprobar = "SELECT COUNT(*) FROM pais WHERE LOWER(nombre) = ?";
	    PreparedStatement check = conn.prepareStatement(comprobar);
	    check.setString(1, nombre.toLowerCase());

	    ResultSet rs = check.executeQuery();
	    rs.next();
	    int existentes = rs.getInt(1);

	    rs.close();
	    check.close();

	    if (existentes > 0) {
	        conn.close();
	        throw new SQLException("Ya existe un país con ese nombre.");
	    }
		
		String insertPais = "INSERT INTO pais (nombre, bandera) VALUES (?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertPais, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, nombre);
		ps.setString(2, bandera);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido crear el país");
		}
		
		Long id = General.obtenerClaveGenerada(ps);
		
		Pais pais = new Pais(id, nombre, bandera);
		
		ps.close();
		conn.close();
		
		return pais;
	}
	
	public Pais modificar(Long id, String nombre, String bandera) throws SQLException {
		Connection conn = General.conexion();
		
	    String comprobar = "SELECT COUNT(*) FROM pais WHERE LOWER(nombre) = ? AND id <> ?";
	    PreparedStatement check = conn.prepareStatement(comprobar);
	    check.setString(1, nombre.toLowerCase());
	    check.setLong(2, id);

	    ResultSet rs = check.executeQuery();
	    rs.next();
	    int existentes = rs.getInt(1);

	    rs.close();
	    check.close();

	    if (existentes > 0) {
	        conn.close();
	        throw new SQLException("Ya existe un país con ese nombre.");
	    }
		
		String updatePais = "UPDATE pais SET nombre = ?, bandera = ? WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(updatePais);
		ps.setString(1, nombre);
		ps.setString(2, bandera);
		ps.setLong(3, id);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido modificar el país");
		}
		
		Pais pais = new Pais(id, nombre, bandera);
		
		ps.close();
		conn.close();
		
		return pais;
	}
	
	public void eliminar(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String deletePais = "DELETE FROM pais WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(deletePais);
		ps.setLong(1, id);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido eliminar el país");
		}
				
		ps.close();
		conn.close();
	}
	
	public List<Pais> buscarTodo() throws SQLException {
		Connection conn = General.conexion();
		
		String selectPais = "SELECT * FROM pais";
		
		PreparedStatement ps = conn.prepareStatement(selectPais);
		
		ResultSet rs = ps.executeQuery();
		List<Pais> paises = new ArrayList<Pais>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String nombre = rs.getString("nombre");
			String bandera = rs.getString("bandera");
			
			Pais pais = new Pais(id, nombre, bandera);
			paises.add(pais);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return paises;
	}
	
	public List<Pais> buscarPorNombre(String nombreBq) throws SQLException {
		Connection conn = General.conexion();
		
		if (nombreBq == null || nombreBq.trim().isEmpty()) {
			nombreBq = "";
	    }
		
		String selectPais = "SELECT * FROM pais WHERE LOWER(nombre) LIKE ?";
		
		PreparedStatement ps = conn.prepareStatement(selectPais);
		ps.setString(1,  "%" + nombreBq.toLowerCase() + "%");
		
		ResultSet rs = ps.executeQuery();
		List<Pais> paises = new ArrayList<Pais>();
		while(rs.next()) {
			Long id = rs.getLong("id");
			String nombre = rs.getString("nombre");
			String bandera = rs.getString("bandera");
			
			Pais pais = new Pais(id, nombre, bandera);
			paises.add(pais);
		}
		
		rs.close();
		ps.close();
		conn.close();
		
		return paises;
	}	
	
	public Pais buscarPorPelicula(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String selectPais = "SELECT * FROM pais p JOIN pelicula pe ON p.id = pe.id_pais WHERE pe.id = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectPais);
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		Long idPais = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String bandera = rs.getString("bandera");
		
		Pais pais = new Pais(idPais, nombre, bandera);
		
		rs.close();
		ps.close();
		conn.close();
		
		return pais;
	}	
	
	public Pais buscarPorSerie(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String selectPais = "SELECT * FROM pais p JOIN serie s ON p.id = s.id_pais WHERE s.id = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectPais);
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		Long idPais = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String bandera = rs.getString("bandera");
		
		Pais pais = new Pais(idPais, nombre, bandera);
		
		rs.close();
		ps.close();
		conn.close();
		
		return pais;
	}	
	
	public Pais buscarPorParticipante(Long id) throws SQLException {
		Connection conn = General.conexion();
		
		String selectPais = "SELECT * FROM pais p JOIN participante pa ON p.id = pa.id_pais WHERE pa.id = ?";
		
		PreparedStatement ps = conn.prepareStatement(selectPais);
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		Long idPais = rs.getLong("id");
		String nombre = rs.getString("nombre");
		String bandera = rs.getString("bandera");
		
		Pais pais = new Pais(idPais, nombre, bandera);
		
		rs.close();
		ps.close();
		conn.close();
		
		return pais;
	}	

}
