package br.com.bandtec.AgendaDeObjetivos.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	private long id;

	@JsonProperty
	private String login;

	@JsonProperty
	private String senha;

	public Usuario() {}

	public Usuario(long id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}



}
