package it.gestioneordini.service.articolo;

import java.util.Set;

import javax.persistence.EntityManager;

import it.gestioneordini.dao.articolo.ArticoloDAO;
import it.gestioneordini.entitymanager.EntityManagerUtil;
import it.gestioneordini.model.Articolo;

public class ArticoloServiceImpl implements ArticoloService {

	private ArticoloDAO articoloDAO;

	@Override
	public Set<Articolo> list() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		articoloDAO.setEntityManager(entityManager);
		return articoloDAO.list();
	}

	@Override
	public Articolo findById(int id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		articoloDAO.setEntityManager(entityManager);
		return articoloDAO.findById(id);
	}

	@Override
	public void update(Articolo input) throws Exception {
		if (input.getOrdine() == null) {
			EntityManager entityManager = EntityManagerUtil.getEntityManager();
			try {
				entityManager.getTransaction().begin();
				articoloDAO.setEntityManager(entityManager);
				articoloDAO.update(input);
				entityManager.getTransaction().commit();
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
				throw e;
			}
			return;
		}
		System.out.println("Questo articolo è presente in un ordine");

	}

	@Override
	public void insert(Articolo input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			articoloDAO.setEntityManager(entityManager);
			articoloDAO.insert(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(Articolo input) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			articoloDAO.setEntityManager(entityManager);
			articoloDAO.delete(input);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
	}

}
