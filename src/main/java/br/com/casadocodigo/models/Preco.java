package br.com.casadocodigo.models;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Preco {

	@Enumerated(EnumType.STRING)
	private TipoLivro tipo;
	
	private BigDecimal valor;
	
	private Calendar dataAlteracao;
	
	public TipoLivro getTipo() {
		return tipo;
	}
	public void setTipo(TipoLivro tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
}
