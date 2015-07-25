package br.edu.ifba.plugin.ProgAcademica.visao;

import java.util.Date;
import java.util.List;

import br.edu.ifba.plugin.ProgAcademica.modelo.bd.estatico.Documento;

public interface IPesquisaDocumento {

	public String getId();
	
	public String getTitulo();
	
	public String getTipo();

	public String getInformacoes();
	
	public Date getData();

	///////////////////////

	public void atualizarDocumentosEncontrados(List<Documento> documentos);

	public void notificarDocumentosNaoEncontrados();

	

}
