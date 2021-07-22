package com.hb.gestiongarage.pojos;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicule implements Comparable {
	
	public static int inc = 1;
	
	protected int id;
	protected String nom;
	protected double prix;
	protected Marque marque;
	protected Moteur moteur;
	protected List<Option> options = new ArrayList<Option>();
	
	public Vehicule() {

	}

	public Vehicule(String nom, double prix, Marque marque, Moteur moteur) {
		this.id = generateId();
		this.nom = nom;
		this.prix = prix;
		this.marque = marque;
		this.moteur = moteur;
	}

	public int generateId() {
		return inc++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Moteur getMoteur() {
		return moteur;
	}

	public void setMoteur(Moteur moteur) {
		this.moteur = moteur;
	}

	public List<Option> getOptions() {
		return options;
	}	
	
	public void ajouterOption(Option option) {
		options.add(option);
	}
	
	// méthode abstract qui sera implémentée dans les classes enfants
	protected abstract double calculerTaxe();
	
	public double calculerPrixTotal() {
		double prixTotal = 0;
		
		prixTotal = prix + calculerTaxe();
		
		for(Option option : options) {
			prixTotal += option.getPrix();
		}
		
		return prixTotal;
	}
	
	public void afficher() {
		System.out.println("id : " + id + ", nom : " + nom + ", prix : " + prix + ", marque : " + marque);
		moteur.afficher();
		System.out.println("Taxe : " + calculerTaxe());
		System.out.println("Prix total : " + calculerPrixTotal());
	}
	
	protected void afficherOptions() {
		
		if (options.size() > 0) {
			System.out.println("Options :");
		}
		
		for(Option option : options) {
			option.afficher();			
		}
	}
	
	@Override
	public int compareTo(Object o) {
		
		Vehicule vehicule = (Vehicule)o;
		
		if (this.calculerPrixTotal() > vehicule.calculerPrixTotal()) {
			return 1;
		}
		else if (this.calculerPrixTotal() < vehicule.calculerPrixTotal()) {
			return -1;
		}
		
		return 0;
	}
}
