package com.projetovale.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetovale.model.Lancamento;
import com.projetovale.service.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	// ✅ Listar todos os lançamentos
	@GetMapping
	public List<Lancamento> listarTodos() {
		return lancamentoService.listarTodos();
	}

	// ✅ Buscar lançamento por ID
	@GetMapping("/{id}")
	public Optional<Lancamento> buscarPorId(@PathVariable Long id) {
		return lancamentoService.buscarPorId(id);
	}

	// ✅ Criar novo lançamento
	@PostMapping
	public Lancamento salvar(@RequestBody Lancamento lancamento) {
		return lancamentoService.salvar(lancamento);
	}

	// ✅ Atualizar um lançamento existente
	@PutMapping("/{id}")
	public Lancamento atualizar(@PathVariable Long id, @RequestBody Lancamento lancamentoAtualizado) {
		return lancamentoService.atualizar(id, lancamentoAtualizado);
	}

	// ✅ Deletar lançamento por ID
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		lancamentoService.deletar(id);
	}
}
