package com.campeonatoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping(value="/campeonatos", method=RequestMethod.GET)
	public ModelAndView listaCampeonatos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Campeonato> campeonatos = campeonatoRepository.findAll();
		mv.addObject("campeonatos", campeonatos);
		return mv;
	}
}
