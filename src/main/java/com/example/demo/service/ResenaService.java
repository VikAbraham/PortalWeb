package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Resena;

public interface ResenaService {
	
	public List<Resena> findAll();
	
	public void save(Resena resena);
	
	public Resena findOne(Long id);
	
	public void delete(Long id);

}
