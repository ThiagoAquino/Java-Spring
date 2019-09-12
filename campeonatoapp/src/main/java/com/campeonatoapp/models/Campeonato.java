package com.campeonatoapp.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Campeonato implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	@NotEmpty
	private String nome;
	@NotEmpty
	private String local;
	@NotEmpty
	private String data;
	@NotEmpty
	private String horario;
	
	
	/** Aqui é definida a relação, onde cada campepnato tem várias academias */
	@OneToMany
	private List<Academia> academias;
	
	public Campeonato(String nome, String local, String data, String horario) {
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
	}
	
	public Campeonato() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getData() {
		return data; 
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}

	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public List<Academia> getAcademias() {
		return academias;
	}

	public void setAcademias(List<Academia> academias) {
		this.academias = academias;
	}
	
	
	
	

}
