package br.com.ifpb.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Contato> lista = new ArrayList<>();

	static {
		Contato contato = new Contato();
		contato.setNome("Jardel");
		contato.setTelefone("(81) 9.8954-1260"); 	
		Contato contato2 = new Contato();
		contato2.setNome("Teste");
		contato2.setTelefone("01234567890");
		Banco.lista.add(contato);
		Banco.lista.add(contato2);
	}

	public void adiciona(Contato contato) {
		Banco.lista.add(contato);
	}

	public List<Contato> getContatos() {
		return Banco.lista;
	}
	
	public void remove(Contato contato) {
		Banco.lista.remove(contato);
	}
}
