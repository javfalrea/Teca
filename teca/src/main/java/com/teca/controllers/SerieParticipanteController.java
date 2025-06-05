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

import com.teca.service.SerieParticipanteService;

@RestController
@RequestMapping("/serieParticipante")
public class SerieParticipanteController {
	
	@Autowired
	private SerieParticipanteService s;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestParam Long idSerie,
			@RequestParam Long idParticipante,
			@RequestParam Boolean esActor,
			@RequestParam Boolean esDirector) {
		try {
			return ResponseEntity.ok().body(s.agregar(idSerie, idParticipante, esActor, esDirector)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/desagregar")
	public ResponseEntity<?> desagregar(@RequestParam Long idSerie,
			@RequestParam Long idParticipante) {
		try {
			s.desagregar(idSerie, idParticipante);
			return ResponseEntity.ok().body("Eliminación correcta"); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
