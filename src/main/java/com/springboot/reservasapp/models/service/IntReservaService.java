package com.springboot.reservasapp.models.service;

import java.util.List;

import com.springboot.reservasapp.models.entity.Reserva;


public interface IntReservaService {

	public List<Reserva> listarTodas();
	public void guardar (Reserva reserva);
	
	public Reserva buscarPorId(int id);
	public void eliminarReserva(int id);
	

}