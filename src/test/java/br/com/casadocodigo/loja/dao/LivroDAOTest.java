package br.com.casadocodigo.loja.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.conf.JpaConfig;
import br.com.casadocodigo.models.Livro;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {LivroDAO.class, JpaConfig.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class LivroDAOTest {
	
	@Autowired
	private LivroDAO livroDAO;

	@Test
	public void test() {

		Livro livro = new Livro();
		
		livro.setTitulo("Novo livro");
		
		livroDAO.save(livro);
		
		Assert.assertEquals(1, livroDAO.listar().size());
		
	}

}
