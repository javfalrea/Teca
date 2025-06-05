package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teca.entities.Participante;
import com.teca.entities.Serie;
import com.teca.entities.SerieParticipante;
import com.teca.util.General;

@Service
public class SerieParticipanteService {
	
	@Autowired
	private SerieService s;
	
	@Autowired 
	private ParticipanteService p;
	
	public SerieParticipante agregar(Long idSerie, Long idParticipante, Boolean esActor, Boolean esDirector) throws SQLException {
		Connection conn = General.conexion();
		
		if(!esActor && !esDirector) {
			throw new SQLException("Debe asignarse al menos un rol.");
		}

		String insertAgregacion = "INSERT INTO serie_participante (id_serie, id_participante, es_actor, es_director) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertAgregacion, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idSerie);
		ps.setLong(2, idParticipante);
		ps.setBoolean(3, esActor);
		ps.setBoolean(4, esDirector);

		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido asignar el participante a la serie");
		}
		
		Serie serie = s.buscarPorId(idSerie);
		
		Participante participante = p.buscarPorId(idParticipante);
		
		SerieParticipante serieParticipante = new SerieParticipante(serie, participante, esActor, esDirector);
		
		ps.close();
		conn.close();
		
		return serieParticipante;
	}
	
	public void desagregar(Long idSerie, Long idParticipante) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteAgregacion = "DELETE FROM serie_participante WHERE id_serie = ? AND id_participante = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteAgregacion);
		ps.setLong(1, idSerie);
		ps.setLong(2, idParticipante);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido desagregar el participante de la serie");
		}
				
		ps.close();
		conn.close();
	}

}
