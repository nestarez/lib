package com.libreria.service;

import java.util.List;

import com.libreria.model.Libro;

public interface ILibroService extends ICRUD<Libro>{
	
	List<Libro> listarLibroPorGenero(Integer idGenero);

}
