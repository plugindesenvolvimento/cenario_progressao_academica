package br.edu.ifba.plugin.ProgAcademica.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.plugin.ProgAcademica.modelo.bd.estatico.Documento;
import br.edu.ifba.plugin.ProgAcademica.modelo.bd.estatico.DocumentoDAO;
import br.edu.ifba.plugin.ProgAcademica.visao.IAcessoDocumento;
import br.edu.ifba.plugin.ProgAcademica.visao.ICadastroDocumento;
import br.edu.ifba.plugin.ProgAcademica.visao.IPesquisaDocumento;

/**
 * Classe de Modelo especializada em manipular informacoes relacionadas aa
 * validacao de acesso do usuario.
 * 
 * Os modelos sao ativos, i.e. acionam automaticamente acoes na interface.
 * 
 * @author PLUGIN
 */
public class ModeloDocumento {


	private IAcessoDocumento acessoDocumento = null;
	private IPesquisaDocumento pesquisaDocumento = null;
	private ICadastroDocumento cadastroDocumento = null;

	public void setAcessoDocumento(IAcessoDocumento acesso) {
		this.acessoDocumento = acesso;
	}

	public void setPesquisaDocumento(IPesquisaDocumento pesquisa) {
		this.pesquisaDocumento = pesquisa;
	}

	public void setCadastroDocumento(ICadastroDocumento cadastro) {
		this.cadastroDocumento = cadastro;
	}

	public void validarAcesso() {
			List<Documento> documentos = DocumentoDAO.getDocumentosPorLoginSenha(
					acessoDocumento.getLogin(), acessoDocumento.getSenha());
			if (documentos.isEmpty()) {
				acessoDocumento.notificarSemPermissao();
			} else {
				Documento documento = documentos.get(0);
				acessoDocumento.atualizarDocumentoComPermissao(documento);
			}
	}

	public void pesquisar() {
		List<Documento> documentos = new ArrayList<Documento>();

		String criterio = pesquisaDocumento.getTitulo();
		if (!criterio.equals("")) {
			documentos = DocumentoDAO.getDocumentosPorTitulo(criterio);
		} else {
			SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
			criterio = formataData.format(pesquisaDocumento.getData());
			if (!criterio.equals("")) {
				documentos = DocumentoDAO.getDocumentosPorData(criterio);
			} 
	}
	

		pesquisaDocumento.atualizarDocumentosEncontrados(documentos);

		if (documentos.isEmpty()) {
			pesquisaDocumento.notificarDocumentosNaoEncontrados();
		}
	}

	public void pesquisarParaCadastro() {
		Documento documento = DocumentoDAO.getDocumento(cadastroDocumento.getId());

		if (documento != null) {
			cadastroDocumento.atualizarDocumentoEncontrado(documento);
		} else {
			cadastroDocumento.notificarDocumentoNaoEncontrado();
		}
	}

	public void remover() {
		DocumentoDAO.remover(Integer.parseInt(pesquisaDocumento.getId()));

		pesquisar();
	}

}
