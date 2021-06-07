package com.springboot.reservasapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
			
	@GetMapping({"/","home","index"})
		
		public String index(){
			
			return "/views/home";
		}
	
	@GetMapping("/cursos")
	
	public String cursos(){
		
		return "/views/cursos";
	}
	
	@GetMapping("/inmersiones")
	
	public String inmersiones(){
			
			return "/views/inmersiones";
		}

	@GetMapping("/nosotros")
	
	public String nosotros(){
			
			return "/views/nosotros";
		}
	
	@GetMapping("/contacto")
	
	public String contacto(){
			
			return "/views/contacto";
		}
	
	@GetMapping("/login")
		
		public String login(){
			
			return "/views/login";
		}
	
	@GetMapping("/legal")
	
	public String legal(){
		
		return "/views/legal";
		
	}
	
	@GetMapping("/privacidad")
		
		public String privacidad(){
			
			return "/views/privacidad";
		}
	
	@GetMapping("/cookies")
	
	public String cookiesl(){
		
		return "/views/cookies";
}

}
