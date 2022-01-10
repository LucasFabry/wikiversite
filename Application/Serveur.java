package Application;

import interfaceGraphique.FenetreServeur;

import java.util.ArrayList;
import java.util.HashMap;


/*
 * 
 * Classe qui gère les connexions, les listes de connectés, etc...
 * Singleton
 * **/

public final class Serveur {
	private static Serveur instance;
	private ArrayList<Membre> membresCo = new ArrayList<Membre>();
	private ArrayList<Membre> listeMembres = new ArrayList<Membre>();
	private ArrayList<Membre> listeMembresBannis = new ArrayList<Membre>();
	private ArrayList<MembreCertifie> listeMembreCertifie = new ArrayList<MembreCertifie>();
	
	private Serveur(){}
	
	public static Serveur getInstance() {
        if (instance == null) {
            instance = new Serveur();
            
        }
        //On crée une fenêtre serveur qui permet aux membres de se connecter.
        new FenetreServeur(instance);
        return instance;
    }
	
	public void inscrireUnMembre(Membre m){
		this.listeMembres.add(m);
	}
	

	/**
	 * 
	 * Méthode qui permet de savoir si un membre avec le bon pseudo et le bon password existe dans la liste des membres.
	 * Retourne : le membre s'il existe, null sinon
	 * */
	public Membre seConnecter(String pseudo, String password){
		for(int i=0; i<listeMembres.size(); i++){
			if((listeMembres.get(i)).getPassword().equals(password) && listeMembres.get(i).getPseudo().equals(pseudo)){
				return listeMembres.get(i);
			}
		}
		return null;
	}
	
	public void connecterUnMembre(Membre m){
		this.membresCo.add(m);
	}
	
	
	//Retourne la liste des connectés
	public ArrayList<Membre> getListeCo(){
		return this.membresCo;
	}
	
	//Retourne la liste des inscrits
	public ArrayList<Membre> getListeInscrit(){
		return this.listeMembres;
	}
	
	//Bannir un membre
	
	
	//Membres certifiés
	
	

}
