package it.gestioneordini.dao;

import java.util.Set;

import javax.persistence.EntityManager;

public interface IBaseDAO<T> {

	public Set<T> list() throws Exception;

	public T findById(int id) throws Exception;

	public void update(T o) throws Exception;

	public void insert(T o) throws Exception;

	public void delete(T o) throws Exception;

	public void setEntityManager(EntityManager entityManager);

}
