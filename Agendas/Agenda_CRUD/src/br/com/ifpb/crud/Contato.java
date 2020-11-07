package br.com.ifpb.crud;

import java.util.Date;

public class Contato {
	private String nome;
	private String telefone;
	private int id;
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String id) {
		this.telefone = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
