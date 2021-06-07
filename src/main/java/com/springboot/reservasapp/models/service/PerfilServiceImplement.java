package com.springboot.reservasapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.reservasapp.models.entity.Perfil;
import com.springboot.reservasapp.models.repository.PerfilRepository;


@Service
public class PerfilServiceImplement implements IntPerfilService {

	@Autowired //inyectamos dependecia
	private PerfilRepository perfilRepository;
	
	@Override
	public List<Perfil> listarTodos() {
		
		return (List<Perfil>) perfilRepository.findAll();
	}

	@Override
	public void guardar(Perfil perfil) {
		
		perfilRepository.save(perfil);
		
	}

	@Override
	public Perfil buscarPorId(int id) {
		
		return perfilRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarPerfil(Perfil perfil) {
		
		perfilRepository.delete(perfil);

	}

}
