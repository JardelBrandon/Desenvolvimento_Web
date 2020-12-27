package br.com.ifpb.agenda_JSF.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.ifpb.agenda_JSF.dao.DAO;
import br.com.ifpb.agenda_JSF.modelo.Contato;
import br.com.ifpb.agenda_JSF.modelo.Telefone;

@ManagedBean
@ViewScoped
public class TelefoneBean {

	private Telefone telefone = new Telefone();
	private Integer proprietarioId;

	public void setProprietarioId(Integer proprietarioId) {
		this.proprietarioId = proprietarioId;
	}

	public Integer getProprietarioId() {
		return proprietarioId;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public List<Telefone> getTelefones() {
		return new DAO<Telefone>(Telefone.class).listaTodos();
	}

	public List<Contato> getProprietarios() {
		return new DAO<Contato>(Contato.class).listaTodos();
	}

	public List<Contato> getProprietariosDoTelefone() {
		return this.telefone.getProprietarios();
	}

	public void adicionarProprietario() {

		Contato proprietario = new DAO<Contato>(Contato.class).buscaPorId(this.proprietarioId);
		System.out.println("Usando proprietario " + proprietario.getNome());
		this.telefone.adicionaProprietario(proprietario);
	}

	public void gravar() {
		System.out.println("Gravando telefone " + this.telefone.getDdd() + this.telefone.getNumero());

		if (telefone.getProprietarios().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("proprietario",
					new FacesMessage("O telefone deve ter pelo menos um proprietário."));
		} else {
			new DAO<Telefone>(Telefone.class).adiciona(this.telefone);
			
			this.telefone = new Telefone();
			this.telefone.setProprietarios(new ArrayList<Contato>());
		}
	}
}
