package com.libreria.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.libreria.model.Libro;

public interface ILibroRepo extends JpaRepository<Libro, Integer>{

	List<Libro> findAllByGenero(Integer idGenero);

}
