package com.springboot.reservasapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.reservasapp.models.entity.Usuario;
import com.springboot.reservasapp.models.repository.UsuarioRepository;

@Service
public class UsuarioServiceImplement implements IntUsuarioService {

	@Autowired //inyectamos dependecia
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public List<Usuario> listarTodos() {
		
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		
		usuarioRepository.save(usuario);
		
	}


	@Override
	public Usuario buscarPorId(String id) {

		return usuarioRepository.findById(id).orElse(null);
	
		
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
	
		usuarioRepository.delete(usuario);

	}

	@Override
	public Usuario buscarPorUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
