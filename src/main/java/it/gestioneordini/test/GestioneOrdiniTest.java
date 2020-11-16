package it.gestioneordini.test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import it.gestioneordini.entitymanager.EntityManagerUtil;
import it.gestioneordini.model.Articolo;
import it.gestioneordini.model.Categoria;
import it.gestioneordini.model.Ordine;
import it.gestioneordini.service.MyServiceFactory;
import it.gestioneordini.service.articolo.ArticoloService;
import it.gestioneordini.service.categoria.CategoriaService;
import it.gestioneordini.service.ordine.OrdineService;

public class GestioneOrdiniTest {
	
	public static void main(String[] args) {
		
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		
		try {
			
//			INSERT ARTICOLO
//			Articolo articolo = new Articolo("ricondizionato", 22);
//			articoloServiceInstance.insert(articolo);
			
//			INSERT CATEGORIA
//			Categoria categoria = new Categoria("elettronica");
//			categoriaServiceInstance.insert(categoria);
			
//			SETTO UN ARTICOLO AD UNA CATEGORIA
//			Articolo art = articoloServiceInstance.findById(2);
//			Categoria cat = categoriaServiceInstance.findById(2);
//			categoriaServiceInstance.aggiungiArticoloACategoria(cat, art);
			
//			ELEMINA ARTICOLO
//			Articolo art = articoloServiceInstance.findById(2);
//			articoloServiceInstance.delete(art);
			
//			ELIMINA CATEGORIA
//			Categoria cat = categoriaServiceInstance.findById(3);
//			categoriaServiceInstance.delete(cat);
			
//			AGGIORNA ARTICOLO
//			Articolo art = articoloServiceInstance.findById(2);
//			art.setDescrizione("usato");
//			articoloServiceInstance.update(art);
			
//			AGGIORNA CATEGORIA
//			Categoria cat = categoriaServiceInstance.findById(2);
//			cat.setDescrizione("informatica");
//			categoriaServiceInstance.update(cat);
			
//			INSERT ORDINE
//			Set<Articolo> articoli = new HashSet<>();
//			Ordine ordine = new Ordine("via roma", "Luca");
//			Articolo art = articoloServiceInstance.findById(1);
//			ordine.getArticoli().add(art);
//			ordineServiceInstance.insert(ordine);
//			ordineServiceInstance.aggiungiArticoloAOrdine(ordine, art);
			
//			UPDATE ORDINE
//			Ordine ordine = new Ordine("via mosca 52", "Pippo Rossi");
//			ordine.setId(1);
//			ordineServiceInstance.update(ordine);
			
//			AGGIUNGI ARTICOLO A ORDINE
//			Articolo art = articoloServiceInstance.findById(2);
//			Ordine ord = ordineServiceInstance.findById(1);
//			ordineServiceInstance.aggiungiArticoloAOrdine(ord, art);
			
//			LISTA ARTICOLI
//			for (Articolo art : articoloServiceInstance.list()) {
//				System.out.println(art);
//			}
			
//			DAMMI ORDINI DA CATEGORIA (non funziona)
//			Categoria cat = categoriaServiceInstance.findById(1);
//			for (Ordine ord : ordineServiceInstance.findAllOrdiniByCategoria(cat)) {
//				System.out.println(ord);
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}
		
}
