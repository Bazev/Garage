package com.hb.gestiongarage.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.hb.gestiongarage.pojos.Vehicule;
import com.hb.gestiongarage.services.VehiculeService;

public class VehiculeServiceImpl implements VehiculeService {
	
	private List<Vehicule> vehicules = new ArrayList<Vehicule>();

	@Override
	public void ajouterVehicule(Vehicule vehicule) {
		vehicules.add(vehicule);
	}

	@Override
	public Vehicule recupererVehicule(int id) {
		for(Vehicule vehicule : vehicules) {
			if(id == vehicule.getId()) {
				return vehicule;
			}
		}
		
		return null;
	}

	@Override
	public List<Vehicule> recupererVehicules() {

		return vehicules;
	}

	@Override
	public boolean supprimerVehicule(int id) {
		for(Vehicule vehicule : vehicules) {
			if(id == vehicule.getId()) {
				
				vehicules.remove(vehicule);
				
				return true;
			}
		}
		
		return false;
	}
	
}
