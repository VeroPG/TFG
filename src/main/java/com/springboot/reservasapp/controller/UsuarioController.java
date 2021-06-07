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
import com.springboot.reservasapp.models.entity.Usuario;
import com.springboot.reservasapp.models.service.IntUsuarioService;



@Controller
@RequestMapping("/views/usuarios") //mapeo para las vistas de esta clase
public class UsuarioController {

	@Autowired
	private IntUsuarioService usuarioService;
	
	@GetMapping("/")
	public String listarUsuarios(Model model) {
		List<Usuario> listadoUsuarios= usuarioService.listarTodos();
		
		model.addAttribute("titulo", "Lista de usuarios");
		model.addAttribute("usuarios", listadoUsuarios);
		
		return "/views/usuarios/listarUsuarios";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {
		
		model.addAttribute("titulo", "Añadir usuario");
		model.addAttribute("usuario", new Usuario());
		
		return "/views/usuarios/FormCrearUsu";
	}
	@PostMapping("/create")
	public String guardar (Model model, @Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {
	 
		if (bindingResult.hasErrors()) {
			return "/views/usuarios/FormCrearUsu";
		}
			 	 
		usuarioService.guardar(usuario);
		System.out.println("Guardado con éxito");
		
		return "redirect:/views/usuarios/";

		}
	
	@GetMapping("/edit/{id}")
	public String editar(Model model, @PathVariable("id") Usuario usuario) {
		
		model.addAttribute("titulo", "Editar usuario");
		model.addAttribute("usuario",  usuario);
		
		return "/views/usuarios/FormCrearUsu";
				
		}
	@PostMapping("/edit/{id}")
	public String editar (Model model, @PathVariable("id") Usuario usuario, @Valid @ModelAttribute("usuario") Usuario usuarioEdit, BindingResult bindingResult) {
	 
		if (bindingResult.hasErrors()) {
			return "/views/tipos/FormCrearUsu";
		}
		usuario.setUsername(usuarioEdit.getUsername());
		usuario.setPassword(usuarioEdit.getPassword());
		usuario.setEmail(usuarioEdit.getEmail());
		usuario.setNombre(usuarioEdit.getNombre());
		usuario.setDireccion(usuarioEdit.getDireccion());
		usuarioService.guardar(usuario);
		System.out.println("Guardado con éxito");
		
		return "redirect:/views/usuarios/";
		}
}