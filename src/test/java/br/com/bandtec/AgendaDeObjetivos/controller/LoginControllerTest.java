package br.com.bandtec.AgendaDeObjetivos.controller;

import br.com.bandtec.AgendaDeObjetivos.modelos.Credenciais;
import br.com.bandtec.AgendaDeObjetivos.modelos.Usuario;
import br.com.bandtec.AgendaDeObjetivos.resources.TodosUsuarios;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class LoginControllerTest {
	private LoginController controller;
	private TodosUsuarios todosUsuarios ;

	@Before
	public void setUp() {
		todosUsuarios = Mockito.mock(TodosUsuarios.class);
		controller = new LoginController(todosUsuarios);
	}

	@Test
	public void loginComSucesso() {
		Credenciais c = new Credenciais("login","senha");
		Mockito.when(todosUsuarios.existe(c)).thenReturn(new Usuario(1, "123", "123"));
		ResponseEntity<String> resposta = controller.validarLogin(c);

		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		assertEquals("Sucesso", resposta.getBody());
	}

	@Test
	public void loginComFalha() {
        Credenciais c = new Credenciais("login","senha");
        Mockito.when(todosUsuarios.existe(c)).thenReturn(null);
		ResponseEntity<String> resposta = controller.validarLogin(c);

		assertEquals(HttpStatus.UNAUTHORIZED, resposta.getStatusCode());
		assertEquals("Erro", resposta.getBody());
	}


	
}
