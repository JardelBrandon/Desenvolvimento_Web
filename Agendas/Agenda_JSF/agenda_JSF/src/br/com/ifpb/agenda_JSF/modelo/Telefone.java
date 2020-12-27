package br.com.ifpb.agenda_JSF.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Telefone {

	@Id
	@GeneratedValue
	private Integer id;

	private String ddd;
	private String numero;

	@ManyToMany
	private List<Contato> proprietarios = new ArrayList<Contato>();

	public List<Contato> getProprietarios() {
		return proprietarios;
	}

	public void adicionaProprietario(Contato proprietario) {
		if (!this.proprietarios.contains(proprietario)) {
			this.proprietarios.add(proprietario);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setProprietarios(List<Contato> proprietarios) {
		this.proprietarios = proprietarios;
	}
}