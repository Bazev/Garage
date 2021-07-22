package com.hb.gestiongarage;

import java.util.List;
import java.util.Scanner;

import com.hb.gestiongarage.exceptions.GarageNonTrouveException;
import com.hb.gestiongarage.pojos.Camion;
import com.hb.gestiongarage.pojos.Garage;
import com.hb.gestiongarage.pojos.Marque;
import com.hb.gestiongarage.pojos.Moteur;
import com.hb.gestiongarage.pojos.Moto;
import com.hb.gestiongarage.pojos.Option;
import com.hb.gestiongarage.pojos.TypeMoteur;
import com.hb.gestiongarage.pojos.Vehicule;
import com.hb.gestiongarage.pojos.Voiture;
import com.hb.gestiongarage.services.GarageService;
import com.hb.gestiongarage.services.MoteurService;
import com.hb.gestiongarage.services.OptionService;
import com.hb.gestiongarage.services.VehiculeService;
import com.hb.gestiongarage.services.impl.GarageServiceImpl;
import com.hb.gestiongarage.services.impl.MoteurServiceImpl;
import com.hb.gestiongarage.services.impl.OptionServiceImpl;
import com.hb.gestiongarage.services.impl.VehiculeServiceImpl;

public class GestionGarageMain {
	
	private static Scanner scanner = new Scanner(System.in);
	private static GarageService garageService = new GarageServiceImpl();
	private static MoteurService moteurService = new MoteurServiceImpl();
	private static OptionService optionService = new OptionServiceImpl();
	private static VehiculeService vehiculeService = new VehiculeServiceImpl();
	private static Garage garageSelectionne;
	
	public static void main(String[] args) {
		
		// créé un garage
		Garage garageBotte = new Garage("Garage des bottes");
		
		// ajoute le garage au service
		garageService.ajouterGarage(garageBotte);
		
		// créé des moteurs
		Moteur moteur110e = new Moteur(110, TypeMoteur.ESSENCE);
		Moteur moteur85e = new Moteur(85, TypeMoteur.ESSENCE);
		Moteur moteur300d = new Moteur(300, TypeMoteur.DESIEL);
		Moteur moteur140i = new Moteur(140, TypeMoteur.ELECTRIQUE);
		
		// ajoute les moteurs dans le service
		moteurService.ajouterMoteur(moteur110e);
		moteurService.ajouterMoteur(moteur85e);
		moteurService.ajouterMoteur(moteur300d);
		
		// créé des options
		Option gps = new Option("GPS", 800);
		Option toitOuvrant = new Option("Toit ouvrant", 500);
		
		// ajoute les options dans le service
		optionService.ajouterOption(gps);
		optionService.ajouterOption(toitOuvrant);
		
		// créé des véhicules
		Voiture clio = new Voiture("Clio", 19000, Marque.RENAULT, moteur110e, 6, 5, 4, 300);
		Moto thunderbird = new Moto("Thunderbird", 12000, Marque.TRIUMPH, moteur85e, 900);
		Camion tHight = new Camion("T HIGH", 40000, Marque.RENAULT, moteur300d, 3, 10000, 200);
		
		// ajoute les véhicules dans le service
		vehiculeService.ajouterVehicule(clio);
		vehiculeService.ajouterVehicule(thunderbird);
		vehiculeService.ajouterVehicule(tHight);
		
		/*clio.ajouterOption(gps);
		
		garage.ajouterVehicule(clio);
		garage.ajouterVehicule(thunderbird);
		garage.ajouterVehicule(tHight);
		
		garage.afficher();
		
		// test le tri
		garage.trierVehicule();
		garage.afficher();
		*/
		
		int choix = 0;

		while (choix != 9) {
			afficherMenuPrincipal();
			
			try {
				choix = choixMenuPrincipal();
			}
			catch(NumberFormatException e) {
				System.out.println("Merci de saisir un nombre");
			}
			catch (GarageNonTrouveException e) {
				System.out.println(e.getMessage());
			}
		}
		
		scanner.close();
	}
	
	public static void afficherMenuPrincipal() {
		System.out.println("Menu Principal");
		System.out.println("1.  Voir les garages");
		System.out.println("2.  Gérer un garage");
		System.out.println("3.  Ajouter une voiture");
		System.out.println("4.  Voir les vehicules");
		System.out.println("5.  Ajouter un moteur");
		System.out.println("6.  Voir les moteurs");
		System.out.println("7.  Ajouter une option");
		System.out.println("8.  Voir les options");
		System.out.println("9.  Quitter");
	}
	
	public static int choixMenuPrincipal() {
		System.out.println("Veuillez saisir votre choix : ");
		int choix = Integer.parseInt(scanner.nextLine());

		switch (choix) {
		case 1:
			afficherGarages();
			break;
		case 2:
			gererGarage();
			break;
		case 3:
			ajouterVoiture();
			break;
		case 4:
			afficherVehicules();
			break;
		case 5:
			ajouterMoteur();
			break;
		case 6:
			afficherMoteurs();
			break;
		case 7:
			ajouterOption();
			break;
		case 8:
			afficherOptions();
			break;
		default:
			break;
		}				

		return choix;
	}
	
	public static void afficherMenuGestionGarage() {
		System.out.println("Menu gestion Garage");
		System.out.println("1.  Ajouter un vehicule");
		System.out.println("2.  Voir les vehicules");
		System.out.println("3.  Retour");
	}
	
	public static int choixMenuGestionGarage() {
		System.out.println("Veuillez saisir votre choix : ");
		int choix = Integer.parseInt(scanner.nextLine());

		switch (choix) {
		case 1:
			
			break;
		case 2:
			
			break;
		default:
			break;
		}				

		return choix;
	}
	
	public static void afficherGarages() {
		List<Garage> garages = garageService.recupererGarages();
		
		for (Garage garage : garages) {
			System.out.println(garage.getId() + " " + garage.getNom());
		}
	}
	
	public static void gererGarage() {
		System.out.println("Sélectionnez un garage dans la liste :");
		afficherGarages();
		int id = Integer.parseInt(scanner.nextLine());
		Garage garageTrouve = garageService.recupererGarage(id);
		
		if (garageTrouve == null) {
			throw new GarageNonTrouveException(id);
		}
		
		garageSelectionne = garageTrouve;
		
		int choix = 0;
		
		while (choix != 3) {
			afficherMenuGestionGarage();

			try {
				choix = choixMenuGestionGarage();
			}
			catch(NumberFormatException e) {
				System.out.println("Merci de saisir un nombre");
			}

		}
	}
	
	public static void ajouterVoiture() {
		System.out.println("Ajout d'un vehicule");
		
		System.out.print("Entrez le nom du véhicule : ");
		String nom = scanner.nextLine();
		System.out.print("Entrez le prix du véhicule : ");		
		double prix = Double.parseDouble(scanner.nextLine());
		System.out.println("Sélectionner la marque :");
		afficherMarque();
		Marque marque = choixMarque();
		System.out.println("Sélectionner un moteur :");
		afficherMoteurs();
		Moteur moteur = choixMoteur();
		System.out.print("Entrez le nombre de chevaux : ");		
		int chevaux = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez le nombre de porte : ");		
		int nbPorte = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez le nombre de siège : ");		
		int nbSiege = Integer.parseInt(scanner.nextLine());
		System.out.print("Entrez la taille du coffre : ");		
		int tailleCoffre = Integer.parseInt(scanner.nextLine());
		
		Voiture voiture = new Voiture(nom, prix, marque, moteur, chevaux, nbPorte, nbSiege, tailleCoffre);
		vehiculeService.ajouterVehicule(voiture);
	}
	
	public static void afficherVehicules() {
		System.out.println("Véhicules :");
		
		List<Vehicule> vehicules = vehiculeService.recupererVehicules();
		
		for(Vehicule vehicule : vehicules) {
			vehicule.afficher();
		}
	}
	
	public static void ajouterMoteur() {
		System.out.println("Ajout d'une option");
		System.out.println("Sélectionner le type de moteur :");
		afficherTypeMoteur();
		TypeMoteur typeMoteur = choixTypeMoteur();
		System.out.print("Entrez la puissance du moteur :");
		int puissance = Integer.parseInt(scanner.nextLine());
		
		Moteur moteur = new Moteur(puissance, typeMoteur);
		moteurService.ajouterMoteur(moteur);
	}

	public static void afficherMoteurs() {
		System.out.println("Moteurs :");
		
		List<Moteur> moteurs = moteurService.recupererMoteurs();
		
		for(Moteur moteur : moteurs) {
			moteur.afficher();
		}
	}	
	
	public static Moteur choixMoteur() {
		Moteur moteur;
		
		int id = Integer.parseInt(scanner.nextLine());
		
		moteur = moteurService.recupererMoteur(id);
		
		return moteur;
	}
	
	public static void afficherTypeMoteur() {
		int i = 1;
		
		for (TypeMoteur typeMoteur : TypeMoteur.values()) {
		    System.out.println(i + ". " + typeMoteur); 
		    i++;
		}
	}
	
	public static TypeMoteur choixTypeMoteur() {
		TypeMoteur typeMoteur;
		
		int choix = Integer.parseInt(scanner.nextLine());
		
		typeMoteur = TypeMoteur.values()[choix - 1];
		
		return typeMoteur;
	}
	
	public static void afficherMarque() {
		int i = 1;
		
		for (Marque marque : Marque.values()) {
		    System.out.println(i + ". " + marque); 
		    i++;
		}
	}
	
	public static Marque choixMarque() {
		Marque marque;
		
		int choix = Integer.parseInt(scanner.nextLine());
		
		marque = Marque.values()[choix - 1];
		
		return marque;
	}

	public static void ajouterOption() {

		System.out.println("Ajout d'une option");
		System.out.print("Entrez le nom de l'option : ");
		String nom = scanner.nextLine();
		System.out.print("Entrez le prix de l'option : ");
		double prix = Double.parseDouble(scanner.nextLine());
		
		Option option = new Option(nom, prix);
		optionService.ajouterOption(option);
	}
	
	public static void afficherOptions() {
		System.out.println("Moteurs :");
		
		List<Option> options = optionService.recupererOptions();
		
		for(Option option : options) {
			option.afficher();
		}
	}
}
