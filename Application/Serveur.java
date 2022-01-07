package Application;

import java.util.ArrayList;


/*
 * 
 * Classe qui gère les connexions, les listes de connectés, etc...
 * Singleton
 * **/

public final class Serveur {
	private static Serveur instance;
	private ArrayList membresCo = new ArrayList<Membre>();
	private ArrayList listeMembres = new ArrayList<Membre>();
	private ArrayList listeMembresBannis = new ArrayList<Membre>();
	private ArrayList listeMembreCertifie = new ArrayList<MembreCertifie>();
	
	public Serveur(){
		if (instance == null) {
            instance = new Serveur();
        }
	}
	
	public static Serveur getInstance() {
        if (instance == null) {
            instance = new Serveur();
        }
        return instance;
    }
	
	public void connecterUnMembre(Membre m){
		this.membresCo.add(m);
	}
	
	public ArrayList getListeMembresBannis(){
		return this.listeMembresBannis;
	}
	
	public void bannirMembre(Membre m){
		this.listeMembresBannis.add(m);
		this.listeMembres.remove(m);
		
	}
	/**
	 * 
	 * Méthode pour bannir un membre
	 * Idée : penser à créer un concierge (comme l'an dernier) qui gère la liste des membres
	 * cette méthode permet de certifier un membre
	 * 
	 * */
	public void certifierMembre(Membre m){
		//TODO
		MembreCertifie mc = new MembreCertifie(m.getPseudo(), m.getPassword());
		this.listeMembreCertifie.add(m);
		m=null;
	}	

}
