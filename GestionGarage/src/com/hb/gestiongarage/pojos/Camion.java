package com.hb.gestiongarage.pojos;

public class Camion extends Vehicule {
	private int nbEssieux;
	private int poidsChargement;
	private int volumeChargement;
	
	public Camion() {
		super();
	}

	public Camion(String nom, double prix, Marque marque, Moteur moteur,
			int nbEssieux, int poidsChargement, int volumeChargement) {
		super(nom, prix, marque, moteur);

		this.nbEssieux = nbEssieux;
		this.poidsChargement = poidsChargement;
		this.volumeChargement = volumeChargement;
	}
		
	public int getNbEssieux() {
		return nbEssieux;
	}

	public void setNbEssieux(int nbEssieux) {
		this.nbEssieux = nbEssieux;
	}

	public int getPoidsChargement() {
		return poidsChargement;
	}

	public void setPoidsChargement(int poidsChargement) {
		this.poidsChargement = poidsChargement;
	}

	public int getVolumeChargement() {
		return volumeChargement;
	}

	public void setVolumeChargement(int volumeChargement) {
		this.volumeChargement = volumeChargement;
	}

	@Override
	public void afficher() {
		System.out.println("Camion :");
		super.afficher();
		System.out.println("nombre d'essieux : " + nbEssieux + ", poids de chargement : " + poidsChargement + 
				", volume de chargement : " + volumeChargement);
		
		afficherOptions();
	}

	@Override
	protected double calculerTaxe() {

		return nbEssieux * 50;
	}
}
