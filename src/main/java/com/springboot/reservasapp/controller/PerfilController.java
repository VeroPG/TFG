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

import com.springboot.reservasapp.models.entity.Perfil;
import com.springboot.reservasapp.models.service.IntPerfilService;


@Controller
@RequestMapping("/views/perfiles") //mapeo para las vistas de esta clase
public class PerfilController {

	@Autowired
	private IntPerfilService perfilService;

	@GetMapping("/")
	public String listarPerfiles(Model model) {
		List<Perfil> listadoPerfiles= perfilService.listarTodos();
		
		model.addAttribute("titulo", "Lista de perfiles");
		model.addAttribute("perfiles", listadoPerfiles);
		
		return "/views/perfiles/listarPerfiles";
	}

	@GetMapping("/create")
	public String crear(Model model) {
		model.addAttribute("titulo", "Añadir perfil");
		model.addAttribute("perfil", new Perfil());
		
		return "/views/perfiles/FormCrearPerfil";

		}
	
	@PostMapping("/create")
	public String guardar (Model model, @Valid @ModelAttribute("perfil") Perfil perfil, BindingResult bindingResult) {
	 
		if (bindingResult.hasErrors()) {
			return "/views/perfiles/FormCrearPerfil";
		}
			 	 
		perfilService.guardar(perfil);
		System.out.println("Guardado con éxito");
		
		return "redirect:/views/perfiles/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(Model model, @PathVariable("id") Perfil perfil) {
		
		model.addAttribute("titulo", "Editar perfil");
		model.addAttribute("perfil", perfil);
		
		return "/views/perfiles/FormCrearPerfil";
				
		}
	
	@PostMapping("/edit/{id}")
	public String editar (Model model, @PathVariable("id") Perfil perfil, @Valid @ModelAttribute("perfil") Perfil perfilEdit, BindingResult bindingResult) {
	 
		if (bindingResult.hasErrors()) {
			return "/views/perfiles/FormCrearPerfil";
		}
		
		perfil.setNombre(perfilEdit.getNombre());
		perfilService.guardar(perfil);
		System.out.println("Guardado con éxito");
		
		return "redirect:/views/perfiles/";
		}
	
	
	@GetMapping("/delete/{id}")
	public String elminar(Model model, @PathVariable("id") Perfil perfil) {
		
		perfilService.eliminarPerfil(perfil);
		
		System.out.println("Eliminado con éxito");
		
		return "redirect:/views/perfiles/";
				
		}

	}