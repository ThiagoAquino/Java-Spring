package com.campeonatoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.campeonatoapp.models.Campeonato;
import com.campeonatoapp.repository.CampeonatoRepository;

@Controller
public class CampeonatoController {
	
	@Autowired
	private CampeonatoRepository campeonatoRepository;
	
	@RequestMapping(value="/cadastrarCampeonato", method=RequestMethod.GET)
	public String form() {
		return "campeonato/formCampeonato";
	}
	
	@RequestMapping(value="/cadastrarCampeonato", method=RequestMethod.POST)
	public String form(Campeonato campeonato) {
		
		campeonatoRepository.save(campeonato);
		
		return "redirect:/cadastrarCampeonato";
	}
}
