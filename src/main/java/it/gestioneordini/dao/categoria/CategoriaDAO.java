package it.gestioneordini.dao.categoria;

import it.gestioneordini.dao.IBaseDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria>{
	
	public void aggiungiArticoloACategoria(Categoria categoriaInput, Articolo articoloInput);

}
