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

import com.teca.service.SerieService;

@RestController
@RequestMapping("/serie")
public class SerieController {
	
	@Autowired
	private SerieService s;
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestParam String titulo,
			@RequestParam String tituloOriginal,
			@RequestParam Boolean terminada,
			@RequestParam String sinopsis,
			@RequestParam String imagen,
			@RequestParam Long idPais) {
		try {
			return ResponseEntity.ok().body(s.crear(titulo, tituloOriginal, terminada, sinopsis, imagen, idPais)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificar(@RequestParam Long id,
			@RequestParam String titulo,
			@RequestParam String tituloOriginal,
			@RequestParam Boolean terminada,
			@RequestParam String sinopsis,
			@RequestParam String imagen,
			@RequestParam Long idPais) {
		try {
			return ResponseEntity.ok().body(s.modificar(id, titulo, tituloOriginal, terminada, sinopsis, imagen, idPais)); 
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
	
	@GetMapping("/buscarPorId")
	public ResponseEntity<?> buscarPorId(@RequestParam Long id) {
		try {
			return ResponseEntity.ok().body(s.buscarPorId(id)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/busquedaAvanzada")
	public ResponseEntity<?> busquedaAvanzada(@RequestParam(required = false) String tituloBq,
			@RequestParam(required = false) String participanteBq,
			@RequestParam(required = false) Long idGenero) {
		try {
			return ResponseEntity.ok().body(s.busquedaAvanzada(tituloBq, participanteBq, idGenero)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
