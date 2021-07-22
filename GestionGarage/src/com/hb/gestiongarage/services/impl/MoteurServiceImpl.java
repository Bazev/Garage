package com.hb.gestiongarage.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.hb.gestiongarage.pojos.Moteur;
import com.hb.gestiongarage.services.MoteurService;

public class MoteurServiceImpl implements MoteurService {
	
	private List<Moteur> moteurs = new ArrayList<Moteur>();

	@Override
	public void ajouterMoteur(Moteur moteur) {
		moteurs.add(moteur);		
	}

	@Override
	public Moteur recupererMoteur(int id) {
		for(Moteur moteur : moteurs) {
			if(id == moteur.getId()) {
				return moteur;
			}
		}
		
		return null;
	}

	@Override
	public List<Moteur> recupererMoteurs() {

		return moteurs;
	}

	@Override
	public boolean supprimerMoteur(int id) {
		for(Moteur moteur : moteurs) {
			if(id == moteur.getId()) {
				
				moteurs.remove(moteur);
				
				return true;
			}
		}
		
		return false;
	}

}
