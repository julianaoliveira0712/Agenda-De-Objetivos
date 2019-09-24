package br.com.bandtec.AgendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;

import br.com.bandtec.AgendaDeObjetivos.modelos.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.modelos.Usuario;
import br.com.bandtec.AgendaDeObjetivos.resources.TodosUsuarios;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTest {
	
	LoginController controller;
	TodosUsuarios todosUsuarios;

	@Before
	public void setUp() {
		todosUsuarios = Mockito.mock(TodosUsuarios.class);
		controller = new LoginController(todosUsuarios);
	}

	@Test
	public void loginComSucesso() {

    Credenciais c= new Credenciais("igual", "igual");
    Mockito.when(todosUsuarios.existe(c.getUsuario(), c.getSenha())).thenReturn(new Usuario(40,"igual", "igual" ));
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("igual", "igual"));

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Sucesso", resposta.getBody());
	}

	@Test
	public void loginComFalha() {
		ResponseEntity<String> resposta = controller.validarLogin(new Credenciais("login", "senha"));
		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
		assertEquals("Erro", resposta.getBody());
	}
	
}
