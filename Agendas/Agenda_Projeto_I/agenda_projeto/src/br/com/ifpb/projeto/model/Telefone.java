package br.com.ifpb.projeto.model;

import java.util.ArrayList;
import java.util.List;

public class Telefone {
	private int id;
	private String ddd;
	private String numero;
	private List<Contato> contatos;
	
	public Telefone() {
		this.contatos = new ArrayList<Contato>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public List<Contato> getContatos() {
		return contatos;
	}
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
}
