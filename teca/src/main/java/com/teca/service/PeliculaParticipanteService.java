package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teca.entities.Participante;
import com.teca.entities.Pelicula;
import com.teca.entities.PeliculaParticipante;
import com.teca.util.General;

@Service
public class PeliculaParticipanteService {
	
	@Autowired
	private PeliculaService pe;
	
	@Autowired 
	private ParticipanteService p;
	
	public PeliculaParticipante agregar(Long idPelicula, Long idParticipante, Boolean esActor, Boolean esDirector) throws SQLException {
		Connection conn = General.conexion();
		
		if(!esActor && !esDirector) {
			throw new SQLException("Debe asignarse al menos un rol.");
		}

		String insertAgregacion = "INSERT INTO pelicula_participante (id_pelicula, id_participante, es_actor, es_director) VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertAgregacion, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idPelicula);
		ps.setLong(2, idParticipante);
		ps.setBoolean(3, esActor);
		ps.setBoolean(4, esDirector);

		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido asignar el participante a la película");
		}
		
		Pelicula pelicula = pe.buscarPorId(idPelicula);
		
		Participante participante = p.buscarPorId(idParticipante);
		
		PeliculaParticipante peliculaParticipante = new PeliculaParticipante(pelicula, participante, esActor, esDirector);
		
		ps.close();
		conn.close();
		
		return peliculaParticipante;
	}
	
	public void desagregar(Long idPelicula, Long idParticipante) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteAgregacion = "DELETE FROM pelicula_participante WHERE id_pelicula = ? AND id_participante = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteAgregacion);
		ps.setLong(1, idPelicula);
		ps.setLong(2, idParticipante);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido desagregar el participante de la película");
		}
				
		ps.close();
		conn.close();
	}

}
