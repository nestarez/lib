package com.libreria.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.libreria.model.Libro;
import com.libreria.service.ILibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	private ILibroService service;
	
	/*@PostMapping
	public ResponseEntity<Libro> registrar(@Valid @RequestBody Libro obj) {
		Libro lib = service.registrar(obj);
		return new ResponseEntity<Libro>(lib, HttpStatus.CREATED);
	}*/
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Libro obj) {
		Libro lib = service.registrar(obj);
		
		// localhost:8080/Libros/2
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lib.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Libro> modificar(@Valid @RequestBody Libro obj) {
		Libro lib = service.modificar(obj);
		return new ResponseEntity<Libro>(lib, HttpStatus.OK);
	}

	/*@GetMapping("/{id}")
	public ResponseEntity<Libro> listarPorId(@PathVariable("id") Integer id) {
		Libro lib = service.listarPorId(id);
		if(lib.getIdLibro() == null) {
			throw new ModeloNotFoundException("ID no existe: " + id);
		}
		return new ResponseEntity<Libro>(lib, HttpStatus.OK); 
	}*/
	
	@GetMapping(value = "/{id}")
	public Libro listarPorId(@PathVariable("id") Integer id){
		
		Libro lib = service.listarPorId(id);
		
		return lib;
	}

	//@PreAuthorize("@restAuthService.hasAccess('listar')")
	//@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping
	public ResponseEntity<List<Libro>> listar() {
		List<Libro> lista = service.listar();
		return new ResponseEntity<List<Libro>>(lista, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscar/genero/{idGenero}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> listar(@PathVariable("idGenero") Integer idGenero) {
		List<Libro> libros = new ArrayList<>();
		libros = service.listarLibroPorGenero(idGenero);
		return new ResponseEntity<List<Libro>>(libros, HttpStatus.OK);
	}

}
