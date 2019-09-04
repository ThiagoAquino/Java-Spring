package com.campeonatoapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.campeonatoapp.models.Campeonato;

public interface CampeonatoRepository extends CrudRepository<Campeonato, String> {
	Campeonato findByCodigo(long codigo);
	
}
