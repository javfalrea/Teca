package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teca.entities.Serie;
import com.teca.entities.SerieValoracion;
import com.teca.util.General;

@Service
public class SerieValoracionService {
	
	@Autowired
	private SerieService s;

	public SerieValoracion crear(Long idSerie, Double valoracion, Boolean fav, String critica) throws SQLException {

		Connection conn = General.conexion();

		String insertValoracion = "INSERT INTO serie_valoracion (id_serie, valoracion, fav, critica) VALUES (?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(insertValoracion, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idSerie);
		ps.setDouble(2, valoracion);
		ps.setBoolean(3, fav);
		ps.setString(4, critica);

		int respuesta = ps.executeUpdate();
		if (respuesta != 1) {
			throw new SQLException("No se ha podido crear la valoracion");
		}

		Serie serie = s.buscarPorId(idSerie);

		SerieValoracion serieValoracion = new SerieValoracion(serie, valoracion, fav, critica);

		ps.close();
		conn.close();

		return serieValoracion;
	}

	public SerieValoracion modificar(Long idSerie, Double valoracion, Boolean fav, String critica) throws SQLException {
		Connection conn = General.conexion();

		String updateValoracion = "UPDATE serie_valoracion SET valoracion = ?, fav = ?, critica = ? WHERE id_serie = ?";

		PreparedStatement ps = conn.prepareStatement(updateValoracion);
		ps.setDouble(1, valoracion);
		ps.setBoolean(2, fav);
		ps.setString(3, critica);
		ps.setLong(4, idSerie);

		int respuesta = ps.executeUpdate();
		if (respuesta != 1) {
			throw new SQLException("No se ha podido modificar la valoración");
		}

		Serie serie = s.buscarPorId(idSerie);

		SerieValoracion serieValoracion = new SerieValoracion(serie, valoracion, fav, critica);

		ps.close();
		conn.close();

		return serieValoracion;
	}

	public void eliminar(Long idSerie) throws SQLException {
		Connection conn = General.conexion();

		String deleteValoracion = "DELETE FROM serie_valoracion WHERE id_serie = ?";

		PreparedStatement ps = conn.prepareStatement(deleteValoracion);
		ps.setLong(1, idSerie);

		int respuesta = ps.executeUpdate();
		if (respuesta != 1) {
			throw new SQLException("No se ha podido eliminar la valoración");
		}

		ps.close();
		conn.close();
	}
	
	public SerieValoracion buscarPorId(Long idSerie) throws SQLException {
		Connection conn = General.conexion();

		String selectValoracion = "SELECT * FROM serie_valoracion WHERE id_serie = ?";

		PreparedStatement ps = conn.prepareStatement(selectValoracion);
		ps.setLong(1, idSerie);
		
		ResultSet rs = ps.executeQuery();
	    if (rs.next()) {
	        Double valoracion = rs.getDouble("valoracion");
	        Boolean fav = rs.getBoolean("fav");
	        String critica = rs.getString("critica");
	        
	        Serie serie = s.buscarPorId(idSerie);
	        
	        SerieValoracion serieValoracion = new SerieValoracion(serie, valoracion, fav, critica);
	        
	        rs.close();
	        ps.close();
	        conn.close();
	        
	        return serieValoracion;
	    } else {
	        rs.close();
	        ps.close();
	        conn.close();
	        
	        return null;
	    }
	}

}
