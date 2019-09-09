package br.com.bandtec.AgendaDeObjetivos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuariosController {

	private List<Usuario> usuarios;
	
	public UsuariosController() {
		this.usuarios = obterTodosUsuarios();
	}
	
	@GetMapping("/usuarios/nome/{nomeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nomeProcurado){
		
		List<Usuario> usuariosPorNome = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			if (usuario.getNome().equals(nomeProcurado)) {
				usuariosPorNome.add(usuario);
			}
		}
		
		if (usuariosPorNome.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuariosPorNome);
	}
	
	@GetMapping("/usuarios/idade/{idadeDoUsuario}")
	public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idadeProcurada){
		
		List<Usuario> usuariosPorIdade = new ArrayList<>();
		
		for (Usuario usuario : usuarios) {
			if (usuario.getIdade() == idadeProcurada) {
				usuariosPorIdade.add(usuario);
			}
		}
		
		if (usuariosPorIdade.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(usuariosPorIdade);
	}

	private List<Usuario> obterTodosUsuarios(){
		ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
		Usuarios.add(new Usuario("Rodrigo", 30));
		Usuarios.add(new Usuario("Rodrigo", 30));
		Usuarios.add(new Usuario("Michele", 18));
		return Usuarios;
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastrarUsuario(
			@RequestBody Usuario usuario){
		
		this.usuarios.add(usuario);
		return ResponseEntity.ok(usuario);
		
	}
	

	@GetMapping("/todosusuarios")
	public ResponseEntity<List <Usuario>> retornarTodosUsuarios() 
	{
		return ResponseEntity.ok(usuarios);
	}
		/*return Arrays.asList(
					new Usuario("tiago", 36),
					new Usuario("tiago", 30),
					new Usuario("pedro", 18),
					new Usuario("maria", 18)
				);*/
	
	
}
