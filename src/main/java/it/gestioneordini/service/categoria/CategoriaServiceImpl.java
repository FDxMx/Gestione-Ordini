package it.gestioneordini.service.categoria;

import java.util.Set;

import javax.persistence.EntityManager;

import it.gestioneordini.dao.categoria.CategoriaDAO;
import it.gestioneordini.entitymanager.EntityManagerUtil;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDAO categoriaDAO;

	@Override
	public Set<Categoria> list() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		categoriaDAO.setEntityManager(entityManager);
		return categoriaDAO.list();
	}

	@Override
	public Categoria findById(int id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		categoriaDAO.setEntityManager(entityManager);
		return categoriaDAO.findById(id);
	}

	@Override
	public void update(Categoria input) throws Exception {
		if (!list().contains(input)) {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			try {
				entityManager.getTransaction().begin();
				categoriaDAO.setEntityManager(entityManager);
				categoriaDAO.update(input);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
				throw e;
			}
			return;
		}
		System.out.println("Questa categoria è già esistente");

	}

	@Override
	public void insert(Categoria input) throws Exception {
		if (!list().contains(input)) {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			try {
				entityManager.getTransaction().begin();
				categoriaDAO.setEntityManager(entityManager);
				categoriaDAO.insert(input);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
				throw e;
			}
			return;
		}
		System.out.println("Questa categoria è già esistente");

	}

	@Override
	public void delete(Categoria input) throws Exception {
		if (input.getArticoli().size() < 1) {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			try {
				entityManager.getTransaction().begin();
				categoriaDAO.setEntityManager(entityManager);
				categoriaDAO.delete(input);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
				throw e;
			}
			return;
		}
		System.out.println("Questa categoria è popolata da articoli");
	}

	@Override
	public void aggiungiArticoloACategoria(Categoria categoriaInput, Articolo articoloInput) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			categoriaDAO.setEntityManager(entityManager);
			categoriaInput = entityManager.merge(categoriaInput);
			articoloInput = entityManager.merge(articoloInput);
			categoriaDAO.aggiungiArticoloACategoria(categoriaInput, articoloInput);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

}
