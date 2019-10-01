package br.com.bandtec.AgendaDeObjetivos.modelos;

import javax.persistence.Embeddable;

@Embeddable
public class Credenciais {
	
	private String usuario;
	private String senha;

	public Credenciais() {
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Credenciais(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}
	
	

}
