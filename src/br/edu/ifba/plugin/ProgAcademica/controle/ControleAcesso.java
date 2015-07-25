package br.edu.ifba.plugin.ProgAcademica.controle;

import br.edu.ifba.plugin.ProgAcademica.modelo.ModeloDocumento;
import br.edu.ifba.plugin.ProgAcademica.visao.IAcessoDocumento;

/**
 * Classe para controle de acesso.
 * 
 * Realiza a integracao entre o modelo {@link #modeloUsuario} e a interface de
 * componente grafico {@link #acessoUsuario}. Esta integracao ocorre a partir da
 * injecao da interface no modelo. O modelo eh ativo (i.e. o MVC implementado se
 * baseia no principio de Modelo ativo) e aciona atualizacoes na interface.
 * 
 * @author PLUGIN
 */
public class ControleAcesso {

	private IAcessoDocumento acessoDocumento = null;
	private ModeloDocumento modeloDocumento = null;

	public void setAcessoDocumento(IAcessoDocumento acesso) {
		this.acessoDocumento = acesso;
	}

	public void setModeloDocumento(ModeloDocumento modelo) {
		this.modeloDocumento = modelo;
	}

	public void validarAcesso() {
		modeloDocumento.setAcessoDocumento(acessoDocumento);
		modeloDocumento.validarAcesso();
	}

}
