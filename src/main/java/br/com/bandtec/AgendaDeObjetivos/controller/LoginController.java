package br.com.bandtec.AgendaDeObjetivos.controller;

import br.com.bandtec.AgendaDeObjetivos.modelos.Credenciais;
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

	@Autowired
	public LoginController(TodosUsuarios todosUsuarios) {
		this.todosUsuarios = todosUsuarios;
	}

	@PostMapping("/login")
	public ResponseEntity<String> validarLogin(@RequestBody Credenciais credenciais) {
		if (todosUsuarios.existe(credenciais.getUsuario(), credenciais.getSenha()) != null) {
			return ResponseEntity.ok("Sucesso");
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro");
	}


	// java -cp h2-1.4.199.jar org.h2.tools.Server
	
	
	
}
