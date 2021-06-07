package com.springboot.reservasapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.reservasapp.models.entity.Tipo;
import com.springboot.reservasapp.models.repository.TiposRepository;

@Service 
public class TipoServiceImplement implements IntTipoService {

	@Autowired //inyectamos dependecia
	private TiposRepository tipoRepository;
	
	@Override
	public List<Tipo> listarTodas() {
		
		return (List<Tipo>) tipoRepository.findAll();
	}

	@Override
	public void guardar(Tipo tipo) {
		
		tipoRepository.save(tipo);
		
	}

	@Override
	public Tipo buscarPorId(int id) {
		
		return tipoRepository.findById(id).orElse(null);
	}



	@Override
	public void eliminarTipo(Tipo tipo) {
	
		tipoRepository.delete(tipo);
	}

}
