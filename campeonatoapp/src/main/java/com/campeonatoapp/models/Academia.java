package com.campeonatoapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Academia {
	
	@Id
	@NotEmpty
	private String registro;
	@NotEmpty
	private String nomeAcademia;
	
	/** Aqui é definida a relação, onde cada campeonato tem várias academias */
	@ManyToOne
	private Campeonato campeonato;
	
	
	public Academia(String registro, String nomeAcademia) {
		this.registro = registro;
		this.nomeAcademia = nomeAcademia;
	}
	
	public Academia() {}	
	
	public String getRegistro() {
		return registro;
	}
	
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getNomeAcademia() {
		return nomeAcademia;
	}
	public void setNomeAcademia(String nomeAcademia) {
		this.nomeAcademia = nomeAcademia;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	
	
}
