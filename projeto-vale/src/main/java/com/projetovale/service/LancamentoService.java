package com.projetovale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetovale.model.Lancamento;
import com.projetovale.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public List<Lancamento> listarTodos() {
		return lancamentoRepository.findAll();
	}

	public Optional<Lancamento> buscarPorId(Long id) {
		return lancamentoRepository.findById(id);
	}

	public Lancamento salvar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

	public Lancamento atualizar(Long id, Lancamento lancamentoAtualizado) {
		Optional<Lancamento> lancamentoExistente = lancamentoRepository.findById(id);

		if (lancamentoExistente.isPresent()) {
			Lancamento lancamento = lancamentoExistente.get();
			lancamento.setStatus(lancamentoAtualizado.getStatus());
			lancamento.setObservacao(lancamentoAtualizado.getObservacao());
			lancamento.setValor(lancamentoAtualizado.getValor());
			lancamento.setNumeroParcela(lancamentoAtualizado.getNumeroParcela());
			return lancamentoRepository.save(lancamento);
		}

		return null; // Ou pode lançar uma exceção personalizada
	}

	public void deletar(Long id) {
		lancamentoRepository.deleteById(id);
	}
}
