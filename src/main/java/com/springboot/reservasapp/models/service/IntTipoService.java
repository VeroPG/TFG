package com.springboot.reservasapp.models.service;

import java.util.List;

import com.springboot.reservasapp.models.entity.Tipo;


public interface IntTipoService {

	public List<Tipo> listarTodas();
	public void guardar (Tipo tipo);
	
	public Tipo buscarPorId(int id);
	public void eliminarTipo(Tipo tipo);
	


}