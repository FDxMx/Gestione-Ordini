package it.gestioneordini.service;

import java.util.Set;

public interface IBaseService<E> {
	
	public Set<E> list() throws Exception;

	public E findById(int id) throws Exception;

	public void update(E o) throws Exception;

	public void insert(E o) throws Exception;

	public void delete(E o) throws Exception;

}
