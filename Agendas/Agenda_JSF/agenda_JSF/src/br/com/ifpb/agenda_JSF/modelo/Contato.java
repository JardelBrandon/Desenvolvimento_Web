package br.com.ifpb.agenda_JSF.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ifpb.agenda_JSF.util.Genero;

@Entity
public class Contato {

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataDeNascimento = Calendar.getInstance();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
}
