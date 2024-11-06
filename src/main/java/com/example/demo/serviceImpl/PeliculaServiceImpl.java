package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPeliculaDao;
import com.example.demo.entity.Pelicula;
import com.example.demo.service.PeliculaService;

import jakarta.transaction.Transactional;

@Service
public class PeliculaServiceImpl implements PeliculaService{
	
	@Autowired
	private IPeliculaDao peliculaDao;

	@Transactional
	public List<Pelicula> findAll() {
		return (List<Pelicula>) peliculaDao.findAll();
	}

	@Transactional
	public void save(Pelicula pelicula) {
		peliculaDao.save(pelicula);
		
	}

	@Transactional
	public Pelicula findOne(Long id) {
		return peliculaDao.findById(id).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		peliculaDao.deleteById(id);
		
	}

	@Transactional
	public List<Pelicula> findByTitulo(String titulo) {
		return null;
	}
	
	
}
