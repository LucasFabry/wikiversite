package Application;

import interfaceGraphique.FenetreMembre;

public class Administrateur extends Membre {

	public Administrateur(String pseudo, String password) {
		super(pseudo, password);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * M�thode pour bannir un membre
	 * Id�e : penser � cr�er un concierge (comme l'an dernier) qui g�re la liste des membres
	 * cette m�thode retire simplement un membre de la liste
	 * 
	 * */
	public void bannirMembre(Membre m){
		//TODO
	}
	/**
	 * 
	 * M�thode pour bannir un membre
	 * Id�e : penser � cr�er un concierge (comme l'an dernier) qui g�re la liste des membres
	 * cette m�thode permet de certifier un membre
	 * 
	 * */
	public void certifierMembre(Membre m){
		//TODO
	}
	
	public void bannirIP(String ipAdress){
		//TODO
	}

}
