package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Pelicula;

public interface PeliculaService {
	
	public List<Pelicula> findAll();
	
	public void save(Pelicula pelicula);
	
	public Pelicula findOne(Long id);
	
	public void delete(Long id);
	
	public List<Pelicula> findByTitulo (String titulo);
}