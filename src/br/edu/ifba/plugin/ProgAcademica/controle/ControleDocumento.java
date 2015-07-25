package br.edu.ifba.plugin.ProgAcademica.controle;

import br.edu.ifba.plugin.ProgAcademica.modelo.ModeloDocumento;
import br.edu.ifba.plugin.ProgAcademica.visao.ICadastroDocumento;
import br.edu.ifba.plugin.ProgAcademica.visao.IPesquisaDocumento;

public class ControleDocumento {

	private IPesquisaDocumento pesquisaDocumento;
	private ICadastroDocumento cadastroDocumento;
	private ModeloDocumento modeloDocumento;

	public void setPesquisaDocumento(IPesquisaDocumento pesquisa) {
		this.pesquisaDocumento = pesquisa;
	}

	public void setCadastroDocumento(ICadastroDocumento cadastro) {
		this.cadastroDocumento = cadastro;
	}

	public void setModeloDocumento(ModeloDocumento modelo) {
		this.modeloDocumento = modelo;
	}

	
	public void pesquisar() {
		modeloDocumento.setPesquisaDocumento(pesquisaDocumento);
		modeloDocumento.pesquisar();
	}
	
	public void pesquisarParaCadastro(int id) {
		modeloDocumento.setCadastroDocumento(cadastroDocumento);
		modeloDocumento.pesquisarParaCadastro();
	}
	
	public void remover() {
		modeloDocumento.setPesquisaDocumento(pesquisaDocumento);
		modeloDocumento.remover();
	}	
	
}
