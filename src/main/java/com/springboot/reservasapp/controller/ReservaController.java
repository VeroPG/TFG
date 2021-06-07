package com.springboot.reservasapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.reservasapp.models.entity.Reserva;
import com.springboot.reservasapp.models.service.IntReservaService;



@Controller
@RequestMapping("/views/reservas") //mapeo para las vistas de esta clase
public class ReservaController {

	@Autowired
	private IntReservaService reservaService;
	
	@GetMapping("/")
	public String listarReservas(Model model) {
		List<Reserva> listadoReservas= reservaService.listarTodas();
		
		model.addAttribute("titulo", "Lista de reservas");
		model.addAttribute("reservas", listadoReservas);
		
		return "/views/reservas/listarReservas";
	}
	
	@GetMapping("/createReserva")
	public String crear() {
		
		return "/views/reservas/FormCrearReserva";
	}
	

}
