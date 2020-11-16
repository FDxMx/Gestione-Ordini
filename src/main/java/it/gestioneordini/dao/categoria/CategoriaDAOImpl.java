package it.gestioneordini.dao.categoria;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public class CategoriaDAOImpl implements CategoriaDAO{
	
	private EntityManager entityManager;

	@Override
	public Set<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Categoria findById(int id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria input) throws Exception {
		input = entityManager.merge(input);
		
	}

	@Override
	public void insert(Categoria input) throws Exception {
		entityManager.persist(input);
		
	}

	@Override
	public void delete(Categoria input) throws Exception {
		entityManager.remove(entityManager.merge(input));
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void aggiungiArticoloACategoria(Categoria categoriaInput, Articolo articoloInput) {
		articoloInput.getCategorie().add(categoriaInput);
	}

}
