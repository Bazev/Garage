package com.hb.gestiongarage.pojos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Garage {

	public static int inc = 1;
	
	private int id;
	private String nom;
	private List<Vehicule> vehicules = new ArrayList<Vehicule>();
	
	public Garage() {
		
	}
	
	public Garage(String nom) {
		this.id = generateId();
		this.nom = nom;
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
	
	public void afficher() {
		
		System.out.println("Garage id : " + id + ", nom : " + nom);
		System.out.println("Véhicules : ");
		for (Vehicule vehicule : vehicules) {
			vehicule.afficher();
		}		
	}
	
	public void ajouterVehicule(Vehicule vehicule) {
		vehicules.add(vehicule);
	}
	
	public void trierVehicule() {
		Collections.sort(vehicules);
	}

}
