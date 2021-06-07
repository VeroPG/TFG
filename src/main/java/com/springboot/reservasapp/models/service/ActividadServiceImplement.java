package com.springboot.reservasapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.reservasapp.models.entity.Actividad;
import com.springboot.reservasapp.models.repository.ActividadRepository;

@Service 
public class ActividadServiceImplement implements IntActividadService {

	@Autowired //inyectamos dependecia
	private ActividadRepository actividadRepository;
	
	@Override
	public List<Actividad> listarTodas() {
		
		return (List<Actividad>) actividadRepository.findAll();
	}

	@Override
	public void guardar(Actividad actividad) {
		
		actividadRepository.save(actividad);
		
	}

	@Override
	public Actividad buscarPorId(int id) {
		
		return actividadRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarActividad(Actividad actividad) {
		
		actividadRepository.delete(actividad);

	}

}
