package br.com.bandtec.AgendaDeObjetivos.controller;

import br.com.bandtec.AgendaDeObjetivos.modelos.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.modelos.Usuario;
import br.com.bandtec.AgendaDeObjetivos.resources.TodosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	private TodosUsuarios todosUsuarios;

	//pega a instancia criada do TodosUsuarios, já que ele é um repositório
	//basicamente ele faz uma injeção de dependencia, pesquisar sobre isso depois
	@Autowired
	public LoginController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		if (todosUsuarios.existe(credenciais) != null) {
			return ResponseEntity.ok("Sucesso");
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro no Login");
	}

	@PostMapping("/cadastro")
	public  ResponseEntity<String> cadastrar(@RequestBody Usuario usuario) {
		todosUsuarios.save(usuario);
		return ResponseEntity.ok("Sucesso");
	}


	// java -cp h2-1.4.199.jar org.h2.tools.Server
	
	
	
}
