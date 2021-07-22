package com.hb.gestiongarage.services;

import java.util.List;

import com.hb.gestiongarage.pojos.Garage;

public interface GarageService {
	void ajouterGarage(Garage garage);
	
	Garage recupererGarage(int id);
	
	List<Garage> recupererGarages();
	
	boolean supprimerGarage(int id);
}
