package br.edu.ifba.plugin.ProgAcademica.visao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.ProgAcademica.controle.ControleDocumento;
import br.edu.ifba.plugin.ProgAcademica.modelo.ModeloDocumento;
import br.edu.ifba.plugin.ProgAcademica.modelo.bd.estatico.Documento;
import br.edu.ifba.plugin.ProgAcademica.visao.IPesquisaDocumento;

@ManagedBean(name = "pdocumento")
@ViewScoped
public class PesquisaDocumento implements IPesquisaDocumento {

	private boolean naoEncontrado = false;

	private String id = "";
	private String titulo = "";
	private String tipo = "";
	private String informacoes = "";
	private Date data = null;

	private List<Documento> documentosEncontrados = new ArrayList<Documento>();

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	@Override
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void pesquisar() {
		System.out.println("pesquisar");

		ModeloDocumento modelo = new ModeloDocumento();
		ControleDocumento controle = new ControleDocumento();

		controle.setModeloDocumento(modelo);
		controle.setPesquisaDocumento(this);

		controle.pesquisar();
	}

	@Override
	public void atualizarDocumentosEncontrados(List<Documento> documentos) {
		this.documentosEncontrados = documentos;
	}

	public List<Documento> getDocumentos() {
		return this.documentosEncontrados;
	}

	private void exibirCadastro(String id) {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		context.getSessionMap().put("idDocumento", id);
		try {
			context.redirect("cadastro_pacademica.ifba");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ver(String id) {
		exibirCadastro(id);
	}

	public void adicionar() {
		exibirCadastro("");
	}

	public void remover(String id) {
		this.id = id;

		ModeloDocumento modelo = new ModeloDocumento();
		ControleDocumento controle = new ControleDocumento();

		controle.setModeloDocumento(modelo);
		controle.setPesquisaDocumento(this);

		controle.remover();
	}

	public boolean getNaoEncontrado() {
		return naoEncontrado;
	}

	@Override
	public void notificarDocumentosNaoEncontrados() {
		naoEncontrado = true;
	}

}
