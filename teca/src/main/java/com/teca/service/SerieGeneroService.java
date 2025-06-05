package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teca.entities.Genero;
import com.teca.entities.Serie;
import com.teca.entities.SerieGenero;
import com.teca.util.General;

@Service
public class SerieGeneroService {
	
	@Autowired
	private SerieService s;
	
	@Autowired 
	private GeneroService g;
	
	public SerieGenero agregar(Long idSerie, Long idGenero) throws SQLException {
		Connection conn = General.conexion();

		String insertAgregacion = "INSERT INTO serie_genero (id_serie, id_genero) VALUES (?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertAgregacion, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idSerie);
		ps.setLong(2, idGenero);

		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido asignar el género a la serie");
		}
		
		Serie serie = s.buscarPorId(idSerie);
		
		Genero genero = g.buscarPorId(idGenero);
		
		SerieGenero serieGenero = new SerieGenero(serie, genero);
		
		ps.close();
		conn.close();
		
		return serieGenero;
	}
	
	public void desagregar(Long idSerie, Long idGenero) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteAgregacion = "DELETE FROM serie_genero WHERE id_serie = ? AND id_genero = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteAgregacion);
		ps.setLong(1, idSerie);
		ps.setLong(2, idGenero);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido desagregar el género de la serie");
		}
				
		ps.close();
		conn.close();
	}

}
