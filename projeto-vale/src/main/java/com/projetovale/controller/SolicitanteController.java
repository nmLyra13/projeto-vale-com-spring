package com.projetovale.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetovale.model.Solicitante;
import com.projetovale.service.SolicitanteService;

@RestController
@RequestMapping("/solicitantes")
public class SolicitanteController {

	@Autowired
	private SolicitanteService solicitanteService;

	// ✅ Listar todos os solicitantes
	@GetMapping
	public List<Solicitante> listarTodos() {
		return solicitanteService.listarTodos();
	}

	// ✅ Buscar solicitante por ID
	@GetMapping("/{id}")
	public Optional<Solicitante> buscarPorId(@PathVariable Long id) {
		return solicitanteService.buscarPorId(id);
	}

	// ✅ Criar novo solicitante
	@PostMapping
	public Solicitante salvar(@RequestBody Solicitante solicitante) {
		return solicitanteService.salvar(solicitante);
	}

	// ✅ Deletar solicitante por ID
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		solicitanteService.deletar(id);
	}
}
