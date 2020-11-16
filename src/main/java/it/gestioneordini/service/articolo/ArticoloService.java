package it.gestioneordini.service.articolo;

import it.gestioneordini.dao.articolo.ArticoloDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.service.IBaseService;

public interface ArticoloService extends IBaseService<Articolo>{
	
	public void setArticoloDAO(ArticoloDAO articoloDAO);

}
