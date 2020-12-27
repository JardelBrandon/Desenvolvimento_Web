package br.com.ifpb.agenda_JSF.bean;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import br.com.ifpb.agenda_JSF.dao.DAO;
import br.com.ifpb.agenda_JSF.modelo.Contato;
import br.com.ifpb.agenda_JSF.util.Genero;

@ManagedBean
public class ContatoBean {
	
	Genero genero;

	private Contato contato = new Contato();

	public Contato getContato() {
		return contato;
	}
    
	private static Map<String, Genero> gerneroValor;
    static
    {
        gerneroValor = new LinkedHashMap<String, Genero>();
 
        gerneroValor.put("Masculino", Genero.MASCULINO); //label, value
        gerneroValor.put("Feminino", Genero.FEMININO);
    }
 
    public Map<String, Genero> getGeneroValor()
    {
        return gerneroValor;
    }

	public void gravar() {
		System.out.println("Gravando contato " + this.contato.getNome());

		new DAO<Contato>(Contato.class).adiciona(this.contato);
	}
}
