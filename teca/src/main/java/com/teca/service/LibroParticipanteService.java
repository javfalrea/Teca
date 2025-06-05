package com.teca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teca.entities.Libro;
import com.teca.entities.LibroParticipante;
import com.teca.entities.Participante;
import com.teca.util.General;

@Service
public class LibroParticipanteService {
	
	@Autowired
	private LibroService l;
	
	@Autowired 
	private ParticipanteService p;
	
	public LibroParticipante agregar(Long idLibro, Long idParticipante) throws SQLException {
		Connection conn = General.conexion();

		String insertAgregacion = "INSERT INTO libro_participante (id_libro, id_participante) VALUES (?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(insertAgregacion, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idLibro);
		ps.setLong(2, idParticipante);

		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido asignar el participante al libro");
		}
		
		Libro libro = l.buscarPorId(idLibro);
		
		Participante participante = p.buscarPorId(idParticipante);
		
		LibroParticipante libroParticipante = new LibroParticipante(libro, participante);
		
		ps.close();
		conn.close();
		
		return libroParticipante;
	}
	
	public void desagregar(Long idLibro, Long idParticipante) throws SQLException {
		Connection conn = General.conexion();
		
		String deleteAgregacion = "DELETE FROM libro_participante WHERE id_libro = ? AND id_participante = ?";
		
		PreparedStatement ps = conn.prepareStatement(deleteAgregacion);
		ps.setLong(1, idLibro);
		ps.setLong(2, idParticipante);
		
		int respuesta = ps.executeUpdate();
		if(respuesta != 1) {
			throw new SQLException("No se ha podido desagregar el participante del libro");
		}
				
		ps.close();
		conn.close();
	}

}
