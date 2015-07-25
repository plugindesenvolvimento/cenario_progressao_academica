package br.edu.ifba.plugin.ProgAcademica.visao;

import br.edu.ifba.plugin.ProgAcademica.modelo.bd.estatico.Documento;

public interface ICadastroDocumento {
	
	public int getId();
	
	public Documento getDocumento();
	
	///////////////////////
	
	public void atualizarDocumentoEncontrado(Documento documento);
	
	public void notificarDocumentoNaoEncontrado();
	
	public void notificarDocumentoGravado(Documento documento);
	
	public void notificarErroGravacao();
	
}
