package it.gestioneordini.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")
public class Articolo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "prezzo")
	private int prezzo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordine_fk")
	private Ordine ordine;
	@ManyToMany
	@JoinTable(name = "categoria_articolo", joinColumns = @JoinColumn(name = "categoria_fk", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "articolo_fk", referencedColumnName = "id"))
	private Set<Categoria> categorie = new HashSet<>();
	
	public Articolo () {}

	public Articolo(String descrizione, int prezzo) {
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", ordine=" + ordine
				+ "]";
	}
	
}
