package com.hb.gestiongarage.services;

import java.util.List;

import com.hb.gestiongarage.pojos.Vehicule;

public interface VehiculeService {

	void ajouterVehicule(Vehicule vehicule);
	
	Vehicule recupererVehicule(int id);
	
	List<Vehicule> recupererVehicules();
	
	boolean supprimerVehicule(int id);
}
