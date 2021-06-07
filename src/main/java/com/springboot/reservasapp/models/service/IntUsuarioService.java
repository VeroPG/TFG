package com.springboot.reservasapp.models.service;

import java.util.List;

import com.springboot.reservasapp.models.entity.Usuario;


public interface IntUsuarioService {

	public List<Usuario> listarTodos();
	public void guardar (Usuario usuario);
	public Usuario buscarPorUsername(String username);
	public Usuario buscarPorId(String id);
	public void eliminarUsuario(Usuario usuario);
	

}