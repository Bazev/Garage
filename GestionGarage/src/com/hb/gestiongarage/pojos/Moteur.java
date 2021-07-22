package com.hb.gestiongarage.pojos;

public class Moteur {
	
	public static int inc = 1;
	
	private int id;
	private int puissance;
	private TypeMoteur typeMoteur;
	
	public Moteur() {
	}

	public Moteur(int puissance, TypeMoteur typeMoteur) {
		this.id = generateId();
		this.puissance = puissance;
		this.typeMoteur = typeMoteur;
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

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public TypeMoteur getTypeMoteur() {
		return typeMoteur;
	}

	public void setTypeMoteur(TypeMoteur typeMoteur) {
		this.typeMoteur = typeMoteur;
	}
	
	public void afficher() {
		System.out.println("Moteur id : " + id + ", puissance : " + puissance + ", type : " + typeMoteur);
	}
}
