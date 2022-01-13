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
		 * Doit vérifier qu'un membre est inscrit
		 * */
		s.inscrireUnMembre(m);
		Assertions.assertTrue(s.getListeInscrit().contains(m), "Le membre est bien contenu");
		
	}

	@Test
	void testSeConnecter() {
		/**
		 * Doit vérifier la connexion
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
		Cours c = new Cours("Mathématique");
		s.ajouterCours(c);
		Assertions.assertTrue(s.getListeCours().contains(c), "Le cours est bien crée");
	}

	@Test
	void testSupprimerCours() {
		Cours c = new Cours("Mathématique");
		s.ajouterCours(c);
		s.supprimerCours(c);
		Assertions.assertFalse(s.getListeCours().contains(c));
	}

	@Test
	void testGetCoursByName() {
		Cours c = new Cours("Mathématique");
		s.ajouterCours(c);
		Cours c2 = s.getCoursByName("Mathématique");
		Assertions.assertFalse(c.equals(c2));
	}

}
