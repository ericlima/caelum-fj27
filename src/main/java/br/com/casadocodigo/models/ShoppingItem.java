package br.com.casadocodigo.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class ShoppingItem implements Serializable {

	private Livro product;
	private TipoLivro bookType;
	private Long productId;
	
	public ShoppingItem(Livro product, TipoLivro bookType) {
		this.product = product;
		this.bookType = bookType;
		this.productId = product.getId();
	}
	
	public Livro getProduct() {
		return product;
	}
	
	public TipoLivro getBookType() {
		return bookType;
	}
	
	public BigDecimal getPrice() {
		return product.precoPara(bookType);
	}
	
	public BigDecimal getTotal(Integer quantity) {
		return getPrice().multiply(new BigDecimal(quantity));
	}


}