package br.com.ifpb.jstl;

import java.util.Date;

public class Contato {
	private String nome;
	private String telefone;
	private Date dataDeAbertura = new Date();
	
	
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
	public Date getDataDeAbertura() {
		return dataDeAbertura;
	}
	public void setDataDeAbertura(Date dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}
}
