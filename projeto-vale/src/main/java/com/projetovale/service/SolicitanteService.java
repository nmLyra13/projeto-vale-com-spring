package com.projetovale.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetovale.model.Solicitante;
import com.projetovale.repository.SolicitanteRepository;

@Service
public class SolicitanteService {

	@Autowired
	private SolicitanteRepository solicitanteRepository;

	public List<Solicitante> listarTodos() {
		return solicitanteRepository.findAll();
	}

	public Optional<Solicitante> buscarPorId(Long id) {
		return solicitanteRepository.findById(id);
	}

	public Solicitante salvar(Solicitante solicitante) {
		return solicitanteRepository.save(solicitante);
	}

	public void deletar(Long id) {
		solicitanteRepository.deleteById(id);
	}
}
