package Application;

import interfaceGraphique.FenetreMembre;

public class Administrateur extends Membre {

	public Administrateur(String pseudo, String password) {
		super(pseudo, password);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * Méthode pour bannir un membre
	 * Idée : penser à créer un concierge (comme l'an dernier) qui gère la liste des membres
	 * cette méthode retire simplement un membre de la liste
	 * 
	 * */
	public void bannirMembre(Membre m){
		Serveur.getInstance().bannirMembre(m);
	}
	/**
	 * 
	 * Méthode pour bannir un membre
	 * Idée : penser à créer un concierge (comme l'an dernier) qui gère la liste des membres
	 * cette méthode permet de certifier un membre
	 * 
	 * */
	public void certifierMembre(Membre m){
		Serveur.getInstance().certifierMembre(m);
	}
	
	public void bannirIP(String ipAdress){
		//TODO
	}
	

}
