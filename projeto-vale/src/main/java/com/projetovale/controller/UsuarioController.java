package com.projetovale.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetovale.model.Usuario;
import com.projetovale.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	// ✅ Criar um novo usuário (POST)
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = usuarioService.salvar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}

	// ✅ Listar todos os usuários (GET)
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> usuarios = usuarioService.listarTodos();
		return ResponseEntity.ok(usuarios);
	}

	// Atualizar usuário (PUT)
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioAtualizado = usuarioService.atualizar(id, usuario);
		return ResponseEntity.ok(usuarioAtualizado);
	}
}
