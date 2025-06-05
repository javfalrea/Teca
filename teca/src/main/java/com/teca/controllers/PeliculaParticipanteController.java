package com.teca.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teca.service.PeliculaParticipanteService;

@RestController
@RequestMapping("/peliculaParticipante")
public class PeliculaParticipanteController {
	
	@Autowired
	private PeliculaParticipanteService s;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestParam Long idPelicula,
			@RequestParam Long idParticipante,
			@RequestParam Boolean esActor,
			@RequestParam Boolean esDirector) {
		try {
			return ResponseEntity.ok().body(s.agregar(idPelicula, idParticipante, esActor, esDirector)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/desagregar")
	public ResponseEntity<?> desagregar(@RequestParam Long idPelicula,
			@RequestParam Long idParticipante) {
		try {
			s.desagregar(idPelicula, idParticipante);
			return ResponseEntity.ok().body("Eliminación correcta"); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}


}
