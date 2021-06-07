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

import com.springboot.reservasapp.models.entity.Tipo;
import com.springboot.reservasapp.models.service.IntTipoService;


@Controller
@RequestMapping("/views/tipos") //mapeo para las vistas de esta clase
public class TipoController {

@Autowired
private IntTipoService tipoService;

@GetMapping("/")
public String listarTipos(Model model) {
	List<Tipo> listadoTipos= tipoService.listarTodas();
	
	model.addAttribute("titulo", "Lista de tipos");
	model.addAttribute("tipos", listadoTipos);
	
	return "/views/tipos/listarTipos";
}

@GetMapping("/create")
public String crear(Model model) {
	
	model.addAttribute("titulo", "Añadir tipo");
	model.addAttribute("tipo", new Tipo());
	
	return "/views/tipos/FormCrearTipo";
}

@PostMapping("/create")
public String guardar (Model model, @Valid @ModelAttribute("tipo") Tipo tipo, BindingResult bindingResult) {
 
	if (bindingResult.hasErrors()) {
		return "/views/tipos/FormCrearTipo";
	}
		 	 
	tipoService.guardar(tipo);
	System.out.println("Guardado con éxito");
	
	return "redirect:/views/tipos/";

	}
@GetMapping("/edit/{id}")
public String editar(Model model, @PathVariable("id") Tipo tipo) {
	
	model.addAttribute("titulo", "Editar tipo");
	model.addAttribute("tipo",  tipo);
	
	return "/views/tipos/FormCrearTipo";
			
	}

@PostMapping("/edit/{id}")
public String editar (Model model, @PathVariable("id") Tipo tipo, @Valid @ModelAttribute("tipo") Tipo tipoEdit, BindingResult bindingResult) {
 
	if (bindingResult.hasErrors()) {
		return "/views/tipos/FormCrearTipo";
	}
	
	tipo.setNombre(tipoEdit.getNombre());
	tipo.setDescripcion(tipoEdit.getDescripcion());
	tipoService.guardar(tipo);
	System.out.println("Guardado con éxito");
	
	return "redirect:/views/tipos/";
	}

@GetMapping("/delete/{id}")
public String elminar(Model model, @PathVariable("id") Tipo tipo) {
	
	tipoService.eliminarTipo(tipo);
	
	System.out.println("Eliminado con éxito");
	
	return "redirect:/views/tipos/";
			
	}

}
