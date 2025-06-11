package com.teca.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teca.service.SerieValoracionService;

public class SerieValoracionController {
	
	@Autowired
	private SerieValoracionService s;
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestParam Long idSerie,
			@RequestParam Long idUsuario,
			@RequestParam Boolean vista,
			@RequestParam Double valoracion,
			@RequestParam Boolean fav,
			@RequestParam String critica) {
		try {
			return ResponseEntity.ok().body(s.crear(idSerie, idUsuario, vista, valoracion, fav, critica)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificar(@RequestParam Long idSerie,
			@RequestParam Long idUsuario,
			@RequestParam Boolean vista,
			@RequestParam Double valoracion,
			@RequestParam Boolean fav,
			@RequestParam String critica) {
		try {
			return ResponseEntity.ok().body(s.modificar(idSerie, idUsuario, vista, valoracion, fav, critica)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam Long idSerie, 
			@RequestParam Long idUsuario) {
		try {
			s.eliminar(idSerie, idUsuario);
			return ResponseEntity.ok().body("Eliminación correcta"); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscarPorSerieYUsuario")
	public ResponseEntity<?> buscarPorSerieYUsuario(@RequestParam Long idSerie,
			@RequestParam Long idUsuario) {
		try {
			return ResponseEntity.ok().body(s.buscarPorSerieYUsuario(idSerie, idUsuario)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}


}
