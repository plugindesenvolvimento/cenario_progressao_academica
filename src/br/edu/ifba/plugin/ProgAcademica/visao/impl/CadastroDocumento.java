package br.edu.ifba.plugin.ProgAcademica.visao.impl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.edu.ifba.plugin.ProgAcademica.controle.ControleDocumento;
import br.edu.ifba.plugin.ProgAcademica.modelo.ModeloDocumento;
import br.edu.ifba.plugin.ProgAcademica.modelo.bd.estatico.Documento;
import br.edu.ifba.plugin.ProgAcademica.visao.ICadastroDocumento;

@ManagedBean(name = "caddocumento")
@ViewScoped
public class CadastroDocumento implements ICadastroDocumento {

	private String id = "";
	private Documento documento = new Documento();

	public CadastroDocumento() {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		id = (String) context.getSessionMap().get("idDocumento");
		System.out.println("ID do documento = " + id);
		
		if(id != null)
			recuperarDocumento();
	}

	
	private void recuperarDocumento() {
		ModeloDocumento modelo = new ModeloDocumento();
		ControleDocumento controle = new ControleDocumento();

		controle.setModeloDocumento(modelo);
		controle.setCadastroDocumento(this);

		controle.pesquisarParaCadastro(Integer.parseInt(id));
	}

	@Override
	public int getId() {
		int iid = -1;
		
		if (!id.isEmpty()) {
			iid = Integer.parseInt(id);
		}
		
		return iid;
	}
	
	@Override
	public Documento getDocumento() {
		return documento;
	}

	public void gravar() {
		System.out.println("Gravando = " + documento);
	}

	@Override
	public void atualizarDocumentoEncontrado(Documento documento) {
		this.documento = documento;
	}

	@Override
	public void notificarDocumentoNaoEncontrado() {
		System.out
				.println("Documento não encontrado. Talvez ele tenha sido removido!");
	}

	@Override
	public void notificarDocumentoGravado(Documento documento) {
		this.documento = documento;

		System.out.println("Documento salvo com sucesso!");
	}

	@Override
	public void notificarErroGravacao() {
		System.out.println("Erro de gravação de dados do documento!");
	}

}
