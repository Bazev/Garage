package com.hb.gestiongarage.exceptions;

public class GarageNonTrouveException extends RuntimeException {

	public GarageNonTrouveException() {
		super();
	}

	public GarageNonTrouveException(String s) {
		super(s);
	}
	
	public GarageNonTrouveException(int id) {
		super("Le garage l'id " + id + " n'existe pas");
	}
}
