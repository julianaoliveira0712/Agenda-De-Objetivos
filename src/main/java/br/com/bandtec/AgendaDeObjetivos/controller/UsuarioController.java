package br.com.bandtec.AgendaDeObjetivos.controller;

import br.com.bandtec.AgendaDeObjetivos.modelos.Usuario;
import br.com.bandtec.AgendaDeObjetivos.resources.TodosUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    public class UsuarioController {

        private TodosUsuarios todosUsuarios;


        @Autowired
        public UsuarioController(TodosUsuarios listaUsuarios) {
            this.todosUsuarios = listaUsuarios;
        }

        @GetMapping("/usuarios/nome/{nomeDoUsuario}")
        public ResponseEntity<List<Usuario>> obterPorNome(@PathVariable("nomeDoUsuario") String nomeProcurado){
            List<Usuario> usuarios = todosUsuarios.porNome(nomeProcurado);
            if(usuarios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return  ResponseEntity.ok(usuarios);

        }

        @GetMapping("/usuarios/idade/{idadeDoUsuario}")
        public ResponseEntity<List<Usuario>> obterPorIdade(@PathVariable("idadeDoUsuario") Integer idadeProcurada){
            List<Usuario> usuarios = todosUsuarios.porIdade(idadeProcurada);
            if(usuarios.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return  ResponseEntity.ok(usuarios);

        }

        @PostMapping("/usuarios")
        public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario novoUsuario){
            todosUsuarios.save(novoUsuario);
            return ResponseEntity.ok(novoUsuario);
        }

    }

