package com.springboot.reservasapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.reservasapp.models.entity.Reserva;
import com.springboot.reservasapp.models.repository.ReservaRepository;

@Service
public class RerservaServiceImplement implements IntReservaService {

	@Autowired //inyectamos dependecia
	private ReservaRepository reservaRepository;
	
	@Override
	public List<Reserva> listarTodas(){
		
		return (List<Reserva>) reservaRepository.findAll();
	}

	@Override
	public void guardar(Reserva reserva) {
		reservaRepository.save(reserva);

	}

	@Override
	public Reserva buscarPorId(int id) {
		
		return reservaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminarReserva(int id) {
		
		reservaRepository.deleteById(id);

	}

}
