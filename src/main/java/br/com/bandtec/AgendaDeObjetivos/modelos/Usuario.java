package br.com.bandtec.AgendaDeObjetivos.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private long id;

	@Embedded
	private Credenciais credenciais;

	public Usuario() {
	}

	public Usuario(long id, String login, String senha) {
		super();
		this.id = id;

	}

}



