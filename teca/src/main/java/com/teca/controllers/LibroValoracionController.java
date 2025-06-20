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

import com.teca.service.LibroValoracionService;

@RestController
@RequestMapping("/libroValoracion")
public class LibroValoracionController {
	
	@Autowired
	private LibroValoracionService s;
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestParam Long idLibro,
			@RequestParam Double valoracion,
			@RequestParam Boolean fav,
			@RequestParam String critica) {
		try {
			return ResponseEntity.ok().body(s.crear(idLibro, valoracion, fav, critica)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificar(@RequestParam Long idLibro,
			@RequestParam Double valoracion,
			@RequestParam Boolean fav,
			@RequestParam String critica) {
		try {
			return ResponseEntity.ok().body(s.modificar(idLibro, valoracion, fav, critica)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/eliminar")
	public ResponseEntity<?> eliminar(@RequestParam Long idLibro) {
		try {
			s.eliminar(idLibro);
			return ResponseEntity.ok().body("Eliminación correcta"); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscarPorId")
	public ResponseEntity<?> buscarPorId(@RequestParam Long idLibro) {
		try {
			return ResponseEntity.ok().body(s.buscarPorId(idLibro)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
