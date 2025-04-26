package com.projetovale.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lancamentos")
public class Lancamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate dataLancamento;

	@Column(nullable = false)
	private LocalDate dataVencimento;

	@Column(nullable = false)
	private String detalhe = "VALE";

	@Column(nullable = false)
	private String status = "PENDENTE";

	private String observacao;

	@Column(nullable = false)
	private BigDecimal valor;

	@Column(nullable = false)
	private int numeroParcela;

	@ManyToOne
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Solicitante solicitante;

	// 🔹 Adicione os métodos getters e setters aqui:
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
}
