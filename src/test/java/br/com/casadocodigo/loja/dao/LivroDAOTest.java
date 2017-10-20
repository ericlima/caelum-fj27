package br.com.casadocodigo.loja.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.casadocodigo.models.Livro;

public class LivroDAOTest {
	
	@Autowired
	private LivroDAO livroDAO;

	@Test
	public void test() {
		fail("Not yet implemented");
		Livro livro = new Livro();
		
		livro.setTitulo("Novo livro");
		
		livroDAO.save(livro);
		
		Assert.assertArrayEquals(1, actuals);
	}

}
