package com.hb.gestiongarage.services;

import java.util.List;

import com.hb.gestiongarage.pojos.Option;

public interface OptionService {
	void ajouterOption(Option option);
	
	Option recupererOption(int id);
	
	List<Option> recupererOptions();
	
	boolean supprimerOption(int id);
}
