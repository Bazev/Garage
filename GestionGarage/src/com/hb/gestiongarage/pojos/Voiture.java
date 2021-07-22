package com.hb.gestiongarage.pojos;

public class Voiture extends Vehicule {
	
	private int chevaux;
	private int nbPorte;
	private int nbSiege;
	private int tailleCoffre;
	
	public Voiture() {
		super();
	}

	public Voiture(String nom, double prix, Marque marque, Moteur moteur,
			int chevaux, int nbPorte, int nbSiege, int tailleCoffre) {
		super(nom, prix, marque, moteur);

		this.chevaux = chevaux;
		this.nbPorte = nbPorte;
		this.nbSiege = nbSiege;
		this.tailleCoffre = tailleCoffre;
	}
	
	public int getChevaux() {
		return chevaux;
	}

	public void setChevaux(int chevaux) {
		this.chevaux = chevaux;
	}

	public int getNbPorte() {
		return nbPorte;
	}

	public void setNbPorte(int nbPorte) {
		this.nbPorte = nbPorte;
	}

	public int getNbSiege() {
		return nbSiege;
	}

	public void setNbSiege(int nbSiege) {
		this.nbSiege = nbSiege;
	}

	public int getTailleCoffre() {
		return tailleCoffre;
	}

	public void setTailleCoffre(int tailleCoffre) {
		this.tailleCoffre = tailleCoffre;
	}
	
	@Override
	public void afficher() {
		System.out.println("Voiture :");
		super.afficher();
		System.out.println("chevaux : " + chevaux + ", nombre de porte : " + nbPorte + 
				", nombre de siege : " + nbSiege + ", taille de coffre : " + tailleCoffre);
		
		afficherOptions();
	}

	@Override
	protected double calculerTaxe() {
		
		return chevaux * 10;
	}

}
