package it.gestioneordini.service.ordine;

import java.util.List;

import it.gestioneordini.dao.ordine.OrdineDAO;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;
import it.gestioneordini.service.IBaseService;

public interface OrdineService extends IBaseService<Ordine>{
	
	public void setOrdineDAO(OrdineDAO ordineDAO);
	
	public List<Ordine> findAllOrdiniByCategoria(Categoria categoriaInput);
	
	public void aggiungiArticoloAOrdine(Ordine ordineInput, Articolo articoloInput);
}
