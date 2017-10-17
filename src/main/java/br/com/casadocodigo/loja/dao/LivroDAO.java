package br.com.casadocodigo.loja.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.models.Livro;

@Repository
public class LivroDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Livro save(Livro livro) {
		 em.persist(livro);
		 return livro;
	}
	
	public List<Livro> listar() {
		List<Livro> retorno = new ArrayList<Livro>();
		
		retorno = em.createQuery(" select distinct l from Livro l join fetch l.precos ", Livro.class).getResultList();
		
		return retorno;
		
	}
	
	public Livro obter(Long id) {
		Livro livro = new Livro();
		livro = em.createQuery(" select distinct l from Livro l join fetch l.precos where l.id = :id ", 
				Livro.class).setParameter("id", id)
				.getSingleResult();
		return livro;
	}
	
}
