package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Application.Cours;
import Application.Membre;
import Application.Serveur;

class ServeurTest {
	
	Serveur s = Serveur.getInstance();
	Membre m = new Membre("Lucas", "1234", s);
	@Test
	void testInscrireUnMembre() {
		/**
		 * Doit v�rifier qu'un membre est inscrit
		 * */
		s.inscrireUnMembre(m);
		Assertions.assertTrue(s.getListeInscrit().contains(m), "Le membre est bien contenu");
		
	}

	@Test
	void testSeConnecter() {
		/**
		 * Doit v�rifier la connexion
		 * */
		m = s.seConnecter("Lucas", "1234");
		s.connecterUnMembre(m);
		Assertions.assertTrue(s.getListeCo().contains(m), "Le membre est bien inscrit");
		
	}
	
	@Test
	void testSeConnecterFauxMdp() {
		m = s.seConnecter("Lucas", "1234567");
		Assertions.assertNull(m);
	}

	@Test
	void testAjouterCours() {
		Cours c = new Cours("Math�matique");
		s.ajouterCours(c);
		Assertions.assertTrue(s.getListeCours().contains(c), "Le cours est bien cr�e");
	}

	@Test
	void testSupprimerCours() {
		Cours c = new Cours("Math�matique");
		s.ajouterCours(c);
		s.supprimerCours(c);
		Assertions.assertFalse(s.getListeCours().contains(c));
	}

	@Test
	void testGetCoursByName() {
		Cours c = new Cours("Math�matique");
		s.ajouterCours(c);
		Cours c2 = s.getCoursByName("Math�matique");
		Assertions.assertFalse(c.equals(c2));
	}

}
