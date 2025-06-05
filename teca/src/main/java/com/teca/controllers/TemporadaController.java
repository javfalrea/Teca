package com.teca.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teca.service.TemporadaService;

@RestController
@RequestMapping("/temporada")
public class TemporadaController {
	
	@Autowired
	private TemporadaService s;
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestParam Integer numero,
			@RequestParam Integer anioEstreno,
			@RequestParam Integer numCapitulos,
			@RequestParam Integer duracionMedia,
			@RequestParam String sinopsis,
			@RequestParam Long idSerie) {
		try {
			return ResponseEntity.ok().body(s.crear(numero, anioEstreno, numCapitulos, duracionMedia, sinopsis, idSerie)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificar(@RequestParam Long id,
			@RequestParam Integer numero,
			@RequestParam Integer anioEstreno,
			@RequestParam Integer numCapitulos,
			@RequestParam Integer duracionMedia,
			@RequestParam String sinopsis,
			@RequestParam Long idSerie) {
		try {
			return ResponseEntity.ok().body(s.modificar(id, numero, anioEstreno, numCapitulos, duracionMedia, sinopsis, idSerie)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam Long id) {
		try {
			s.eliminar(id);
			return ResponseEntity.ok().body("Eliminación correcta"); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscarTodos")
	public ResponseEntity<?> buscarTodo() {
		try {
			return ResponseEntity.ok().body(s.buscarTodo()); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscarPorSerie")
	public ResponseEntity<?> buscarPorSerie(@RequestParam Long idSerie) {
		try {
			return ResponseEntity.ok().body(s.buscarPorSerie(idSerie)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
