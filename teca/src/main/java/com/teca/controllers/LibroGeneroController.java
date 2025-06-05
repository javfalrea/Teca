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

import com.teca.service.LibroGeneroService;

@RestController
@RequestMapping("/libroGenero")
public class LibroGeneroController {
	
	@Autowired
	private LibroGeneroService s;
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestParam Long idLibro,
			@RequestParam Long idGenero) {
		try {
			return ResponseEntity.ok().body(s.agregar(idLibro, idGenero)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/desagregar")
	public ResponseEntity<?> desagregar(@RequestParam Long idLibro,
			@RequestParam Long idGenero) {
		try {
			s.desagregar(idLibro, idGenero);
			return ResponseEntity.ok().body("Eliminación correcta"); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
