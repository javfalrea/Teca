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

import com.teca.service.PaisService;

@RestController
@RequestMapping("/pais")
public class PaisController {
	
	@Autowired
	private PaisService s;
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestParam String nombre,
			@RequestParam String bandera) {
		try {
			return ResponseEntity.ok().body(s.crear(nombre, bandera)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<?> modificar(@RequestParam Long id,
			@RequestParam String nombre,
			@RequestParam String bandera) {
		try {
			return ResponseEntity.ok().body(s.modificar(id, nombre, bandera)); 
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
	
	@GetMapping("/buscarPorNombre")
	public ResponseEntity<?> buscarPorNombre(@RequestParam(required=false) String nombre) {
		try {
			return ResponseEntity.ok().body(s.buscarPorNombre(nombre)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscarPorPelicula")
	public ResponseEntity<?> buscarPorPelicula(@RequestParam Long id) {
		try {
			return ResponseEntity.ok().body(s.buscarPorPelicula(id)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscarPorSerie")
	public ResponseEntity<?> buscarPorSerie(@RequestParam Long id) {
		try {
			return ResponseEntity.ok().body(s.buscarPorSerie(id)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@GetMapping("/buscarPorParticipante")
	public ResponseEntity<?> buscarPorParticipante(@RequestParam Long id) {
		try {
			return ResponseEntity.ok().body(s.buscarPorParticipante(id)); 
		} catch (SQLException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
