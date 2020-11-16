package it.gestioneordini.service.ordine;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import it.gestioneordini.dao.ordine.OrdineDAO;
import it.gestioneordini.entitymanager.EntityManagerUtil;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;

public class OrdineServiceImpl implements OrdineService {

	private OrdineDAO ordineDAO;

	@Override
	public Set<Ordine> list() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		ordineDAO.setEntityManager(entityManager);
		return ordineDAO.list();
	}

	@Override
	public Ordine findById(int id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		ordineDAO.setEntityManager(entityManager);
		return ordineDAO.findById(id);
	}

	@Override
	public void update(Ordine input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			ordineDAO.setEntityManager(entityManager);
			ordineDAO.update(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void insert(Ordine input) throws Exception {
		if (input.getArticoli().size() > 0) {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			try {
				entityManager.getTransaction().begin();
				ordineDAO.setEntityManager(entityManager);
				ordineDAO.insert(input);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
				throw e;
			}
			return;
		}
		System.out.println("Non puoi effettuare un ordine senza articoli");

	}

	@Override
	public void delete(Ordine input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			ordineDAO.setEntityManager(entityManager);
			ordineDAO.delete(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;

	}

	@Override
	public void aggiungiArticoloAOrdine(Ordine ordineInput, Articolo articoloInput) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			ordineDAO.setEntityManager(entityManager);
			ordineInput = entityManager.merge(ordineInput);
			articoloInput = entityManager.merge(articoloInput);
			articoloInput.setOrdine(ordineInput);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Ordine> findAllOrdiniByCategoria(Categoria categoriaInput) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		ordineDAO.setEntityManager(entityManager);
		categoriaInput = entityManager.merge(categoriaInput);
		return ordineDAO.findAllOrdiniByCategoria(categoriaInput);
	}

}
