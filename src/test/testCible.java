package test;

import static org.junit.Assert.*;
import modele.Coordonnee;
import modele.Direction;
import modele.Ocean;

import org.junit.Test;

import element.Cible;

public class testCible {

	Ocean o = new Ocean();
	Cible b = new Cible();
	Coordonnee c = new Coordonnee(5,5);
	
	
	@Test
	public void testDeterminerDirection() {
		o.ajouterBateau(b, c);
		assertTrue(b.determinerDirection() == Direction.E);
		
	}

}
