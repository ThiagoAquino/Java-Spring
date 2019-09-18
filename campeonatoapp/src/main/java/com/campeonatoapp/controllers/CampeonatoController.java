package com.campeonatoapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.campeonatoapp.models.Academia;
import com.campeonatoapp.models.Campeonato;
import com.campeonatoapp.repository.AcademiaRepository;
import com.campeonatoapp.repository.CampeonatoRepository;

@Controller
public class CampeonatoController {
	
	@Autowired
	private CampeonatoRepository campeonatoRepository;
	
	@Autowired
	private AcademiaRepository academiaRepository;
	
	
	@RequestMapping(value="/cadastrarCampeonato", method=RequestMethod.GET)
	public String form() {
		return "campeonato/formCampeonato";
	}
	
	@RequestMapping(value="/cadastrarCampeonato", method=RequestMethod.POST)
	public String form(@Valid Campeonato campeonato, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos");
			return "redirect:/cadastrarCampeonato";
		}
		campeonatoRepository.save(campeonato);
		attributes.addFlashAttribute("mensagem", "Campeonato adicionado com sucesso");
		return "redirect:/cadastrarCampeonato";
	}
	
	@RequestMapping(value="/campeonatos", method=RequestMethod.GET)
	public ModelAndView listaCampeonatos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Campeonato> campeonatos = campeonatoRepository.findAll();
		mv.addObject("campeonatos", campeonatos);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesCampeonato(@PathVariable("codigo")long codigo) {
		Campeonato campeonato = campeonatoRepository.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("campeonato/detalhesCampeonato");
		mv.addObject("campeonato", campeonato);
		
		Iterable<Academia> academias = academiaRepository.findByCampeonato(campeonato);
		mv.addObject("academias", academias);
		return mv;
	}
	
	@RequestMapping("/deletarCampeonato")
	public String deletarCampeonato(long codigo) {
		Campeonato campeonato = campeonatoRepository.findByCodigo(codigo);
		campeonatoRepository.delete(campeonato);
		return "redirect:/campeonatos";
		
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesCampeonatoPost(@PathVariable("codigo")long codigo,@Valid Academia academia, BindingResult result, RedirectAttributes attributes) {
		/*Essa condição faz uma verificação se os campos estão preenchidos, caso contrário, 
		 * envia uma mensagem pra view */
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "verifique os campos");
			return "redirect:/{codigo}";
		}
		Campeonato campeonato = campeonatoRepository.findByCodigo(codigo);
		academia.setCampeonato(campeonato);
		academiaRepository.save(academia);
		attributes.addFlashAttribute("mensagem", "Academia adicionada com sucesso");
		
		
		return "redirect:/{codigo}";
	}
	
	@RequestMapping("/deletarAcademia")
	public String deletarAcademia(String registro) {
		Academia academia = academiaRepository.findByRegistro(registro);
		academiaRepository.delete(academia);
		
		Campeonato campeonato = academia.getCampeonato();
		long codigoLong = campeonato.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/"+codigo;
	}
	
}
