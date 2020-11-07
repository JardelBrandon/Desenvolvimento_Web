package br.com.ifpb.crud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.ifpb.crud.Banco;
import br.com.ifpb.crud.Contato;

public class Banco {

	private static List<Contato> lista = new ArrayList<>();
	private static int chaveId = 1;

	static {
		Contato contato = new Contato();
		contato.setNome("Jardel");
		contato.setTelefone("(81) 9.8954-1260"); 	
		contato.setId(chaveId++);
		Contato contato2 = new Contato();
		contato2.setNome("Teste");
		contato2.setTelefone("01234567890");
		contato2.setId(chaveId++);
		Banco.lista.add(contato);
		Banco.lista.add(contato2);
	}

	public void adiciona(Contato contato) {
		contato.setId(chaveId++);
		Banco.lista.add(contato);
	}

	public List<Contato> getContatos() {
		return Banco.lista;
	}
	
	public void remove(String[] values) {
		if (values != null) {
			System.out.println("Excluindo contato");
			for (String value : values) {
				System.out.println(value);
				Iterator<Contato> it = lista.iterator();
				while(it.hasNext()) {
					Contato contato = it.next();
					if (contato.getId() == Integer.parseInt(value)) {
						it.remove();
					}
				}
			}
		}
		chaveId--;
	}
	
	public static int getChaveId() {
		return chaveId;
	}

	public static void setChaveId(int chaveId) {
		Banco.chaveId = chaveId;
	}

	public Contato buscaContatoPeloId(int id) {
		for (Contato contato : lista) {
			if(contato.getId() == id) {
				return contato;
			}
		}
		return null;
	}
}
