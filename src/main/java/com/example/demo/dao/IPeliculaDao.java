package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Pelicula;

public interface IPeliculaDao extends CrudRepository<Pelicula, Long> {

}
