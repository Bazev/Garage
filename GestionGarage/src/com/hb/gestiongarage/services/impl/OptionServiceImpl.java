package com.hb.gestiongarage.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.hb.gestiongarage.pojos.Option;
import com.hb.gestiongarage.services.OptionService;

public class OptionServiceImpl implements OptionService {

		private List<Option> options = new ArrayList<Option>();

		@Override
		public void ajouterOption(Option option) {
			options.add(option);			
		}

		@Override
		public Option recupererOption(int id) {
			for(Option option : options) {
				if(id == option.getId()) {
					return option;
				}
			}
			
			return null;
		}

		@Override
		public List<Option> recupererOptions() {

			return options;
		}

		@Override
		public boolean supprimerOption(int id) {
			for(Option option : options) {
				if(id == option.getId()) {
					
					options.remove(option);
					
					return true;
				}
			}
			
			return false;
		}
}
