package com.projetovale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetovale.model.Usuario;
import com.projetovale.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// ✅ Método para salvar um novo usuário
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	// ✅ Listar todos os usuários
	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	// ✅ Buscar usuário por ID
	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	// ✅ Atualizar usuário
	public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
		Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
		if (usuarioExistente.isPresent()) {
			Usuario usuario = usuarioExistente.get();
			usuario.setNome(usuarioAtualizado.getNome());
			usuario.setSenha(usuarioAtualizado.getSenha());
			return usuarioRepository.save(usuario);
		} else {
			throw new RuntimeException("Usuário não encontrado com ID: " + id);
		}

	}

	// ✅ Deletar usuário
	public void excluir(Long id) {
		usuarioRepository.deleteById(id);
	}
}
