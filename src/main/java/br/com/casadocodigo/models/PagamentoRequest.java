package br.com.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class PagamentoRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private BigDecimal value;
	
	public PagamentoRequest(BigDecimal value) {
		this.value= value;
	}

	public BigDecimal getValue() {
		return value;
	}

}
