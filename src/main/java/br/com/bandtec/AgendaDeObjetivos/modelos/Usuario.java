package br.com.bandtec.AgendaDeObjetivos.modelos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue
	private long id;

	@Embedded
	private Credenciais credenciais;

	@OneToMany(mappedBy = "usuario")
	private List<Objetivo> objetivos;

	public Usuario() {
	}

	public Usuario(long id, String login, String senha) {
		super();
		this.id = id;

	}

}



