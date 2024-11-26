package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUsuarioDao;
import com.example.demo.entity.Usuario;
import com.example.demo.service.UsuarioService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Transactional
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Transactional
	public Usuario findOne(Long id) {
		return usuarioDao.findById(id).orElse(null);
	}

	@Transactional
	public void delete(Long id) {
		usuarioDao.deleteById(id);
		
	}
	
}
