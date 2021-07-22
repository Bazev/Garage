package com.hb.gestiongarage.services;

import java.util.List;

import com.hb.gestiongarage.pojos.Moteur;

public interface MoteurService {
	
	void ajouterMoteur(Moteur moteur);
	
	Moteur recupererMoteur(int id);
	
	List<Moteur> recupererMoteurs();
	
	boolean supprimerMoteur(int id);

}
