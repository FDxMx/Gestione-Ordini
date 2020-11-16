package it.gestioneordini.dao.articolo;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import it.gestioneordini.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO{
	
	private EntityManager entityManager;

	@Override
	public Set<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Articolo findById(int id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo input) throws Exception {
		input = entityManager.merge(input);
		
	}

	@Override
	public void insert(Articolo input) throws Exception {
		entityManager.persist(input);
		
	}

	@Override
	public void delete(Articolo input) throws Exception {
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
