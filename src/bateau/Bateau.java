package bateau;

import java.util.ArrayList;
import java.util.LinkedList;

import modele.Coordonee;
import modele.DIRECTION;
import affichage.Affichable;
import controle.Simulation;
/**
 * Contient les attributs et les mï¿½thodes permettant de gï¿½rer l'objet BATEAU.
 */
public abstract class Bateau implements Affichable {

	private static final int resistanceMax = 5;
	
	private int id;
	private int vies;
	private int rayonRadar = 3;
	private Coordonee position;
	private DIRECTION direction;
	
	public Bateau() {
		this.id = Simulation.idUnique();
		vies = resistanceMax;
	}
	
	public int id() {
		return id;
	}
	
	public int rayonRadar() {
		return rayonRadar;
	}
	
	public Coordonee position() {
		return position;
	}
	public void position(Coordonee destination) {
		this.position = destination;
	}
	public void position(DIRECTION dir) {
		if(dir != null)
			this.position(this.position().coordoneeDansDirection(dir));
	}
	
	
	protected DIRECTION direction() {
		return direction;
	}
	protected void direction(DIRECTION d) {
		direction = d;
	}
	
	public int vies() {
		return vies;
	}
	public void toucher() { 
		vies--;
	}
	public void reparer() { 
		vies = resistanceMax;
	}
	
	public abstract String toString();
	
	public abstract void infosRadar(ArrayList<LinkedList<Bateau>> radar) ;
	public abstract void jouerPas() ;
		
}