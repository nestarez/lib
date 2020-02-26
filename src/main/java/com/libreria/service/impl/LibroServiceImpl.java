package com.libreria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.model.Libro;
import com.libreria.repo.ILibroRepo;
import com.libreria.service.ILibroService;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	private ILibroRepo repo;

	@Override
	public Libro registrar(Libro obj) {
		return repo.save(obj);
	}

	@Override
	public Libro modificar(Libro obj) {
		return repo.save(obj);
	}

	@Override
	public List<Libro> listar() {
		return repo.findAll();
	}

	@Override
	public Libro listarPorId(Integer id) {
		Optional<Libro> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Libro();
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<Libro> listarLibroPorGenero(Integer idGenero) {
		return repo.findAllByGenero(idGenero);
	}

}
