package com.hb.gestiongarage.pojos;

public class Option {
	
	public static int inc = 1;
	
	private int id;
	private String nom;
	private double prix;
	
	public Option() {

	}

	public Option(String nom, double prix) {
		this.id = generateId();
		this.nom = nom;
		this.prix = prix;
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

	public void afficher() {
		System.out.println("Option id : " + id + ", nom : " + nom + ", prix : " + prix);
	}
	
}
