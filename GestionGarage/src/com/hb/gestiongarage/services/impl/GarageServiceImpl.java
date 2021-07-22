package com.hb.gestiongarage.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.hb.gestiongarage.pojos.Garage;
import com.hb.gestiongarage.services.GarageService;

public class GarageServiceImpl implements GarageService {

	private List<Garage> garages = new ArrayList<Garage>();

	@Override
	public void ajouterGarage(Garage garage) {
		garages.add(garage);		
	}

	@Override
	public Garage recupererGarage(int id) {
		for(Garage garage : garages) {
			if(id == garage.getId()) {
				return garage;
			}
		}
		
		return null;
	}

	@Override
	public List<Garage> recupererGarages() {

		return garages;
	}

	@Override
	public boolean supprimerGarage(int id) {
		for(Garage garage : garages) {
			if(id == garage.getId()) {
				
				garages.remove(garage);
				
				return true;
			}
		}
		
		return false;
	}
}
