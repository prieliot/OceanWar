package controle;

import element.*;
import affichage.*;
import modele.*;

public class Simulation {
	
	// Pour gerer les id uniques de tous les affichables de la simulation
	private static int compteurIdUniques = 0;
	public static int idUnique() {
		++compteurIdUniques;
		return compteurIdUniques;
	}
	
	// variable pour generation semi-aléatoire des bateaux
	private static final double facteurGerme = 0.75;
	private static final double germeNombreCombattant = 7;
	private static final double germeNombreHopital = 5;
	private static final double germeNombreCible = 30;
	
	private static final double vitesseDeSimulationEnHz = 6.0;
	
	// attributs
	private Ocean o;
	private int nbPas;
	private Affichage affichage;
	
	public Simulation(int nbPas) {
		if(nbPas < 1) throw new IllegalArgumentException("Nombre de pas non valide.");
//		this.affichage = new Console(Ocean.TAILLE_MATRICE);
		this.affichage = new Graphique(Ocean.TAILLE_MATRICE);
		this.nbPas = nbPas;
		this.o = new Ocean();
		usinerBateaux();
		
	}
	
	public void lancer() {
		for(int i = 0; i < nbPas; ++i) {
			o.pasDeSimulation();
			afficher(affichage);
		}
			
	}
	
	private void afficher(Affichage a) {
		for(int i = 0; i < o.nbElementsAffichables(); ++i)
			a.actualiserPosition(o.elementAffichableNo(i));
		a.actualiserAffichage(1.0 / vitesseDeSimulationEnHz);
	}
	
	private int calculerNombreDepuisGerme(double germe) {
		return (int) Math.floor((1 + germe) * facteurGerme + (Math.random() * germe));
	}
	
	private void usinerBateaux() {
		int nbCombattant = calculerNombreDepuisGerme(germeNombreCombattant);
		int nbCible = calculerNombreDepuisGerme(germeNombreCible);
		int nbHopital = calculerNombreDepuisGerme(germeNombreHopital);
		for(int i = 0; i < nbCombattant; ++i) o.ajouterBateauSurPositionAleatoire(new Combattant());
		for(int i = 0; i < nbCible; ++i) o.ajouterBateauSurPositionAleatoire(new Cible());
		for(int i = 0; i < nbHopital; ++i) o.ajouterBateauSurPositionAleatoire(new Hopital());
	}
	

	
}
