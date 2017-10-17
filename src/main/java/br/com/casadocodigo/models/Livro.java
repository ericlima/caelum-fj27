package br.com.casadocodigo.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Livro {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String titulo;
	
	@Lob
	@NotBlank
	private String descricao;
	
	@Min(value=2) @Max(value=1000)
	private Integer paginas;
	
	@ElementCollection
    private List<Preco> precos;
    
	private Calendar dataLancamento;
	
	@Lob
	private byte[] arquivoSumario;
	
	private String caminhoSumario;
	
	public BigDecimal precoPara(TipoLivro tipo) {
		return precos
				.stream()
				.filter(preco -> preco.getTipo().equals(tipo))
				.findFirst().get().getValor();
	}
	
	
	public List<Preco> getPrecos() {
		return precos;
	}
	
	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getPaginas() {
		return paginas;
	}
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getCaminhoSumario() {
		return caminhoSumario;
	}

	public void setCaminhoSumario(String caminhoSumario) {
		this.caminhoSumario = caminhoSumario;
	}

	public byte[] getArquivoSumario() {
		return arquivoSumario;
	}

	public void setArquivoSumario(byte[] arquivoSumario) {
		this.arquivoSumario = arquivoSumario;
	}

	
	
}
