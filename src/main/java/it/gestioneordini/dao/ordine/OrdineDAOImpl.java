package it.gestioneordini.dao.ordine;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO{
	
	private EntityManager entityManager;

	@Override
	public Set<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList().stream().collect(Collectors.toSet());
	}

	@Override
	public Ordine findById(int id) throws Exception {
		return entityManager.find(Ordine.class, id);

	}

	@Override
	public void update(Ordine input) throws Exception {
		input = entityManager.merge(input);
		
	}

	@Override
	public void insert(Ordine input) throws Exception {
		entityManager.persist(input);
		
	}

	@Override
	public void delete(Ordine input) throws Exception {
		entityManager.remove(entityManager.merge(input));		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Ordine> findAllOrdiniByCategoria(Categoria categoriaInput) {
		TypedQuery<Ordine> query = entityManager.createQuery("select distinct o from Ordine o join o.articoli a join a.categorie c where c.id = ?1", Ordine.class);
		return query.setParameter(1, categoriaInput.getId()).getResultList();
	}

}
