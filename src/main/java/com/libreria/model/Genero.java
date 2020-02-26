package com.libreria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "genero")
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_genero")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenero;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "genero")
    @Builder.Default
    private List<Libro> libros = new ArrayList<>();

    public Integer getId() {
        return idGenero;
    }

    public void setId(Integer id) {
        this.idGenero = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Genero{" + "nombre=" + nombre + '}';
    }
    
    

}