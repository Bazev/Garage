package com.hb.gestiongarage.pojos;

public class Moto extends Vehicule {

	private int cylindree;
	
	public Moto() {
		super();
	}

	public Moto(String nom, double prix, Marque marque, Moteur moteur, int cylindree) {
		super(nom, prix, marque, moteur);

		this.cylindree = cylindree;
	}
		
	public int getCylindree() {
		return cylindree;
	}

	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}

	@Override
	public void afficher() {
		System.out.println("Moto :");
		super.afficher();
		System.out.println("cylindree : " + cylindree);
		
		afficherOptions();
	}

	@Override
	protected double calculerTaxe() {
		
		return (int)((double)cylindree * 0.3);
	}
}
