package br.edu.ifba.plugin.ProgAcademica.visao.impl;

import javax.faces.bean.ManagedBean;

import br.edu.ifba.plugin.ProgAcademica.controle.ControleAcesso;
import br.edu.ifba.plugin.ProgAcademica.modelo.ModeloDocumento;
import br.edu.ifba.plugin.ProgAcademica.modelo.bd.estatico.Documento;
import br.edu.ifba.plugin.ProgAcademica.visao.IAcessoDocumento;

/**
 * Concretizacao de interface para validacao de credenciais (login + senha) de
 * acesso do usuario.
 * 
 * Esta concretizacao pode ser utilizada para validar requisitos relacionados ao
 * controle de acesso de usuarios aas funcionalidades do sistema. Nao sao
 * tratados recursos graficos/visuais de interacao do usuario (e.g. tela de
 * login). Toda a interacao eh realizada atraves do console da aplicacao.
 * 
 * @author PLUGIN
 */
@ManagedBean(name = "acesso")
public class AcessoDocumento implements IAcessoDocumento {

	private String login, senha;
	private boolean semPermissao = false;

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String getLogin() {
		return login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String getSenha() {
		return senha;
	}

	public void acessar() {
		ModeloDocumento modelo = new ModeloDocumento();
		ControleAcesso controle = new ControleAcesso();

		controle.setModeloDocumento(modelo);
		controle.setAcessoDocumento(this);

		controle.validarAcesso();
	}

	@Override
	public void atualizarDocumentoComPermissao(Documento documento) {
		System.out.println("Usuario com permissao de acesso = "
				+ documento.getTitulo());
	}


	@Override
	public void notificarSemPermissao() {
		semPermissao = true;
	}

	public boolean getSemPermissao() {
		return semPermissao;
	}

}

