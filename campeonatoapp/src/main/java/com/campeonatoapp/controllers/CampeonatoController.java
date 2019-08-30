package com.campeonatoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CampeonatoController {
	
	@RequestMapping("/cadastrarCampeonato")
	public String form() {
		return "campeonato/formCampeonato";
	}

}
