package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IResenaDao;
import com.example.demo.entity.Resena;
import com.example.demo.service.ResenaService;

import jakarta.transaction.Transactional;

@Service
public class ResenaServiceImpl implements ResenaService {

	@Autowired
	private IResenaDao resenaDao;
	
	@Transactional
	public List<Resena> findAll() {
		return (List<Resena>) resenaDao.findAll();
	}

	@Transactional
	public void save(Resena resena) {
		resenaDao.save(resena);
		
	}

	@Transactional
	public Resena findOne(Long id) {
		return resenaDao.findById(id).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		resenaDao.deleteById(id);
	}

}
