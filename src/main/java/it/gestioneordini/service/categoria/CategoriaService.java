package it.gestioneordini.service.categoria;

import it.gestioneordini.dao.categoria.CategoriaDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.service.IBaseService;

public interface CategoriaService extends IBaseService<Categoria>{
	
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	public void aggiungiArticoloACategoria(Categoria categoriaInput, Articolo articoloInput);

}
