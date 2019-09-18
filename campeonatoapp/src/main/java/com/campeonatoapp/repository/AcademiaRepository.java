package com.campeonatoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.campeonatoapp.models.Academia;
import com.campeonatoapp.models.Campeonato;

public interface AcademiaRepository extends CrudRepository<Academia, String>{
	Iterable<Academia> findByCampeonato(Campeonato campeonato);
	Academia findByRegistro(String registro);
}
