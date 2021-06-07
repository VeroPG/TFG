package com.springboot.reservasapp.models.service;

import java.util.List;

import com.springboot.reservasapp.models.entity.Actividad;

public interface IntActividadService {
	
	public List<Actividad> listarTodas();
	public void guardar (Actividad actividad);
	
	public Actividad buscarPorId(int id);
	public void eliminarActividad(Actividad actividad);
	

}
