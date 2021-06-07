package com.springboot.reservasapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.reservasapp.models.entity.Actividad;
import com.springboot.reservasapp.models.entity.Tipo;
import com.springboot.reservasapp.models.service.IntActividadService;
import com.springboot.reservasapp.models.service.IntTipoService;

@Controller
@RequestMapping("/views/actividades") //mapeo para las vistas de esta clase
public class ActividadController {
	
	
	@Autowired
	private IntActividadService actividadService;
	
	@Autowired
	private IntTipoService tipoService;
	
	@GetMapping("/")
	public String listarActividades(Model model) {
		List<Actividad> listadoActividades= actividadService.listarTodas();
		
		model.addAttribute("titulo", "Lista de actividades");
		model.addAttribute("actividades", listadoActividades);
		
		return "/views/actividades/listarActividades";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		Actividad actividad= new Actividad();
		List<Tipo> listTipos=tipoService.listarTodas();
		
		model.addAttribute("titulo", "Nueva actividad");
		model.addAttribute("actividad", actividad);
		model.addAttribute("tipos", listTipos);
		
		return "/views/actividades/FormCrearAct";
	}
	
	@PostMapping("/create")
	public String guardar (Model model, @Valid @ModelAttribute("actividad") Actividad actividad, BindingResult bindingResult) {
	 
		if (bindingResult.hasErrors()) {
			return "/views/actividades/FormCrearAct";
		}
			 	 
		actividadService.guardar(actividad);
		System.out.println("Guardado con éxito");
		
		return "redirect:/views/actividades/";

		}
	@GetMapping("/edit/{id}")
	public String editar(Model model, @PathVariable("id") Actividad actividad) {
		
		model.addAttribute("titulo", "Editar actividad");
		model.addAttribute("actividad",  actividad);
		
		return "/views/actividades/FormCrearAct";
				
		}
	@PostMapping("/edit/{id}")
	public String editar (Model model, @PathVariable("id") Actividad actividad, @Valid @ModelAttribute("actividad") Actividad actividadEdit, BindingResult bindingResult) {
	 
		if (bindingResult.hasErrors()) {
			return "/views/actividades/FormCrearAct";
		}
		
		actividad.setNombre(actividadEdit.getNombre());
		actividad.setDescripcion(actividadEdit.getDescripcion());
		actividad.setEstado(actividadEdit.getEstado());
		actividadService.guardar(actividad);
		System.out.println("Guardado con éxito");
		
		return "redirect:/views/actividades/";
		}

	@GetMapping("/delete/{id}")
	public String elminar(Model model, @PathVariable("id") Actividad actividad) {
		
		actividadService.eliminarActividad(actividad);
		
		System.out.println("Eliminado con éxito");
		
		return "redirect:/views/actividades/";
				
		}

	}

