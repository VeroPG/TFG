package com.springboot.reservasapp.models.service;

import java.util.List;

import com.springboot.reservasapp.models.entity.Perfil;




public interface IntPerfilService {


		public List<Perfil> listarTodos();
		public void guardar (Perfil perfil);
		
		public Perfil buscarPorId(int id);
		public void eliminarPerfil(Perfil perfil);
		

	}